/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of CircumferencesDbSql.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.measures.circumferences;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.model.measures.Circumferences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class CircumferencesDbSql extends ObjectDb implements CircumferencesDb {
    public CircumferencesDbSql(Properties p) {
        super(p);
    }

    @Override
    public void update(Circumferences circumferences, int clientId) {
        try {
            throw new InstantiationException("updating circumferences to database failed: method is not implemented yet");
        } catch (Exception e) {
            System.out.println("updating circumferences to database failed: method is not implemented yet");
        }
    }

    @Override
    public Circumferences get(int controleId) {
        Circumferences circumferences = null;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            System.out.println("Circumferences query started");
            String querie= "SELECT * FROM omtrekken where controleid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,controleId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                circumferences = new Circumferences();
                int heightsId = result.getInt("hoogtesid");
                circumferences.setKnee(result.getDouble("knie"));
                circumferences.setThigh(result.getDouble("dij"));
                circumferences.setWaist(result.getDouble("taille"));
                circumferences.setArm(result.getDouble("arm"));
                circumferences.setHip(result.getDouble("heup"));
                circumferences.setCalf(result.getDouble("kuit"));
                //circumferences.setComment(result.getString("commentaar"));
            }
            System.out.println("Circumferences query ended");
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return circumferences;
    }

    @Override
    public void add(Circumferences circumferences, int controleId) {
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){

            String querie = "INSERT INTO omtrekken(omtrekkenid,controleid, knieomtrek, dijomtrek, tailleomtrek, armomtrek, heupomtrek, kuitomtrek) values (?,?,?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,getNewRandomId());
            statementp.setDouble(2,controleId);
            statementp.setDouble(3,circumferences.getKnee());
            statementp.setDouble(4,circumferences.getThigh());
            statementp.setDouble(5,circumferences.getWaist());
            statementp.setDouble(6,circumferences.getArm());
            statementp.setDouble(7,circumferences.getHip());
            statementp.setDouble(8,circumferences.getCalf());

            statementp.execute();
            statementp.close();
        }catch (Exception se){
            throw new DbException(se.getMessage());
        }
    }

    @Override
    public void delete(int clientId) {
        try {
            throw new InstantiationException("deleting circumferences to database failed: method is not implemented yet");
        } catch (Exception e) {
            System.out.println("deleting circumferences to database failed: method is not implemented yet");
        }
    }
}
