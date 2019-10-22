package domain.model.debug;

import domain.model.RandomIdGenerator;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Error {
    private Timestamp time;
    private String errorMessage;
    private int id;

    public Error(int id, String errorMessage, Timestamp time) {
        setId(id);
        setErrorMessage(errorMessage);
        setTime(time);

    }

    public Error(String errorMessage) {
        this(0,errorMessage,null);

    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        if(time == null){
            this.time = new Timestamp(System.currentTimeMillis());
        }else{
            this.time = time;
        }

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id==0){
            RandomIdGenerator  idGenerator = new RandomIdGenerator();
            this.id = idGenerator.getRandomId();
        }else{
            this.id = id;
        }

    }
}
