package domain.db.user;
import domain.db.DbException;
import domain.model.Role;
import domain.model.User;

import java.sql.*;
import java.util.*;

public class UserDbSql implements UserDb {
    private String url;
    private Properties properties;

    public UserDbSql(Properties p) {
       this.properties = p;
       this.url = this.properties.getProperty("url");
    }



    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, properties);
        Statement statement = connection.createStatement()){

            ResultSet result = statement.executeQuery("SELECT * FROM user");
            while (result.next()) {
                int userid = result.getInt("userid");
                String name = result.getString("voornaam");
                String surname = result.getString("achternaam");
                String email = result.getString("email");
                String pswd = result.getString("password");
                Role role = Role.valueOf(result.getString("role"));
                User user = new User(userid,name,surname,email,pswd,role);
                users.add(user);
            }
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return users;
    }

    @Override
    public void update(User newUser) {

    }

    @Override
    public User get(String email) {
        User user = null;
        try (Connection connection = DriverManager.getConnection(url, properties);
             ){
            String querie= "SELECT * FROM user where email = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setString(1,email);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                int userid = result.getInt("userid");
                String name = result.getString("voornaam");
                String surname = result.getString("achternaam");
                String pswd = result.getString("password");
                Role role = Role.valueOf(result.getString("role"));
                user = new User(userid,name,surname,email,pswd,role);

            }
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return user;
    }

    //written not tested
    @Override
    public void add(User user) {
        try(Connection connection = DriverManager.getConnection(url, properties)){
            int userid = user.getUserId();
            String email = user.getEmail();
            String name = user.getFirstName();
            String surname = user.getLastName();
            String passHashed = user.getPassword();
            String role = user.getRole();
            String querie= "INSERT INTO user(userid,email,voornaam,achternaam,password,role) values (?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,userid);
            statementp.setString(2,email);
            statementp.setString(3,name);
            statementp.setString(4,surname);
            statementp.setString(5,passHashed);
            statementp.setString(6,role);
            statementp.execute();
            statementp.close();
        }catch (Exception se){

            throw new DbException(se.getMessage());
        }
    }

    //written not tested
    @Override
    public void delete(String emailUser){
        try (Connection connection = DriverManager.getConnection(url, properties)){
            String querie = "DELETE from user where user.email = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setString(1,emailUser);
            statementp.execute();
            statementp.close();
        }catch (Exception se){
            throw new DbException(se.getMessage());
        }
    }

    //written not tested
    @Override
    public void delete(int userId){
        try (Connection connection = DriverManager.getConnection(url, properties)){
            String querie = "DELETE from user where klanten.user.userid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,userId);
            statementp.execute();
            statementp.close();
        }catch (Exception se){
            throw new DbException(se.getMessage());
        }
    }
}
