/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of WeightsDbSql.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.measures.weights;

import domain.db.ObjectDb;
import domain.model.measures.Weights;

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

        }
    }

    @Override
    public Weights get(int clientId) {
        try {
            throw new InstantiationException("getting all weights from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public void add(Weights weights, int clientId) {
        try {
            throw new InstantiationException("adding weights to database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public void delete(int clientId) {
        try {
            throw new InstantiationException("deleting weights from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }
}
