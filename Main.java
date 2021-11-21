package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "1122");
                    Statement statement = con.createStatement();

                    while (true){
                        System.out.println("1. Enter book\n2. Update book\n3. Delete book\n4. Search books\n0. Exit\n");
                        int x = in.nextInt();
                        switch(x){
                            case 1:
                                System.out.println("Enter ID:");
                                int id = in.nextInt();
                                System.out.println("Enter Title:");
                                String title = in.next();
                                System.out.println("Enter Author:");
                                String author = in.next();
                                System.out.println("Enter Qty:");
                                int qty = in.nextInt();
                                statement.executeUpdate("INSERT INTO `books` (`id`, `Title`, `Author`, `Qty`) VALUES ("+id+", '"+title+"', '"+author+"', "+qty+");");
                                ResultSet res = statement.executeQuery("SELECT * FROM `books`");
                                System.out.println("-----------------------Books Table-------------------------");
                                while (res.next()) {
                                    System.out.println("ID: "+res.getInt(1)+" Title:("+res.getString(2)+") Author:"+res.getString(3) +" Qty:"+res.getInt(4));
                                }
                                System.out.println("-----------------------------------------------------------");

                                break;


                            case 2:
                                System.out.println("Enter Book id");
                                int bookId = in.nextInt();
                                System.out.println("Enter new ID:");
                                int u_id = in.nextInt();
                                System.out.println("Enter new Title:");
                                String u_title = in.next();
                                System.out.println("Enter new Author:");
                                String u_author = in.next();
                                System.out.println("Enter new Qty:");
                                int u_qty = in.nextInt();
                                statement.executeUpdate("UPDATE books SET id ="+u_id+", title = '"+u_title+"', Author = '"+u_author+"', Qty ="+u_qty+" WHERE id ="+bookId+";");

                                res = statement.executeQuery("SELECT * FROM `books`");
                                System.out.println("-----------------------Books Table-------------------------");
                                while (res.next()) {
                                    System.out.println("ID: "+res.getInt(1)+" Title:("+res.getString(2)+") Author:"+res.getString(3) +" Qty:"+res.getInt(4));
                                }
                                System.out.println("-----------------------------------------------------------");
                                break;


                            case 3:
                                System.out.println("Enter Book id to delete:");
                                int d_bookId = in.nextInt();
                                statement.executeUpdate("DELETE FROM books WHERE id ="+d_bookId+" ;");
                                res = statement.executeQuery("SELECT * FROM `books`");
                                System.out.println("-----------------------Books Table-------------------------");
                                while (res.next()) {
                                    System.out.println("ID: "+res.getInt(1)+" Title:("+res.getString(2)+") Author:"+res.getString(3) +" Qty:"+res.getInt(4));
                                }
                                System.out.println("-----------------------------------------------------------");
                                break;

                            case 4:
                                System.out.println("Enter Book id to Search:");
                                int s_bookId = in.nextInt();
                                res = statement.executeQuery("SELECT * FROM `books` WHERE id = "+s_bookId+"");
                                System.out.println("-----------------------Books Table-------------------------");
                                while (res.next()) {
                                    System.out.println("ID: "+res.getInt(1)+" Title:("+res.getString(2)+") Author:"+res.getString(3) +" Qty:"+res.getInt(4));
                                }
                                System.out.println("-----------------------------------------------------------");
                                break;

                            case 0:
                                return;
                        }

                    }











                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

        }
