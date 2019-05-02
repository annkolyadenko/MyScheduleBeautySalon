package ua.salon.schedule.connection_utils.connection_exceptions;

public class ConnectionNotClosedException extends Exception {
    public ConnectionNotClosedException(Throwable e) {
        initCause(e);
    }
}
