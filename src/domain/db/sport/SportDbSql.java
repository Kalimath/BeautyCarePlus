package domain.db.sport;

import domain.db.ObjectDb;
import domain.model.personal.Sport;

import java.util.List;
import java.util.Properties;

public class SportDbSql extends ObjectDb implements SportDb {
    public SportDbSql(Properties p) {
        super(p);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Sport> getAll() {
        return null;
    }

    @Override
    public void update(Sport sport) {
        try {

            throw new InstantiationException("updating sport to database failed: method is not implemented yet," + this.getClass().getSimpleName());

        } catch (Exception e) {

        }
    }

    @Override
    public Sport get(String email) {
        Sport sport = null;
        try {
            throw new InstantiationException("updating sport to database failed: method is not implemented yet," + this.getClass().getSimpleName());
        } catch (Exception e) {

        }
        return sport;
    }

    @Override
    public void add(Sport sport) {
        try {
            throw new InstantiationException("updating sport to database failed: method is not implemented yet," + this.getClass().getSimpleName());
        } catch (Exception e) {

        }

    }

    @Override
    public void delete(String emailUser) {
        try {
            throw new InstantiationException("updating sport to database failed: method is not implemented yet," + this.getClass().getSimpleName());
        } catch (Exception e) {

        }
    }

}
