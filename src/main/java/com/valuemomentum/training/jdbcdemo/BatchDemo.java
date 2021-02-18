package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BatchDemo {
	Connection con;
   Statement stmt;
   ResultSet rs;
   

	public static void main(String[] args) throws Exception {
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");

	    System.out.println("Connecting to database");
	  Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "Janu@mangle");
	   Statement stmt =con.createStatement();

			   
			   //create batch
	   stmt.addBatch("insert into candidate_skills value(100,5)");
	   stmt.addBatch("update skills set name='Ajax' where id=3");
	   stmt.addBatch("delete from candidates where id=80");
	   
	   //disable auto-commit mode
	   con.setAutoCommit(false);
	   try
	   {
		   stmt.executeBatch();
		   con.commit();
		   System.out.println("batch is successfully executed");
	   }
	   catch(Exception e)
	   {
		   try
		   {
			   con.rollback();
			   System.out.println("batch is failed");
			   System.out.println("Exception is"+e);
		   }
		   catch(Exception e1)
		   {
			   System.out.println("Exception is"+e1);
		   }
	   }
	}

}
