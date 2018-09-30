package jdbc.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentRepository implements AbstractRepsitoryI<Student> {


    String DB_CONNECTION = "jdbc:mysql://localhost:3306/test?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DB_USER = "root";
    String DB_PASSWORD = "admin";

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;
    ResultSet rs = null;


    private Connection getConnection() throws SQLException {
        if (connection == null)
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        return connection;
    }
    private void closeJdbcConnection(Statement preparedStatement) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student get(int id) {
        Student student = null;
        try {

            String selectTableSQL = "SELECT * FROM person WHERE idStudent = ?";

            preparedStatement = getConnection().prepareStatement(selectTableSQL);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("idStudent");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                student = new Student(studentId, name, surname);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            closeJdbcConnection(preparedStatement);
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        try {
            statement = getConnection().createStatement();
            String selectTableSQL = "SELECT * from student";
            rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                int studentId = rs.getInt("idStudent");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                students.add(new Student(studentId, name, surname));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeJdbcConnection(statement);
        }
        return students;
    }


    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(int id, Map<String, String> map) {
        return false;
    }

    @Override
    public boolean insert(Map<String, String> map) {
        int id = 999; //just for test
        String name = map.get("name");
        String surname = map.get("surname");

        try {
            String insertTableSQL = "INSERT INTO student"
                    + "(idStudent, name, surname) VALUES"
                    + "(?,?,?)";

            preparedStatement = getConnection().prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, 11);
            preparedStatement.setString(2, "fifty");
            preparedStatement.setString(3, "fifstysurname");
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            closeJdbcConnection(preparedStatement);
        }

        return false;
    }


}
