package domain.db.sport;

import domain.db.ObjectDb;
import domain.model.personal.Sport;
import domain.observer.Observer;

import java.util.List;
import java.util.Properties;

public class SportDbSql extends ObjectDb implements SportDb {
    public SportDbSql(Properties p) {
        super(p);
    }

    @Override
    public void add(Object sportO) {
        Sport sport = null;
        try {

            if (sportO instanceof Sport) {
                sport = (Sport) sportO;
            } else {
                throw new InstantiationException("adding sport to database failed: object ain't an instance of sport,"+this.getClass().getSimpleName());
            }
        }catch (Exception e){

        }
    }

    @Override
    public void update(Object sportO) {
        Sport sport = null;
        try {

            if (sportO instanceof Sport) {
                sport = (Sport) sportO;
            } else {
                throw new InstantiationException("updating sport to database failed: object ain't an instance of sport,"+this.getClass().getSimpleName());
            }
        }catch (Exception e){

        }
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

}
