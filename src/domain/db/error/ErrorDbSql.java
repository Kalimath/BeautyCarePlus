package domain.db.error;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.model.debug.Error;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ErrorDbSql extends ObjectDb implements ErrorDb {

    public ErrorDbSql(Properties p) {
        super(p);
    }

    @Override
    public void deleteAll(int id) {
        try {
            throw new InstantiationException("deleting all errors from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public void add(Error error) {
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())) {
            String cause = error.getErrorMessage();
            Timestamp current = new Timestamp(System.currentTimeMillis());
            String querie = "INSERT INTO error(cause, moment) values (?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setString(1, cause);
            statementp.setTimestamp(2, current);
            statementp.execute();
            statementp.close();
        } catch (Exception e) {
            throw new DbException("adding error to database failed, " + this.getClass().getSimpleName());
        }
    }

    @Override
    public List<Object> getAll() {
        List<Object> errors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());
             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery("SELECT * FROM error");
            while (result.next()) {
                int errorId = result.getInt("errorid");
                String cause = result.getString("cause");
                Timestamp moment = result.getTimestamp("moment");
                errors.add(new Error(errorId, cause, moment));
            }
        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return errors;
    }

}
