package domain.db;

import domain.model.RandomIdGenerator;

import java.util.Properties;

public abstract class ObjectDb {
    private Properties properties;
    private String url;
    private RandomIdGenerator idGenerator;

    public ObjectDb(Properties p) {
        idGenerator = new RandomIdGenerator(12000);
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            this.properties = p;
            this.url = properties.getProperty("url");
        } catch (Exception e) {
            throw new DbException(e.getMessage());
        }
    }
    protected int getNewRandomId(){
        return this.idGenerator.getRandomId();
    }

    protected Properties getProperties() {
        return properties;
    }

    protected String getUrl() {
        return url;
    }

}
