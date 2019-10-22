package domain.db.address;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.model.personal.Address;
import domain.observer.Observer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class AddressDbSql extends ObjectDb implements AddressDb {

    public AddressDbSql(Properties properties) {
        super(properties);
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void add(int clientId,Address address) {
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){

            int adresId = getNewRandomId();
            String place = address.getPlace();
            String street = address.getStreet();
            int zip = address.getZip();
            String housenumber = address.getNumber();
            String querie = "INSERT INTO adres(adresid,plaats,straat,zip,huisnrenbus,klantid) values (?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,adresId);
            statementp.setString(2,place);
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


    public void update(int clientId,Object addressO) {
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){
            Address address;
            if (addressO instanceof Address) {
                address = (Address) addressO;
            } else {
                throw new InstantiationException("adding address to database failed: object ain't an instance of address"+this.getClass().getSimpleName());
            }
            int adresId = getNewRandomId();
            String place = address.getPlace();
            String street = address.getStreet();
            int zip = address.getZip();
            String housenumber = address.getNumber();
            String querie = "INSERT INTO adres(adresid,plaats,straat,zip,huisnrenbus,klantid) values (?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,adresId);
            statementp.setString(2,place);
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

    @Override
    public void delete(int id) {

    }

    public Address get(int clientId){
        Address res = null;
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());
             Statement statement = connection.createStatement()){
            if(clientId==0) throw new DbException("client's address couldn't be retrieved: id equals 0,"+this.getClass().getSimpleName());
            ResultSet result = statement.executeQuery("SELECT * FROM adres where klantid = "+clientId);
            result.next();
                int id = result.getInt("adresid");
                String place = result.getString("plaats");
                String street = result.getString("straat");
                int zip = result.getInt("zip");
                String housenr = result.getString("huisnrenbus");
                res = new Address(zip,place,housenr,street);

        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return res;
    }

    @Override
    public List<Object> getAll() {
        List<Object> objects = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());
             Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM adres");

            while (result.next()) {
                String place = result.getString("place");
                String street = result.getString("straat");
                int zip = result.getInt("zip");
                String housenr = result.getString("huisnrenbus");
                objects.add(new Address(zip,place,housenr,street));
            }
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return null;
    }

}
