package main.schedule.connection_utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.schedule.connection_utils.connection_exceptions.ConnectionNotClosedException;
import main.schedule.connection_utils.connection_exceptions.ConnectionNotOpenedException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Class {@code DatasourseJNDI} creates and manages a pool of connections to a database.
 * More info: https://tomcat.apache.org/tomcat-8.0-doc/jdbc-pool.html
 * Advantages: Thread safe, support for highly concurrent environments and multi core/cpu systems.
 * Configuration steps:
 * 1. MySQL configuration;
 * 2. Context configuration;
 * 3. web.xml configuration.
 * @exception ConnectionNotOpenedException throws when connection wasn't opened for easier log access
 * @exception ConnectionNotClosedException throws when connection wasn't closed for easier log access
 */

public class DatasourceJNDI {

    private static Connection connection;
    private static final Logger rootlogger = LogManager.getRootLogger();

    static	{
        Context initContext;
        try {
            initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("jdbc/beautysalon");
            try {
                connection = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
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
                System.out.println("Connection with database is closed");
            }
            else{
                throw new ConnectionNotClosedException("Exception in closeConnection() method: " + ConnectionUtil.class);
            }
        }catch (SQLException e) {
            rootlogger.warn("SQLException at closeConnection method()", e);
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
                System.out.println("Connection with database is closed");
            }
            else{
                throw new ConnectionNotClosedException("Exception in closeConnection() method: " + ConnectionUtil.class);
            }
        }catch (SQLException e) {
            rootlogger.warn("SQLException at closeConnection method()", e);
        }
    }
}

