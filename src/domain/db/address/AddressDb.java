/*
 * Created with IntelliJ IDEA Ultimate.
 * Copyright (c) 2019. All Rights Reserved
 * Unauthorized copying of AddressDb.java, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by MB-Development (Kalimath), Month Year
 */

package domain.db.address;

import domain.model.personal.Address;

import java.util.List;

public interface AddressDb {
    void add(int clientId, Address address);

    void update(int clientId, Address addressO);

    void delete(int id);

    Address get(int clientId);

    List<Address> getAll();
}
