package RMI;

import java.sql.*;
public class Database {
    public static Connection connection;
           Database() throws SQLException {
                try {
                     connection = DriverManager.getConnection("jdbc:mysql://localhost/exercise?", "root", "");

                  } catch (Exception e) {
                    throw new RuntimeException(e);
                  }

              }
     public  ResultSet execute(String query) throws SQLException {
               Statement statement = connection.createStatement();
                return statement.executeQuery(query);
              }

               public int executeUpdate(String query) throws SQLException {
                   Statement statement = connection.createStatement();
                   return statement.executeUpdate(query);
               }
  }
