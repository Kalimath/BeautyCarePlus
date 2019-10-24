/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of HeightsDb.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.measures.heights;

import domain.model.measures.Heights;

public interface HeightsDb {

    //not written yet
    void update(Heights heights, int clientId);

    //not written yet
    Heights get(int clientId);

    //not written yet
    void add(Heights heights, int clientId);

    //not written yet
    void delete(int clientId);
}
