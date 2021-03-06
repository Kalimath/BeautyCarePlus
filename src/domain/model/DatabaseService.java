package domain.model;

import domain.db.DbException;
import domain.db.Visit.VisitDb;
import domain.db.Visit.VisitDbSql;
import domain.db.address.AddressDb;
import domain.db.address.AddressDbSql;
import domain.db.checkup.CheckupDb;
import domain.db.checkup.CheckupDbSql;
import domain.db.client.ClientDb;
import domain.db.client.ClientDbSql;
import domain.db.error.ErrorDb;
import domain.db.error.ErrorDbSql;
import domain.db.excellPlusCure.ExcellPlusCureDb;
import domain.db.excellPlusCure.ExcellPlusCureDbSql;
import domain.db.measures.circumferences.CircumferencesDb;
import domain.db.measures.circumferences.CircumferencesDbSql;
import domain.db.measures.heights.HeightsDb;
import domain.db.measures.heights.HeightsDbSql;
import domain.db.measures.weights.WeightsDb;
import domain.db.measures.weights.WeightsDbSql;
import domain.db.sport.SportDb;
import domain.db.sport.SportDbSql;
import domain.db.user.UserDb;
import domain.db.user.UserDbSql;
import domain.model.cure.ExcellPlusCure;
import domain.model.debug.DomainException;
import domain.model.debug.Error;
import domain.model.measures.Checkup;
import domain.model.measures.Circumferences;
import domain.model.measures.Heights;
import domain.model.measures.Weights;
import domain.model.personal.Address;
import domain.model.personal.Client;
import domain.model.visit.Visit;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DatabaseService {
    private Properties properties;
    private HeightsDb heightsDb;
    private ErrorDb errorDb;
    private SportDb sportDb;
    private ClientDb clientDb;
    private UserDb userDb;
    private ExcellPlusCureDb excellPlusCureDb;
    private AddressDb addressDb;
    private CheckupDb checkupDb;
    private VisitDb visitDb;
    private CircumferencesDb circumferencesDb;
    private WeightsDb weightsDb;

    public DatabaseService(Properties p){
        setProperties(p);
        heightsDb = new HeightsDbSql(this.properties);
        userDb = new UserDbSql(this.properties);
        clientDb = new ClientDbSql(this.properties);
        errorDb = new ErrorDbSql(this.properties);
        addressDb = new AddressDbSql(this.properties);
        sportDb = new SportDbSql(this.properties);
        excellPlusCureDb = new ExcellPlusCureDbSql(this.properties);
        checkupDb = new CheckupDbSql(this.properties);
        visitDb = new VisitDbSql(this.properties);
        circumferencesDb = new CircumferencesDbSql(this.properties);
        weightsDb = new WeightsDbSql(this.properties);
    }

    //CHECKUP METHODS
    public List<Checkup> getAllClientsCheckups(String name){
        return null;
    }

    public Checkup getLatestCheckup(int clientId){
        Checkup latest = checkupDb.getFromLatestVisit(clientId);
        if(latest != null){
            return latest;
        }else{
            throw new NullPointerException("Databaseservice can't return empty object Checkup, in in method getLatestCheckup()");
        }

    }

    public void addVisitWithCheckup(Weights definedWeights, Circumferences definedCircumferences, int clientId){
        visitDb.add(new Visit(new Checkup(heightsDb.get(clientId),definedWeights,definedCircumferences)),excellPlusCureDb.getCurrentExcellPlusCureId(clientId));
    }

    //USER METHODS
    public void addUser(User user){
        try {
            userDb.add(user);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            e.printStackTrace();
        }

    }

    //LOCAL METHODS
    public Properties getProperties(){
        return properties;
    }

    public void setProperties(Properties properties){
        this.properties = properties;
    }

    //CLIENT METHODS
    public List<String> getClientnames(){

        List<String> names = new ArrayList<>();
        try {
            for (Client client : getAllClients()) {
                names.add(client.getName());
            }
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
        }
        return names;
    }

    public Client getClientWithName(String name){
        return clientDb.get(name);
    }

    public Client getClientWithId(int clientId){
        return clientDb.get(clientId);
    }

    public void updateClient(Client client){
        try {
            clientDb.add(client);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            e.printStackTrace();
        }

    }

    public void addClient(Client client){
        clientDb.add(client);
    }

    public void deleteClient(String name){
        int clientId = clientDb.getClientId(name);
        clientDb.delete(clientId);
        addressDb.delete(clientId);
        sportDb.delete(clientId);
        heightsDb.delete(clientId);
    }

    public int getClientId(String name){
        try {
            return clientDb.getClientId(name);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DbException("retrieving client's id from database failed in " + this.getClass().getSimpleName());
        }

    }

    public List<Client> getAllClients(){
        return clientDb.getAll();
    }

    // EXCELLPLUSCURE METHODS
    public ExcellPlusCure getExcellPlusCureFromClientWithId(int clientId){
        try {
            return (ExcellPlusCure) excellPlusCureDb.get(clientId);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No cure available for this client");
        }
    }

    public void updateExcellPlusCure(ExcellPlusCure cure, int clientId){
        try {
            this.excellPlusCureDb.update(cure, clientId);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No cure found for this client");
        }
    }

    public List<ExcellPlusCure> getAllExcellPlusCuresFromClientWithId(int clientId){
        try {
            return excellPlusCureDb.getAllFromClient(clientId);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No cures found for this client");
        }
    }

    public void addExcellPlusCure(int clientId, ExcellPlusCure cure){
        excellPlusCureDb.add(clientId, cure);
    }

    //ERROR METHODS
    public List<Error> getAllErrors(){
        List<Error> errors = new ArrayList<>();
        for (Object o : errorDb.getAll()) {
            if(o instanceof Error){
                errors.add((Error) o);
            }
        }
        return errors;
    }


    public void addAddress(int clientId, Address tempAddress){
        addressDb.add(clientId, tempAddress);
    }

    public Address getAddress(int clientId){
        try {
            return addressDb.get(clientId);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No address available for this client");
        }
    }

    public User getUser(String email){
        try {
            return userDb.get(email);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No user found with email= \"" + email + '\"');
        }
    }

    public Heights getHeightsFromClient(int clientId){
        Heights heights = null;
        try {
            heights = heightsDb.get(clientId);
        } catch (Exception e) {
            //System.out.println("getting heights of client from database failed: method is not implemented yet, "+ this.getClass().getSimpleName());
        }
        return heights;
    }

    public int getCurrentExcellPlusCureId(int clientId){
        return excellPlusCureDb.getCurrentExcellPlusCureId(clientId);
    }

    public void addHeightsFromClient(Heights clientHeights, int clientId){
        heightsDb.add(clientHeights, clientId);
    }


    public Visit getLatestVisit(int clientId){
        int cureId = excellPlusCureDb.getCurrentExcellPlusCureId(clientId);

        Visit latest = visitDb.getLatest(cureId);
        if(latest != null){
            return latest;
        }else{
            throw new NullPointerException("Databaseservice can't return empty object Visit, in in method getLatestVisit()");
        }
    }

    public void addVisitToday(int clientId){
        Visit visit = new Visit();
        visit.setMoment(new Timestamp(System.currentTimeMillis()));
        visitDb.add(visit, getCurrentExcellPlusCureId(clientId));
    }

    public void addVisit(Visit visit, int clientId){
        visitDb.add(visit,getCurrentExcellPlusCureId(clientId));
    }
}
