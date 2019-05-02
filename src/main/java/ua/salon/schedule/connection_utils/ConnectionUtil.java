package ua.salon.schedule.connection_utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.salon.schedule.connection_utils.connection_exceptions.ConnectionNotClosedException;
import ua.salon.schedule.connection_utils.connection_exceptions.ConnectionNotOpenedException;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Class {@code ConnectionUtil} creates connection to the database through file {@link "database.properties"} and use {@code ResourseBundle}
 * class for this goals;
 * Not synchronized. Not thread safe.
 * Created for testing DAO classes through main() method. Just for internal usage!
 * @return Connection reference if DriverManager class reloaded and connection succeeded
 * @exception ConnectionNotOpenedException throws when connection wasn't opened for easier log access
 * @exception ConnectionNotClosedException throws when connection wasn't closed for easier log access
 */
public class ConnectionUtil {

    private static final String DB_PROPERTIES_FILE = "database";
    private static final Logger rootlogger = LogManager.getRootLogger();
    private static Connection connection;

    public static Connection getConnection() throws SQLException/*, ConnectionNotOpenedException*/ {
        if (connection != null) {
            return connection;
        }
        ResourceBundle resourse = ResourceBundle.getBundle(DB_PROPERTIES_FILE);
        String driver = resourse.getString("db.driver");
        String url = resourse.getString("db.url");
        String user = resourse.getString("db.user");
        String password = resourse.getString("db.password");
        try
        {
            Class.forName(driver).newInstance();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
            rootlogger.error(e);
        } catch (ClassNotFoundException e) {
            rootlogger.error(e);
        } catch (IllegalAccessException e) {
            rootlogger.error(e);
        }
        connection = DriverManager.getConnection(url,user,password);

        if(!connection.isClosed()){
            rootlogger.info("Connection with database established");
        }
       /* else{
            throw new ConnectionNotOpenedException("database connection wasn't open");
        }*/
        return connection;
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement) throws ConnectionNotClosedException {
        try {
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null) {
                connection.close();
                rootlogger.info("Connection with database is closing...");
            }
            if(connection.isClosed()){
                rootlogger.info("Connection with database is closed");
            }
            else{
                throw new ConnectionNotClosedException(new Throwable());
            }
        }catch (SQLException e) {
            rootlogger.warn("SQLException at closeConnection method()", e);
            throw new ConnectionNotClosedException(e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
            throws ConnectionNotClosedException {
        try {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null) {
                connection.close();
                rootlogger.info("Connection with database is closing...");
            }
            if(connection.isClosed()){
                rootlogger.info("Connection with database is closed");
            }
            else{
                throw new ConnectionNotClosedException(new Throwable());
            }
        }catch (SQLException e) {
            rootlogger.warn("SQLException at closeConnection method()", e);
            throw new ConnectionNotClosedException(e);
        }
    }
}
