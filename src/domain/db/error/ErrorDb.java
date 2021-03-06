package domain.db.error;

import domain.model.debug.Error;

import java.util.List;

public interface ErrorDb {
    List<Object> getAll();
    void add(Error error);
    void deleteAll(int id);
}
