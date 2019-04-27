package ua.salon.schedule.dao.user;

import org.apache.logging.log4j.*;
import ua.salon.schedule.codec.MD5Util;
import ua.salon.schedule.connection_utils.DatasourceJNDI;
import ua.salon.schedule.model.user.User;
import ua.salon.schedule.model.user.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO{

    private Connection connection;

    private static final Logger rootlogger = LogManager.getRootLogger();
    private static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
    private static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE user_email = ?";
    private static final String FIND_All_MASTERS = "SELECT * FROM users WHERE user_role = ?";
    private static final String ADD_USER = "INSERT INTO users (user_name, user_role, user_email, user_password, user_phone) VALUES (?,?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE users SET user_name = ?, user_role = ?, user_email = ?, user_password = ?, user_phone = ? WHERE user_id = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE user_id = ? ";

    public UserDAO() {
    }

    public void addUser(User user) {
        PreparedStatement ps = null;
        try {
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(ADD_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getRole().toString());
            ps.setString(3, user.getEmail());
            ps.setString(4, MD5Util.md5Custom(user.getPassword()));
            ps.setInt(5, user.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            rootlogger.warn("SQLException in adding user to database", e);
        } finally {
            /*try {
                DatasourceJNDI.closeConnection(connection, ps);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }

    public void deleteUserById(int idPk) {
        PreparedStatement ps = null;
        try {
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(DELETE_USER);
            ps.setInt(1, idPk);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*try {
                DatasourceJNDI.closeConnection(connection, ps);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }

    public User findUserById(int idPk) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        User user = new User();
        String role = null;
        try {
            connection = DatasourceJNDI.getConnection();
            rootlogger.debug("Connection is established");
            ps = connection.prepareStatement(FIND_USER_BY_ID);
            ps.setInt(1,idPk);
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                user.setId(idPk);
                user.setName(resultSet.getString("user_name"));
                role = resultSet.getString("user_role");
                user.setRole(UserRole.valueOf(role));
                user.setEmail(resultSet.getString("user_email"));
                user.setPassword(resultSet.getString("user_password"));
                user.setPhone(resultSet.getInt("user_phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           /* try {
                DatasourceJNDI.closeConnection(connection, ps);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }*/
        }
        return user;
    }

    public User findUserByLogin(String email) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        User user = new User();
        String role = null;
        try {
            connection = DatasourceJNDI.getConnection();

            ps = connection.prepareStatement(FIND_USER_BY_EMAIL);
            ps.setString(1,email);
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                user.setId(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("user_name"));
                role = resultSet.getString("user_role");
                user.setRole(UserRole.valueOf(role));
                user.setEmail(email);
                user.setPassword(resultSet.getString("user_password"));
                user.setPhone(resultSet.getInt("user_phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            try {
                DatasourceJNDI.closeConnection(connection, ps, resultSet);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        return user;
    }

    public List<User> getAllMasters() {
        List<User> mastersList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        UserDAO userDAO = new UserDAO();
        User user = new User();
        String role = UserRole.MASTER.toString();
        int userId = 0;
        try {
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(FIND_All_MASTERS);
            ps.setString(1, role);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                userId = rs.getInt("user_id");
                user = userDAO.findUserById(userId);
                mastersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*try {
                DatasourceJNDI.closeConnection(connection, ps, resultSet);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }*/
        }
        return mastersList;
    }

    public void updateUser(int idPk, User user) {
        PreparedStatement ps = null;
        try {
            connection = DatasourceJNDI.getConnection();
            ps = connection.prepareStatement(UPDATE_USER);

            ps.setString(1, user.getName());
            ps.setString(2, user.getRole().toString());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getPhone());
            ps.setInt(6, idPk);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           /* try {
                DatasourceJNDI.closeConnection(connection, ps);
            } catch (ConnectionNotClosedException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }
}
