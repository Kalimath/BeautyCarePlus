package domain.db.sport;

import domain.model.personal.Sport;

import java.util.List;

public interface SportDb {
    //not written yet
    List<Sport> getAll();

    //not written yet
    void update(Sport sport);

    //not written yet
    Sport get(String email);

    //not written yet
    void add(Sport sport);

    //not written yet
    void delete(String emailUser);

    //not written yet
    void delete(int clientId);
}
