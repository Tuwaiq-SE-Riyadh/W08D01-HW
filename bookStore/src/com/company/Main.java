package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bookstore?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "1234"
            );

            Statement statement = connection.createStatement();
            ResultSet results;
            int rowsAffected;
            results = statement.executeQuery("SELECT * FROM books");
            while (results.next()) {
                System.out.println
                        (results.getInt("id")+
                                ", "+results.getString("Title") +
                                ", " +results.getInt("Qty"));
            }
            Scanner input = new Scanner(System.in);
            System.out.println("select 1 to Insert in sql ");
            System.out.println("select 2 to Update in sql ");
            System.out.println("select 3 to delete in sql ");
            System.out.println("select 4 to Search in sql ");
            System.out.println("select 5 to Exit in sql ");
            int in=input.nextInt();
            int id=0;
            String title;
            String author;
            int qty=0;
            String Select;

            switch (in) {
                case 1:
                    System.out.println("Enter the data to Insert ID , Name, Author , Qty");
                    id=input.nextInt();
                    title=input.next();
                    author=input.next();
                    qty=input.nextInt();
                    rowsAffected = statement.executeUpdate("INSERT INTO books VALUES ("+id+", '"+title+"','"+author+"',"+qty+")");
                    results = statement.executeQuery("SELECT * FROM books");
                    while (results.next()) {
                        System.out.println
                                (results.getInt("id")+
                                        ", "+results.getString("Title") +
                                        ", "+results.getString("Author") +
                                        ", " +results.getInt("Qty"));}
                    break;
                case 2:
                    results = statement.executeQuery("SELECT * FROM books");
                    while (results.next()) {System.out.println
                                (results.getInt("id")+
                                        ", "+results.getString("Title") +
                                        ", "+results.getString("Author") +
                                        ", " +results.getInt("Qty"));}
                    System.out.println("Enter the Id to update your data ");
                    Select=input.next();
                    System.out.println("Enter new title ");
                    title=input.next();
                    System.out.println("Enter new Qyt");
                    qty=input.nextInt();
                    rowsAffected = statement.executeUpdate("UPDATE books SET Title='"+title+"', Qty="+qty+" WHERE id="+Select+" ");
                    System.out.println(rowsAffected);
                    System.out.println("Query complete, " + rowsAffected + " rows updated.");
                    break;
                case 3:
                    System.out.println("Enter the the id to delete it ");
                    Select= input.next();
                    rowsAffected = statement.executeUpdate("DELETE from books WHERE id="+Select+" ");
                    System.out.println("Query complete, " + rowsAffected + " rows updated.");
                    break;
                case 4:
                System.out.println("Enter the the id to search it ");
                Select= input.next();
                    results = statement.executeQuery("SELECT * FROM books WHERE id="+Select+" ");
                    while (results.next()) {System.out.println
                            (results.getInt("id")+
                                    ", "+results.getString("Title") +
                                    ", "+results.getString("Author") +
                                    ", " +results.getInt("Qty"));}
                case 5:
                    System.out.println("Exit");
                    statement.close();
                    break;

            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
