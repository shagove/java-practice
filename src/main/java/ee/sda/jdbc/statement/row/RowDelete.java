package ee.sda.jdbc.statement.row;

import ee.sda.jdbc.util.MysqlUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RowDelete {

    public static void main(String[] args) {

        try (Connection conn = MysqlUtils.getConnection();
             Statement statement = conn.createStatement()) {

            int row = statement.executeUpdate(deleteByName("Iva"));

            // rows affected
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String deleteByName(String name) {

        return "DELETE FROM EMPLOYEE WHERE NAME='" + name + "'";

    }
}