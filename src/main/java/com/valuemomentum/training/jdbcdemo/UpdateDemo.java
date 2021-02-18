package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		
		 Connection con;
		 PreparedStatement pstmt;
         Statement stmt;
         ResultSet rs;
         
         int cnt=0;

     try
     {
	Class.forName("com.mysql.cj.jdbc.Driver");

    //Open a connection

    System.out.println("Connecting to database");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "Janu@mangle");
    
    String sqlUpdate = "UPDATE candidates "+"SET last_name= ? "
                                 +"WHERE id = ? ";
    
    pstmt=con.prepareStatement(sqlUpdate);
    
    ///prepare data for update
    Scanner s=new Scanner(System.in);
    System.out.println("enter employee id");
    int eid=s.nextInt();
    System.out.println("enter employees new last name");
    String lastname=s.next();
    
    pstmt.setString(1, lastname);
    pstmt.setInt(2, eid);
    
    int rowAffected=pstmt.executeUpdate();
    System.out.println(String.format("Row affected %d", rowAffected));
    
    //reuse the prepared statement
    lastname="Grohe";
    eid=101;
    pstmt.setString(1, lastname);
    pstmt.setInt(2,eid);
    
    rowAffected=pstmt.executeUpdate();
    System.out.println(String.format("Row affected %d", rowAffected));
    con.close();
	}
     catch (Exception e)
     {
       System.out.println(e);
      }

}
}
