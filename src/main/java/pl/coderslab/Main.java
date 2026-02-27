package pl.coderslab;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DbUtil.getConnection()) {
            System.out.println(connection);

        } catch (SQLException SQLE) {
            System.err.println(SQLE);
        }

    }
}