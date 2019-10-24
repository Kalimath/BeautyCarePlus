/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of WeightsDb.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.measures.weights;

import domain.model.measures.Weights;

public interface WeightsDb {
    //not written yet
    void update(Weights weights, int clientId);

    //not written yet
    Weights get(int clientId);

    //not written yet
    void add(Weights weights, int clientId);

    //not written yet
    void delete(int clientId);
}
