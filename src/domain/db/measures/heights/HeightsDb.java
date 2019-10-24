package domain.db.heights;

import domain.model.measures.Heights;

import java.util.List;

public interface HeightsDb {
    //not written yet
    List<Heights> getAll();

    //not written yet
    void update(Heights heights);

    //not written yet
    Heights get(int clientId);

    //not written yet
    void add(Heights heights);

    //not written yet
    void delete(String email);

    //not written yet
    void delete(int clientId);
}
