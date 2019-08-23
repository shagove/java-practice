package ee.sda.jdbc.statement.row;

import ee.sda.jdbc.util.MysqlUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class RowInsert {

    public static void main(String[] args) {

        // auto close connection and statement
        try (Connection conn = MysqlUtils.getConnection();
             Statement statement = conn.createStatement()) {

            System.out.println(generateInsert("Iva", new BigDecimal(999.80)));

            int row = statement.executeUpdate(generateInsert("Iva", new BigDecimal(999.80)));

            // rows affected
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String generateInsert(String name, BigDecimal salary) {

        return "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) " +
                "VALUES ('" + name + "','" + salary + "','" + LocalDateTime.now() + "')";

    }


}
