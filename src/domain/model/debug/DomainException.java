package domain.model.debug;

public class DomainException extends RuntimeException {
    public DomainException(String message){
        super(message);
    }

}
