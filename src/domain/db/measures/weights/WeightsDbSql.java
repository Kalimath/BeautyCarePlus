/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of WeightsDbSql.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.measures.weights;

import domain.db.DbException;
import domain.db.ObjectDb;
import domain.model.measures.Weights;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class WeightsDbSql extends ObjectDb implements WeightsDb {
    public WeightsDbSql(Properties p) {
        super(p);
    }

    @Override
    public void update(Weights weights, int clientId) {
        try {
            throw new InstantiationException("updating weights to database failed: method is not implemented yet");
        } catch (Exception e) {
            System.out.println("updating weights to database failed: method is not implemented yet");
        }
    }

    @Override
    public Weights get(int controleId) {
        Weights weights = null;
        try (Connection connection = DriverManager.getConnection(getUrl(), getProperties())){
            System.out.println("Circumferences query started");
            String querie= "SELECT * FROM wegingen where controleid = ?";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,controleId);
            ResultSet result = statementp.executeQuery();
            while (result.next()) {
                weights = new Weights();

                weights.setWeight(result.getDouble("gewicht"));
                weights.setFatmass(result.getDouble("vetmassa"));
                weights.setMusclemass(result.getDouble("spiermassa"));
                weights.setMoisturemass(result.getDouble("vochtmassa"));
                weights.setBonemass(result.getDouble("botmassa"));
                weights.setBmr(result.getDouble("bmr"));
                weights.setMetabolicAge(result.getInt("metabolischeleeftijd"));
                weights.setVisceralFat(result.getDouble("visceralevetwaarde"));
                weights.setIdealFatMassBegin(result.getDouble("idealevetmassabegin"));
                weights.setIdealFatMassEnd(result.getDouble("idealevetmassaeinde"));
                //weights.setComment(result.getString("commentaar"));
            }
            System.out.println("Circumferences query ended");
        }catch (Exception se){
            se.printStackTrace();
            throw new DbException(se.getMessage());

        }
        return weights;
    }

    @Override
    public void add(Weights weights, int controleId) {
        try(Connection connection = DriverManager.getConnection(super.getUrl(), super.getProperties())){

            String querie = "INSERT INTO wegingen(wegingenid,controleid, gewicht, vetmassa, spiermassa, vochtmassa, botmassa, bmr,metabolischeleeftijd,visceralevetwaade,idealevetmassabegin,idealevetmassaeinde) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statementp = connection.prepareStatement(querie);
            statementp.setInt(1,getNewRandomId());
            statementp.setDouble(2,controleId);
            statementp.setDouble(3,weights.getWeight());
            statementp.setDouble(4,weights.getFatmass());
            statementp.setDouble(5,weights.getMusclemass());
            statementp.setDouble(6,weights.getMoisturemass());
            statementp.setDouble(7,weights.getBonemass());
            statementp.setDouble(8,weights.getBmr());
            statementp.setDouble(9,weights.getMetabolicAge());
            statementp.setDouble(10,weights.getVisceralFat());
            statementp.setDouble(11,weights.getIdealFatMassBegin());
            statementp.setDouble(12,weights.getIdealFatMassEnd());

            statementp.execute();
            statementp.close();
        }catch (Exception se){
            throw new DbException(se.getMessage());
        }
    }

    @Override
    public void delete(int clientId) {
        try {
            throw new InstantiationException("deleting weights from database failed: method is not implemented yet");
        } catch (Exception e) {
            System.out.println("deleting weights from database failed: method is not implemented yet");
        }
    }
}
