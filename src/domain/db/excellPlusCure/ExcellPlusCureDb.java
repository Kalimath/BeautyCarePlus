package domain.db.excellPlusCure;

import domain.model.cure.ExcellPlusCure;

import java.util.List;

public interface ExcellPlusCureDb {
    List<ExcellPlusCure> getAllFromClient(int clientId);
    void add(int clientId, ExcellPlusCure cure);
    void delete(int clientId);
    void update(ExcellPlusCure cure, int clientId);
    ExcellPlusCure get(int clientId);
    ExcellPlusCure getCurrent(int clientId);
    int getCurrentExcellPlusCureId(int clientId);
    int getNumberOfPastCures(int clientId);
    List<ExcellPlusCure> getPastCures(int clientId);
}
