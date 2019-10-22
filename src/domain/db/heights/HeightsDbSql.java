package domain.db.heights;

import domain.db.ObjectDb;
import domain.model.measures.Heights;
import domain.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HeightsDbSql extends ObjectDb implements HeightsDb {

    public HeightsDbSql(Properties p) {
        super(p);
    }

    @Override
    public void add(Object heightsO) {
        Heights heights = null;
        try {

            if (heightsO instanceof Heights) {
                heights = (Heights) heightsO;
            } else {
                throw new InstantiationException("adding heights to database failed: object ain't an instance of heights");
            }
        }catch (Exception e){

        }
    }

    @Override
    public void update(Object heightsO) {
        Heights heights = null;
        try {

            if (heightsO instanceof Heights) {
                heights = (Heights) heightsO;
            } else {
                throw new InstantiationException("adding heights to database failed: object ain't an instance of heights");
            }
        }catch (Exception e){

        }
    }

    @Override
    public void delete(int heightsId) {

    }

    @Override
    public Heights get(int clientId) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return new ArrayList<>();
    }

}
