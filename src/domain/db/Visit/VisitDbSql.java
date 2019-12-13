/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of VisitDbSql.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.Visit;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.db.checkup.CheckupDb;
import domain.db.checkup.CheckupDbSql;
import domain.model.visit.Visit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VisitDbSql extends ObjectDb implements VisitDb {
    CheckupDb checkupDb = new CheckupDbSql(getProperties());

    public VisitDbSql(Properties p) {
        super(p);
    }

    @Override
    public Visit get(int cureId) {
        Visit visit = null;
        CheckupDbSql checkupDbSql = new CheckupDbSql(getProperties());
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT bezoekid,moment,commentaar FROM bezoek where kuurid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,cureId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                int visitId = result.getInt("bezoekid");
                Timestamp moment = result.getTimestamp("moment");
                String comment = result.getString("commentaar");
                visit = new Visit(moment,checkupDbSql.get(visitId),comment);
            }

        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return visit;
    }

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
    public void add(Visit visit, int cureId){
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){
            String querie = "INSERT INTO bezoek(hoogtesid, moment,commentaar ,kuurid) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,getNewRandomId());
            statementp.setTimestamp(2,visit.getMoment());
            statementp.setString(3,visit.getComment());
            statementp.setInt(4,cureId);

            statementp.execute();
            statementp.close();
        }catch (Exception se){
            throw new DbException("adding visit to database failed!");
        }
    }

    @Override
    public List<Visit> getAllFromCure(int cureId){
        List<Visit> visits = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());
             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery("SELECT * FROM bezoek");
            while (result.next()) {
                int visitId = result.getInt("bezoekid");
                String comment = result.getString("commentaar");
                Timestamp moment = result.getTimestamp("moment");
                visits.add(new Visit(moment, checkupDb.get(visitId), comment));
            }
        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return visits;
    }

    @Override
    public Visit getLatest(int cureId) {
        Visit visit = null;
        CheckupDbSql checkupDbSql = new CheckupDbSql(getProperties());
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT bezoekid,moment,commentaar FROM bezoek where kuurid = ? ORDER BY moment DESC LIMIT 1";
            //SELECT kuurid FROM excellplus where klantid = 1936 ORDER BY startdatum DESC LIMIT 1
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,cureId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                int visitId = result.getInt("bezoekid");
                Timestamp moment = result.getTimestamp("moment");
                String comment = result.getString("commentaar");
                visit = new Visit(moment,checkupDbSql.get(visitId),comment);
            }

        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return visit;
    }

}
