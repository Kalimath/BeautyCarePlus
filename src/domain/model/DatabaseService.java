package domain.model;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.db.address.AddressDbSql;
import domain.db.client.ClientDbSql;
import domain.db.error.ErrorDbSql;
import domain.db.excellPlusCure.ExcellPlusCureDbSql;
import domain.db.heights.HeightsDbSql;
import domain.db.sport.SportDbSql;
import domain.db.user.UserDbSql;
import domain.model.cure.ExcellPlusCure;
import domain.model.debug.DomainException;
import domain.model.debug.Error;
import domain.model.measures.CheckUp;
import domain.model.personal.Address;
import domain.model.personal.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class DatabaseService {
    private Properties properties;
    private ObjectDb heightsDb, errorDb, sportDb;
    private ClientDbSql clientDb;
    private UserDbSql userDb;
    private ExcellPlusCureDbSql excellPlusCureDb;
    private AddressDbSql addressDb;

    public DatabaseService(Properties p) {
        setProperties(p);
        heightsDb = new HeightsDbSql(this.properties);
        userDb = new UserDbSql(this.properties);
        clientDb = new ClientDbSql(this.properties);
        errorDb = new ErrorDbSql(this.properties);
        addressDb = new AddressDbSql(this.properties);
        sportDb = new SportDbSql(this.properties);
        excellPlusCureDb = new ExcellPlusCureDbSql(this.properties);
    }

    //CHECKUP METHODS
    public List<CheckUp> getAllClientsCheckups(String name) {
        return null;
    }

    //USER METHODS
    public void addUser(User user) {
        try {
            userDb.add(user);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            e.printStackTrace();
        }

    }

    //LOCAL METHODS
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    //CLIENT METHODS
    public List<String> getClientnames() {

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

    public Client getClientWithName(String name) {
        return clientDb.get(name);
    }

    public Client getClientWithId(int clientId) {
        return clientDb.get(clientId);
    }

    public void updateClient(Client client) {
        try {
            clientDb.add(client);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            e.printStackTrace();
        }

    }

    public void addClient(Client client) {
        Object clientO = client;
        clientDb.add(clientO);
    }

    public void deleteClient(String name) {
        int clientId = clientDb.getClientId(name);
        clientDb.delete(clientId);
        addressDb.delete(clientId);
        sportDb.delete(clientId);
        heightsDb.delete(clientId);
    }

    public int getClientId(String name) {
        try {
            return clientDb.getClientId(name);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DbException("retrieving client's id from database failed in " + this.getClass().getSimpleName());
        }

    }

    public List<Client> getAllClients() {
        List<Object> clientsO = clientDb.getAll();
        List<Client> clients = new ArrayList<>();
        try {
            for (Object o : clientsO) {
                Client user = null;
                if (o instanceof Client) {
                    clients.add((Client) o);
                } else {
                    throw new DbException("retrieving clients from database failed: object ain't an instance of client," + this.getClass().getSimpleName());
                }
            }
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            e.printStackTrace();
        }
        return clients;
    }

    // EXCELLPLUSCURE METHODS
    public ExcellPlusCure getExcellPlusCureFromClientWithId(int clientId) {
        try {
            return (ExcellPlusCure) excellPlusCureDb.get(clientId);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No cure available for this client");
        }
    }

    public void updateExcellPlusCure(ExcellPlusCure cure) {
        try {

            this.excellPlusCureDb.update(cure);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No cure found for this client");
        }
    }

    public List<ExcellPlusCure> getAllExcellPlusCuresFromClientWithId(int clientId) {
        try {
            return excellPlusCureDb.getAllFromClient(clientId);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No cures found for this client");
        }
    }

    public void addExcellPlusCure(int clientId, ExcellPlusCure cure) {
        excellPlusCureDb.add(clientId,cure);
    }

    //ERROR METHODS
    public List<Error> getAllErrors() {
        List<Error> errors = new ArrayList<>();
        for(Object o : errorDb.getAll()){
            if(o instanceof Error){
                errors.add((Error) o);
            }
        }
        return errors;
    }


    public void addAddress(int clientId,Address tempAddress) {
        addressDb.add(clientId,tempAddress);
    }

    public Address getAddress(int clientId) {
        try {
            return addressDb.get(clientId);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No address available for this client");
        }
    }

    public User getUser(String email){
        try{
            return userDb.get(email);
        } catch (Exception e) {
            errorDb.add(new Error(e.getMessage()));
            throw new DomainException("No user found with email= \""+email+'\"');
        }
    }
}