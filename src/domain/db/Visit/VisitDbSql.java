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
import domain.db.checkup.CheckupDbSql;
import domain.model.visit.Visit;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class VisitDbSql extends ObjectDb implements VisitDb {
    public VisitDbSql(Properties p) {
        super(p);
    }

    @Override
    public Visit get(int cureId) {
        Visit visit = null;
        CheckupDbSql checkupDbSql = new CheckupDbSql(getProperties());
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties());
        ){
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
    public void add(Visit visit){
        try {
            throw new InstantiationException("adding visit to cure from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public List<Visit> getAllFromCure(int cureId){
        try {
            throw new InstantiationException("getting all visits of cure from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Visit> getAllFromClient(int clientId){
        try {
            throw new InstantiationException("getting all visits of client from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
        return null;
    }

}