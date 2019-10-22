package domain.db.excellPlusCure;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.model.cure.ExcellPlusCure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;

public class ExcellPlusCureDbSql extends ObjectDb implements ExcellPlusCureDb {
    public ExcellPlusCureDbSql(Properties p) {
        super(p);
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    public List<ExcellPlusCure> getAllFromClient(int clientId) {
        return null;
    }

    @Override
    public void add(int clientId, ExcellPlusCure cure) {
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){

            int cureId = getNewRandomId();
            int turnsLeft = cure.getTurnsLeft();
            String startDate = cure.;
            int zip = cure.getZip();
            String housenumber = cure.getNumber();
            String querie = "INSERT INTO adres(kuurid,beurtenover,startdatum,einddatum,klantid) values (?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,cureId);
            statementp.setInt(2,turnsLeft);
            statementp.setString(3,street);
            statementp.setInt(4,zip);
            statementp.setString(5,housenumber);
            statementp.setInt(6,clientId);

            statementp.execute();
            statementp.close();
            connection.close();
        }catch (Exception se){
            throw new DbException(se.getMessage());
        }
    }
}
