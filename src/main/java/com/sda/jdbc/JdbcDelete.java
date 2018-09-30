package jdbc;

import java.sql.*;

public class JdbcDelete {

    public static void main(String[] argv) throws Exception {

        String DB_CONNECTION = "jdbc:mysql://localhost:3306/test?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String DB_USER = "root";
        String DB_PASSWORD = "admin";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            String deleteTableSQL = "DELETE from person WHERE idperson = 2";

            statement = connection.createStatement();
            statement.execute(deleteTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

}

