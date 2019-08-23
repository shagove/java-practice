package ee.sda.jdbc.preparestatement.table;

import ee.sda.jdbc.util.MysqlUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TableDrop {

    private static final String SQL_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    public static void main(String[] args) {

        try (Connection conn = MysqlUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_DROP)) {

            preparedStatement.execute();

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
