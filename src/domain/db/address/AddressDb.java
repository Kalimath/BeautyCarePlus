package domain.db.address;

import domain.model.personal.Address;

public interface AddressDb {
    void add(int clientId, Address address);
}
