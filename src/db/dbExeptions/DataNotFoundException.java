package db.dbExeptions;


/**
 * Created by danil on 10.06.2017.
 */
public class DataNotFoundException extends Exception {
    public String message = "The request did not return any data";

    public DataNotFoundException() {}

    public DataNotFoundException(String message) {
        this.message = message;
    }

    public DataNotFoundException(Throwable e) {
        initCause(e);
    }

    public String getMessage() {
        return message;
    }
}
