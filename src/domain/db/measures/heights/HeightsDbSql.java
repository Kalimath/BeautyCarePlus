package domain.db.heights;

import domain.db.ObjectDb;
import domain.model.measures.Heights;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HeightsDbSql extends ObjectDb implements HeightsDb {

    public HeightsDbSql(Properties p) {
        super(p);
    }

    @Override
    public void add(Heights heights) {
        try {
            throw new InstantiationException("adding heights to database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public void delete(String email) {
        try {
            throw new InstantiationException("deleting heights from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public void update(Heights heights) {
        try {
            throw new InstantiationException("updating heights to database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public void delete(int heightsId) {
        try {
            throw new InstantiationException("deleting heights from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
    }

    @Override
    public Heights get(int clientId) {
        try {
            throw new InstantiationException("getting heights from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<Heights> getAll() {
        try {
            throw new InstantiationException("getting all heights from database failed: method is not implemented yet");
        } catch (Exception e) {

        }
        return new ArrayList<>();
    }

}
