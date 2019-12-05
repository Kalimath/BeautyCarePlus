package domain.db.excellPlusCure;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.db.Visit.VisitDb;
import domain.db.Visit.VisitDbSql;
import domain.model.cure.ExcellPlusCure;
import domain.model.visit.Visit;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class ExcellPlusCureDbSql extends ObjectDb implements ExcellPlusCureDb {
    private VisitDb visitDb = new VisitDbSql(getProperties());
    public ExcellPlusCureDbSql(Properties p) {
        super(p);
    }


    @Override
    public void update(ExcellPlusCure cure, int clientId) {
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){

            int totalTurns = cure.getTurnsTotal();
            int turnsLeft = cure.getTurnsLeft();
            Date cureStart = cure.getCureStart();
            String querie = "UPDATE excellplus SET beurtenover=?, startdatum=?, aantalbeurten=? WHERE klantid=?";
            PreparedStatement statementp = connection.prepareStatement(querie);

            statementp.setInt(1,turnsLeft);
            statementp.setDate(2,new java.sql.Date(cureStart.getTime()));
            statementp.setInt(3,totalTurns);
            statementp.setInt(4,clientId);

            statementp.execute();
            statementp.close();

        } catch (Exception e) {
            System.out.println("update Excell+ is not error-proof yet");

        }
        System.out.println("excell+ has been updated");
    }

    @Override
    public void delete(int clientId) {
        try (Connection connection = DriverManager.getConnection(this.getUrl(), this.getProperties())){
            String querie = "DELETE from adres where klantid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,clientId);
            statementp.execute();
            statementp.close();
        }catch (Exception se){
            throw new DbException(se.getMessage());
        }
    }

    @Override
    public ExcellPlusCure get(int clientId) {
        ExcellPlusCure excellPlusCure = null;
        int cureId = 0;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT kuurid,beurtenover,startdatum,aantalbeurten FROM excellplus where klantid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,clientId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                cureId = result.getInt("kuurid");
                int turnsleft = result.getInt("beurtenover");
                java.sql.Date cureStart = result.getDate("startdatum");
                int turnsTotal = result.getInt("aantalbeurten");
                excellPlusCure = new ExcellPlusCure(cureStart,turnsleft,turnsTotal);
                excellPlusCure.setVisits(visitDb.getAllFromCure(cureId));
            }
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        VisitDbSql visitDb = new VisitDbSql(getProperties());
        List<Visit> visits = visitDb.getAllFromCure(cureId);
        excellPlusCure.setVisits(visits);


        return  excellPlusCure;
    }

    @Override
    public ExcellPlusCure getCurrent(int clientId) {
        ExcellPlusCure excellPlusCure = null;
        int cureId = 0;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT * FROM excellplus where klantid = ? and beurtenover>0 LIMIT 1";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,clientId);
            ResultSet result = statementp.executeQuery();
            if(result.next()) {
                cureId = result.getInt("kuurid");
                int turnsleft = result.getInt("beurtenover");
                java.sql.Date cureStart = result.getDate("startdatum");
                int turnsTotal = result.getInt("aantalbeurten");
                excellPlusCure = new ExcellPlusCure(cureStart,turnsleft,turnsTotal);
                excellPlusCure.setVisits(visitDb.getAllFromCure(cureId));
            }
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return  excellPlusCure;
    }

    @Override
    public int getCurrentExcellPlusCureId(int clientId) {
        int cureId = 0;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT kuurid FROM excellplus where klantid = ? ORDER BY startdatum DESC LIMIT 1";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,clientId);
            ResultSet result = statementp.executeQuery();
            if(result.next()) {
                cureId = result.getInt("kuurid");
            }
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return  cureId;
    }

    @Override
    public int getNumberOfPastCures(int clientId) {
        int pastCures = 0;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT count(kuurid) as pastCures FROM excellplus where klantid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,clientId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                pastCures = result.getInt("pastCures");
            }
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return  pastCures;
    }

     @Override
    public List<ExcellPlusCure> getPastCures(int clientId) {
        List<ExcellPlusCure> pastCures = getAllFromClient(clientId);
        pastCures.remove(getCurrent(clientId));
        return pastCures;
    }

    public List<ExcellPlusCure> getAllFromClient(int clientId) {
        try {
            throw new InstantiationException("getting all cures from client with id from database failed: method is not implemented yet");
        } catch (Exception e) {
            System.out.println("get all Excell+ from client is not implemented yet");
        }
        return null;
    }

    @Override
    public void add(int clientId, ExcellPlusCure cure) {
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){

            int cureId = getNewRandomId();
            int turnsLeft = cure.getTurnsLeft();
            Date cureStart = cure.getCureStart();
            String querie = "INSERT INTO excellplus(kuurid,beurtenover,startdatum,klantid) values (?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,cureId);
            statementp.setInt(2,turnsLeft);
            statementp.setDate(3,new java.sql.Date(cureStart.getTime()));
            statementp.setInt(4,clientId);

            statementp.execute();
            statementp.close();
            connection.close();
        }catch (Exception se){
            throw new DbException(se.getMessage());
        }
    }
}
