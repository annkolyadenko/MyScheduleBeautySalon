package ua.salon.schedule.connection_utils.connection_exceptions;

public class ConnectionNotOpenedException extends Exception {
    public ConnectionNotOpenedException(String message) {
        super(message);
    }
}
