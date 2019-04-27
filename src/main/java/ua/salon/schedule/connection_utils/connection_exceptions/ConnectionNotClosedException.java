package ua.salon.schedule.connection_utils.connection_exceptions;

public class ConnectionNotClosedException extends Exception {
    public ConnectionNotClosedException(String message) {
        super(message);
    }
}
