/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of VisitDbSql.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.Visit;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.db.DbException;
import domain.db.ObjectDb;
import domain.db.checkup.CheckupDbSql;
import domain.model.measures.Checkup;
import domain.model.measures.Circumferences;
import domain.model.measures.Heights;
import domain.model.measures.Weights;
import domain.model.visit.Visit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VisitDbSql extends ObjectDb implements VisitDb {
    ObjectMapper jsonConverter = new ObjectMapper();

    public VisitDbSql(Properties p) {
        super(p);
    }

    //get old version
    /*@Override
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
    }*/

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

    //add old version
    /*@Override
    public void add(Visit visit, int cureId){
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){
            String querie = "INSERT INTO bezoek(bezoekid, moment,commentaar ,kuurid) values (?,?,?,?)";
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
    }*/

    @Override
    public void add(Visit visit, int cureId){
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){
            String querie = "INSERT INTO bezoek(bezoekid, moment, controle, commentaar,kuurid) values (?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,getNewRandomId());
            statementp.setTimestamp(2,visit.getMoment());
            String checkupJSON = "";
            try {
                checkupJSON = jsonConverter.writeValueAsString(visit.getCheckup());
            }catch (Exception e){
               throw new DbException("adding visit to DB failed, checkup couldn't be parsed to JSON\n\n" + e.getMessage());
            }
            statementp.setString(3,checkupJSON);
            statementp.setString(4,visit.getComment());
            statementp.setInt(5,cureId);

            statementp.execute();
            statementp.close();
        }catch (Exception se){
            throw new DbException("adding visit to database failed!");
        }
    }

    //getAllFromCure old version
    /*@Override
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
    }*/

    @Override
    public List<Visit> getAllFromCure(int cureId){
        List<Visit> visits = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties());
             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery("SELECT * FROM bezoek");
            while (result.next()) {
                int visitId = result.getInt("bezoekid");
                String comment = result.getString("commentaar");
                Checkup checkup;
                try {
                    checkup = jsonConverter.readValue(result.getString("controle"), Checkup.class);
                }catch (Exception e){
                    if(e.getClass()==NullPointerException.class){
                        checkup = new Checkup(new Heights(),new Weights(), new Circumferences());
                    }else{
                        throw new DbException("retreiving all visits from DB failed, JSON couldn't be parsed to Checkup object\n\n" + e.getMessage());
                    }
                }
                Timestamp moment = result.getTimestamp("moment");
                visits.add(new Visit(moment, checkup, comment));
            }
        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return visits;
    }

    //getLatest old version
    /*@Override
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
    }*/

    @Override
    public Visit getLatest(int cureId) {
        Visit visit = null;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT bezoekid,moment,controle,commentaar FROM bezoek where kuurid = ? ORDER BY moment DESC LIMIT 1";
            //SELECT kuurid FROM excellplus where klantid = 1936 ORDER BY startdatum DESC LIMIT 1
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,cureId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                int visitId = result.getInt("bezoekid");
                Timestamp moment = result.getTimestamp("moment");
                Checkup checkup;
                try {
                    checkup = jsonConverter.readValue(result.getString("controle"), Checkup.class);
                }catch (Exception e){
                    if(e.getClass()==NullPointerException.class){
                        checkup = new Checkup(new Heights(),new Weights(), new Circumferences());
                    }else{
                        throw new DbException("retreiving the latest visit from DB failed, JSON couldn't be parsed to Checkup object\n\n" + e.getMessage());

                    }
                }
                String comment = result.getString("commentaar");
                visit = new Visit(moment,checkup,comment);
            }

        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return visit;
    }

    @Override
    public int getLatestVisitId(int cureId){
        int visitId = 0;
        Visit visit = null;
        CheckupDbSql checkupDbSql = new CheckupDbSql(getProperties());
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT bezoekid FROM bezoek where kuurid = ? ORDER BY moment DESC LIMIT 1";
            //SELECT kuurid FROM excellplus where klantid = 1936 ORDER BY startdatum DESC LIMIT 1
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,cureId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                visitId = result.getInt("bezoekid");
            }
            if(visitId == 0) throw new DbException("getLatestVisitId failed, id is null");

        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return visitId;
    }

}
