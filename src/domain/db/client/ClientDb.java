/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of ClientDb.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.client;

import domain.model.personal.Client;

import java.util.List;

public interface ClientDb {
    //needs to be rewritten
    List<Client> getAll();

    //written not tested
    void add(Client client);

    //needs to be written
    void update(Client client);

    //written not tested
    void delete(int clientId);

    int getClientId(String clientName);

    //written not tested
    Client get(String clientName);

    //written not tested
    Client get(int clientId);
}
