/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of CheckupDb.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.checkup;

import domain.model.measures.Checkup;

import java.util.List;

public interface CheckupDb {
    Checkup get(int visitId);

    void add(Checkup checkup);

    Checkup getFromLatestVisit(int visitId);

    List<Checkup> getAllFromClient(int visitId);
}
