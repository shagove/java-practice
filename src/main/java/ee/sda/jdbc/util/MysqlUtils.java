package ee.sda.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlUtils {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://remotemysql.com:3306/8cZ0OoQPqb", "8cZ0OoQPqb", "g8MSbcYkiq");
    }
}
