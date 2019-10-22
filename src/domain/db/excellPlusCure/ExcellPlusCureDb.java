package domain.db.excellPlusCure;

import domain.model.cure.ExcellPlusCure;

import java.util.List;

public interface ExcellPlusCureDb {
    List<ExcellPlusCure> getAllFromClient(int clientId);
    void add(int clientId, ExcellPlusCure cure);
}
