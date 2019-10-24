/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of CircumferencesDbSql.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.measures.circumferences;

import domain.db.ObjectDb;
import domain.model.measures.Circumferences;

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

        }
    }

    @Override
    public Circumferences get(int clientId) {
        try {
            throw new InstantiationException("getting all circumferences from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public void add(Circumferences circumferences, int clientId) {
        try {
            throw new InstantiationException("adding circumferences to database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public void delete(int clientId) {
        try {
            throw new InstantiationException("deleting circumferences to database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }
}
