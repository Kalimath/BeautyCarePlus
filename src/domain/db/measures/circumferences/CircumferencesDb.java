/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of CircumferencesDb.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.measures.circumferences;

import domain.model.measures.Circumferences;

public interface CircumferencesDb {
    //not written yet
    void update(Circumferences circumferences, int clientId);

    //not written yet
    Circumferences get(int clientId);

    //not written yet
    void add(Circumferences circumferences, int clientId);

    //not written yet
    void delete(int clientId);
}
