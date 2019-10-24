/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of VisitDb.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.Visit;

import domain.model.visit.Visit;

import java.util.List;

public interface VisitDb {
    Visit get(int cureId);

    void add(Visit visit);

    List<Visit> getAllFromCure(int cureId);

    List<Visit> getAllFromClient(int clientId);
}
