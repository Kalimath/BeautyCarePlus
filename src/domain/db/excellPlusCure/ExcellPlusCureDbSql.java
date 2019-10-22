package domain.db.excellPlusCure;

import domain.db.ObjectDb;
import domain.model.cure.ExcellPlusCure;
import java.util.List;
import java.util.Properties;

public class ExcellPlusCureDbSql extends ObjectDb implements ExcellPlusCureDb {
    public ExcellPlusCureDbSql(Properties p) {
        super(p);
    }

    @Override
    public void add(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Object get(int id) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    public List<ExcellPlusCure> getAllFromClient(int clientId) {
        return null;
    }

    @Override
    public void add(int clientId, ExcellPlusCure cure) {

    }
}
