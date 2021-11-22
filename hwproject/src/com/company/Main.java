package com.company;

import java.util.*;
import java.sql.*;

public class Main {

    public static  void main(String[] args) {
        // write your code here

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ bookstoree?useSSL=false&allowPublicKeyRetrieval=true",
                    "root",
                    "1234"
            );

            Statement statement = connection.createStatement();
            ResultSet book;

            int rowsAffected;
            Scanner in = new Scanner(System.in);
            System.out.println("please select book");
            String bookname=in.next();




//       rowsAffected =statement.executeUpdate("INSERT INTO books VALUES(3001,'A Tale of Two Cities','Charles Dickens ',30)");
//           rowsAffected =statement.executeUpdate("INSERT INTO books VALUES(3002,'Harry Potter and Philsofer Stone','J.k Rowling',40)");
//           rowsAffected =statement.executeUpdate("INSERT INTO books VALUES(3003,'The Lion the witch and wardobe','c.s Liews',25)");
//          rowsAffected =statement.executeUpdate("INSERT INTO books VALUES(3004,'The lord of Things','J.R.R Tolkien',37)");
//            statement.executeUpdate("INSERT INTO books VALUES(3005,'Alias in Wonderland',' Liews carlloll',12)");
//            statement.executeUpdate("INSERT INTO books VALUES(3006,'new book ',' c.c carlloll',20)");

            rowsAffected =statement.executeUpdate("UPDATE books SET Qty=20 WHERE id=3002");
            rowsAffected =statement.executeUpdate("DELETE FROM  books WHERE  id=3001");

       book=statement.executeQuery("SELECT * FROM books WHERE Qty>20");
           while(book.next()){
                System.out.println(book.getInt("id")+" ,"+book.getString("title")+" ,"+book.getString("Author")+" ,"+book.getInt("Qty"));
           }

           rowsAffected =statement.executeUpdate("UPDATE books SET  title='trip into world' WHERE id=3006");

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
