/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of HeightsDbSql.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.measures.heights;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.model.measures.Heights;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class HeightsDbSql extends ObjectDb implements HeightsDb {

    public HeightsDbSql(Properties p){
        super(p);
    }

    @Override
    public void add(Heights heights, int clientId){
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())) {
            System.out.println("Heights query ADD started");
            String querie = "INSERT INTO hoogtes(hoogtesid, knie, dij, taille, arm, heup, kuit, volledigelengte, meetzijde, klantid, commentaar) values (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, getNewRandomId());
            statementp.setDouble(2, heights.getKnee());
            statementp.setDouble(3, heights.getThigh());
            statementp.setDouble(4, heights.getWaist());
            statementp.setDouble(5, heights.getArm());
            statementp.setDouble(6, heights.getHip());
            statementp.setDouble(7, heights.getCalf());
            statementp.setDouble(8, heights.getFullLength());
            statementp.setBoolean(9, heights.getMeasureSide());
            statementp.setString(10, heights.getComment());
            statementp.setDouble(11, clientId);

            statementp.execute();
            statementp.close();
        } catch (Exception se) {
            throw new DbException(se.getMessage());
        }
        System.out.println("Heights query ADD ended");
    }

    @Override
    public void update(Heights heights, int clientId){
        try (Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())) {
            System.out.println("Heights query UPDATE started");
            String querie = "update hoogtes set hoogtesid=?, knie=?, dij=?, taille=?, arm=?, heup=?, kuit=?, volledigelengte=?, meetzijde=?, commentaar=? where klantid=?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, getNewRandomId());
            statementp.setDouble(2, heights.getKnee());
            statementp.setDouble(3, heights.getThigh());
            statementp.setDouble(4, heights.getWaist());
            statementp.setDouble(5, heights.getArm());
            statementp.setDouble(6, heights.getHip());
            statementp.setDouble(7, heights.getCalf());
            statementp.setDouble(8, heights.getFullLength());
            statementp.setBoolean(9, heights.getMeasureSide());
            statementp.setString(10, heights.getComment());
            statementp.setDouble(11, clientId);

            statementp.execute();
            statementp.close();
        } catch (Exception se) {
            throw new DbException(se.getMessage());
        }
        System.out.println("Heights query UPDATE ended");
    }

    @Override
    public void delete(int clientId){
        try (Connection connection = DriverManager.getConnection(this.getUrl(), this.getProperties())) {
            System.out.println("Heights query DELETE started");
            String querie = "DELETE from hoogtes where klantid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, clientId);
            statementp.execute();
            statementp.close();
        } catch (Exception se) {
            throw new DbException(se.getMessage());
        }
        System.out.println("Heights query DELETE ended");
    }

    @Override
    public Heights get(int clientId){
        Heights heights = null;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())) {
            System.out.println("Heights query GET started");
            String querie = "SELECT * FROM hoogtes where klantid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1, clientId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                heights = new Heights();
                int heightsId = result.getInt("hoogtesid");
                heights.setKnee(result.getDouble("knie"));
                heights.setThigh(result.getDouble("dij"));
                heights.setWaist(result.getDouble("taille"));
                heights.setArm(result.getDouble("arm"));
                heights.setHip(result.getDouble("heup"));
                heights.setCalf(result.getDouble("kuit"));
                heights.setFullLength(result.getDouble("volledigelengte"));
                heights.setMeasureSide(result.getBoolean("meetzijde"));
                heights.setComment(result.getString("commentaar"));
            }
            System.out.println("Heights query GET ended");
        } catch (Exception se) {
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return heights;
    }

    //getAll
    /*@Override
    public List<Heights> getAll() {
        List<Heights> heightsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            String querie= "SELECT * FROM hoogtes";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,clientId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                int heightsId = result.getInt("hoogtesid");
                heightsList.setKnee(result.getDouble("knie"));
                heightsList.setThigh(result.getDouble("dij"));
                heightsList.setWaist(result.getDouble("taille"));
                heightsList.setArm(result.getDouble("arm"));
                heightsList.setHip(result.getDouble("heup"));
                heightsList.setCalf(result.getDouble("kuit"));
                heightsList.setFullLength(result.getDouble("volledigelengte"));
                heightsList.setComment(result.getString("commentaar"));
            }
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return heightsList;
    }*/

}
