package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("" +
                "1. Enter book\n" +
                "2. Update book\n" +
                "3. Delete book\n" +
                "4. Search books\n" +
                "0. Exit");
        Scanner scanner=new Scanner(System.in);
        int userInput=scanner.nextInt();
        switch (userInput){
            case 1: enterBook();
                break;
            case 2:updateBook();
                break;
            case 3:deleteBook();
                break;
            case 4:searchBook();
            default:
                System.out.println("");
        }
    }


    public static void updateBook(){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookstore?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "123456"
            );

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter book id want change  ");
            int id=scanner.nextInt();
            System.out.println("Enter Author name  ");
            Scanner scanner2=new Scanner(System.in);
            String authorName=scanner2.nextLine();


            Statement statement = connection.createStatement();


            ResultSet results;
            int rowsAffected;

            rowsAffected=statement.executeUpdate("UPDATE books SET Author='"+authorName+"' WHERE id="+id+" ;");
            results= statement.executeQuery("select * from books ;");
            while (results.next()){
                System.out.println(results.getInt("id")+" "+results.getString("title")+" "+results.getString("Author")+" "+results.getString("qty"));
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void searchBook(){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookstore?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "123456"
            );

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter book author for search ");
            String author=scanner.nextLine();

            Statement statement = connection.createStatement();


            ResultSet results;
            int rowsAffected;


            results= statement.executeQuery("select * from books where Author='"+author+"';");
            while (results.next()){
                System.out.println(results.getInt("id")+" "+results.getString("title")+" "+results.getString("Author")+" "+results.getString("qty"));
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookstore?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "123456"
            );

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter book id for delete ");
            int id=scanner.nextInt();

            Statement statement = connection.createStatement();


            ResultSet results;
            int rowsAffected;

            rowsAffected=statement.executeUpdate("DELETE FROM books WHERE id="+id+" ;");
            results= statement.executeQuery("select * from books");
            while (results.next()){
                System.out.println(results.getInt("id")+" "+results.getString("title")+" "+results.getString("Author")+" "+results.getString("qty"));
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void enterBook(){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookstore?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "123456"
            );

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter book id");
            int bookId=scanner.nextInt();

           System.out.println("Enter book title");
            String bookTitle= scanner.nextLine();
            System.out.println("Enter book title2");
            String bookTitle2= scanner.nextLine();
            System.out.println("title1"+bookTitle);
            System.out.println("title2"+bookTitle2);
            System.out.println("Enter book author");
            String bookAuthor=scanner.nextLine();

            System.out.println("Enter book qty");
            int bookqty=scanner.nextInt();

            Statement statement = connection.createStatement();


            ResultSet results;
            int rowsAffected;
            rowsAffected=statement.executeUpdate("INSERT INTO books(id,title,author,qty) VALUES ("+bookId+",'"+bookTitle2+"','"+bookAuthor+"',"+bookqty+");");
            results= statement.executeQuery("select * from books");
            while (results.next()){
                System.out.println(results.getInt("id")+" "+results.getString("title")+" "+results.getString("Author")+" "+results.getString("qty"));
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    Error

}
