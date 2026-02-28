package pl.coderslab;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }

    private static DataSource getInstance() {
        System.out.println(dataSource);
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext = (Context)initContext.lookup("java:/comp/env");
                dataSource = (DataSource)envContext.lookup("jdbc/users");
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    public static int getRowCount(Connection conn) {
        try (PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM users;")) {
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static final String EXIST_QUERY = "SELECT * FROM users m WHERE m.id = ?;";

    public static boolean rowExists(Connection conn, int id) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(EXIST_QUERY)) {
            statement.setInt(1, id);
            if (!statement.executeQuery().next()) return false;
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
