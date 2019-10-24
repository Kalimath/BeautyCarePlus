/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of CheckupDbSql.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.checkup;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.db.measures.circumferences.CircumferencesDb;
import domain.db.measures.circumferences.CircumferencesDbSql;
import domain.db.measures.heights.HeightsDb;
import domain.db.measures.heights.HeightsDbSql;
import domain.db.measures.weights.WeightsDb;
import domain.db.measures.weights.WeightsDbSql;
import domain.model.measures.Checkup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CheckupDbSql extends ObjectDb implements CheckupDb {
    private HeightsDb heightsDb = new HeightsDbSql(getProperties());
    private WeightsDb weightsDb = new WeightsDbSql(getProperties());
    private CircumferencesDb circumferencesDb = new CircumferencesDbSql(getProperties());

    public CheckupDbSql(Properties p) {
        super(p);
    }

    @Override
    public Checkup get(int visitId) {
        Checkup checkup = null;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties());
        ) {
            String querie = "SELECT * FROM controle where bezoekid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, visitId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                int checkupId = result.getInt("controleid");
                Date date = result.getDate("datum");
                int weightsId = result.getInt("wegingid");
                int circumferencesId = result.getInt("omtrekkenid");
                String comment = result.getString("commentaar");
                checkup = new Checkup(heightsDb.get(getCheckupClientId(visitId)),weightsDb.get(weightsId),circumferencesDb.get(circumferencesId));
            }

        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return checkup;
    }
    
    public int getCheckupClientId(int visitId){
        int clientId = 0;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties());
        ) {
            String querie = "SELECT e.klantid FROM controle c natural join excellplus e where bezoekid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, visitId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                clientId = result.getInt("klantid");
            }

        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return clientId;
    }

    //withCheckup method
    /*@Override
    public boolean withCheckup(int visitId){
        Boolean withChekup = false;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties());
             Statement statement = connection.createStatement()){
            String querie= "SELECT bezoekid FROM controle";
            ResultSet result = statement.executeQuery(querie);
            List<Integer> ids = new ArrayList<>();
            while (result.next()) {
                ids.add(result.getInt("bezoekid"));
            }
            if(ids.contains(visitId)) withChekup = true;
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return withChekup;
    }*/

    @Override
    public void add(Checkup checkup) {
        try {
            throw new InstantiationException("adding checkup to database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public List<Checkup> getAllFromCure(int visitId) {
        try {
            throw new InstantiationException("getting all checkups of cure from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Checkup> getAllFromClient(int visitId) {
        try {
            throw new InstantiationException("getting all checkups of client from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
        return null;
    }
}
