package com.company;
import java.sql.*;
public class x {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_programming?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "1234"
            );

            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;

            results= statement.executeQuery("SELECT * FROM java_programming");
            while (results.next()) {
                System.out.println("ID: "+results.getInt("id")+ ", "+" Name: " +results.getString("name") + ", "+" Grade: " +results.getInt("grade"));
            }
            rowsAffected = statement.executeUpdate(
                    "UPDATE java_programming SET grade=65 WHERE name='Carl Davis'"
            );
            System.out.println("Query complete, " + rowsAffected + " rows updated.");

            rowsAffected = statement.executeUpdate(
                    "DELETE FROM java_programming WHERE name='Dennis Fredrickson'"
            );
            System.out.println("Query complete, " + rowsAffected + " rows removed.");

            rowsAffected = statement.executeUpdate(
                    "UPDATE java_programming SET grade=80 WHERE id>55"
            );
            System.out.println("Query complete, " + rowsAffected + " rows updated.");

            results= statement.executeQuery("SELECT * FROM java_programming");
            while (results.next()) {
                System.out.println("ID: "+results.getInt("id")+ ", "+" Name: " +results.getString("name") + ", "+" Grade: " +results.getInt("grade"));
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
