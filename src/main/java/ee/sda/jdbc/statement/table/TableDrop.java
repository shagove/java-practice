package ee.sda.jdbc.statement.table;

import ee.sda.jdbc.util.MysqlUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDrop {

    public static void main(String[] args) {

        String SQL_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

        try (Connection conn = MysqlUtils.getConnection();
             Statement statement = conn.createStatement()) {

            // if DDL failed, it will raise an SQLException
            statement.execute(SQL_DROP);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
