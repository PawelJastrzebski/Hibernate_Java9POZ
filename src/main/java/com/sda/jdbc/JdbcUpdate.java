package com.sda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdate {
    public static void main(String[] argv) throws Exception {

        String DB_CONNECTION = "com.sda.jdbc:mysql://localhost:3306/test?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String DB_USER = "root";
        String DB_PASSWORD = "admin";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            String updateTableSQL = "UPDATE person SET name = ? "
                    + " WHERE idperson = ?";

            preparedStatement = connection.prepareStatement(updateTableSQL);

            preparedStatement.setString(1, "updatedName");
            preparedStatement.setInt(2, 1);


            // execute insert SQL stetement
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }
}
