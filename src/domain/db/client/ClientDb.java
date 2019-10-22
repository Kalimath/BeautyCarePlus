package domain.db.client;

import domain.model.personal.Address;
import domain.model.personal.Client;
import domain.model.personal.Sport;
import domain.observer.Subject;

import java.util.HashMap;
import java.util.List;

/**
 *
 */
public interface ClientDb {

    Client get(String name);
    int getClientId(String name);
}
