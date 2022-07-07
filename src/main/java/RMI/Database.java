package RMI;


import java.sql.*;

public class Database {
    public static Connection connection;

    Database() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/kps?", "root", "");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet execute(String query) throws SQLException {
        System.out.println(query);
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }
}
