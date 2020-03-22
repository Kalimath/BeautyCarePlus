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
    public CircumferencesDbSql(Properties p){
        super(p);
    }

    @Override
    public void update(Circumferences circumferences, int clientId){
        System.out.println("updating circumferences to database failed: method is not implemented yet");
    }

    @Override
    public Circumferences get(int controleId){
        Circumferences circumferences = null;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())) {
            System.out.println("Circumferences query started");
            String querie = "SELECT * FROM omtrekken inner join controle on (omtrekken.omtrekkenid=controle.omtrekkenid) where controle.controleid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, controleId);
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
                circumferences.setComment(result.getString("opmerking"));
            }
            System.out.println("Circumferences query ended");
        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return circumferences;
    }

    @Override
    public void add(Circumferences circumferences, int circumferencesId){
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())) {
            System.out.println("Circumferences query ADD started");
            String querie = "INSERT INTO omtrekken(omtrekkenid, knieomtrek, dijomtrek, tailleomtrek, armomtrek, heupomtrek, kuitomtrek, opmerking) values (?,?,?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, getNewRandomId());
            statementp.setDouble(2, circumferences.getKnee());
            statementp.setDouble(3, circumferences.getThigh());
            statementp.setDouble(4, circumferences.getWaist());
            statementp.setDouble(5, circumferences.getArm());
            statementp.setDouble(6, circumferences.getHip());
            statementp.setDouble(7, circumferences.getCalf());
            statementp.setString(8, circumferences.getComment());

            statementp.execute();
            statementp.close();
        } catch (Exception se) {
            throw new DbException(se.getMessage());
        }
        System.out.println("Circumferences query ADD ended");
    }

    @Override
    public void delete(int clientId){
        System.out.println("deleting circumferences to database failed: method is not implemented yet");
    }
}
