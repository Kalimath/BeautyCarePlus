package domain.db.client;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.model.personal.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ClientDbSql extends ObjectDb implements ClientDb {
    public ClientDbSql(Properties p) {
        super(p);
    }

    //needs to be rewritten
    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());
             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery("SELECT * FROM klant");

            while (result.next()) {
                int clientId = result.getInt("klantid");
                String name = result.getString("naam");
                LocalDate birth = result.getDate("gebdatum").toLocalDate();
                String email = result.getString("email");
                String phone = result.getString("telefoonnr");
                String comment = result.getString("commentaar");
                Client client = new Client(name, email, phone, birth);
                client.setComment(comment);
                clients.add(client);
            }
            statement.close();
            connection.close();
        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return clients;
    }


    //written not tested
    @Override
    public void add(Client client) {
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())) {

            int klantid = getNewRandomId();
            String name = client.getName();
            LocalDate birthDate = client.getBirthDate();
            String email = client.getEmail();
            String phone = client.getPhone();
            String comment = client.getComment();
            String querie = "INSERT INTO klant(klantid, naam, gebdatum, email, commentaar, telefoonnr) values (?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, klantid);
            statementp.setString(2, name);
            statementp.setDate(3, Date.valueOf(birthDate));
            statementp.setString(4, email);
            statementp.setString(5, comment);
            statementp.setString(6, phone);
            statementp.execute();
            statementp.close();
        } catch (Exception se) {
            throw new DbException(se.getMessage());
        }
    }

    //needs to be written
    @Override
    public void update(Client client) {
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())) {
            String name = client.getName();
            LocalDate birthDate = client.getBirthDate();
            String email = client.getEmail();
            String phone = client.getPhone();
            String comment = client.getComment();
            String querie = "update klant set gebdatum = ?, telefoonnr = ?, email = ?, commentaar = ? where naam = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setString(1, phone);
            statementp.setDate(2, Date.valueOf(birthDate));
            statementp.setString(3, email);
            statementp.setString(4, comment);
            statementp.setString(5, name);
            statementp.execute();
            statementp.close();
        } catch (Exception se) {
            throw new DbException(se.getMessage());
        }
    }

    //written not tested
    @Override
    public void delete(int clientId) {
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());) {
            String querie = "DELETE from klant where klantid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, clientId);
            statementp.execute();
            statementp.close();

        } catch (Exception se) {
            throw new DbException(se.getMessage());
        }
    }

    @Override
    public int getClientId(String clientName) {
        int clientId = 0;
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());
        ) {
            String querie = "select klantid from klant where naam = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setString(1,clientName);
            ResultSet result = statementp.executeQuery();
            result.next();
            clientId = result.getInt("klantid");

        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return clientId;
    }

    //written not tested
    @Override
    public Client get(String clientName) {
        Client client = null;
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());
             Statement statement = connection.createStatement()) {
            String querie = "select * from klant where naam = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            ResultSet result = statementp.executeQuery();
            result.next();
            String name = result.getString("naam");
            LocalDate birth = result.getDate("gebdatum").toLocalDate();
            String email = result.getString("email");
            String phone = result.getString("telefoonnr");
            String comment = result.getString("commentaar");

            client = new Client(name, email, phone, birth);
            client.setComment(comment);

        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return client;
    }

    //written not tested
    @Override
    public Client get(int clientId) {
        Client client = null;
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())) {
            String querie = "select * from klant where klantid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, clientId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                String name = result.getString("naam");
                LocalDate birth = result.getDate("gebdatum").toLocalDate();
                String email = result.getString("email");
                String phone = result.getString("telefoonnr");
                String comment = result.getString("commentaar");

                client = new Client(name, email, phone, birth);
                client.setComment(comment);
            }
        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return client;
    }


}
