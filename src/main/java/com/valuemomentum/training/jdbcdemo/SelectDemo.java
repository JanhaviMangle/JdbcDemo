package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC program to display records from candidates table in mysqljdbc db.
public class SelectDemo {

	public static void main(String[] args) {
		
		 Connection con;
         Statement stmt;
         ResultSet rs;

     try
      {

	//register JDBC DRIVER
	
    Class.forName("com.mysql.jdbc.Driver");

    //Open a connection

    System.out.println("Connecting to database");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "Janu@mangle");

    //excute a query

       stmt=con.createStatement();
       rs=stmt.executeQuery("select * from candidates");

    //Extra data from result set

   while(rs.next())
        {
          System.out.println(rs.getInt(1)+ " " +rs.getString(2)+ " " 
        +rs.getString(3)+" " +rs.getString(4) + " "+rs.getInt(5)+ " "  +rs.getString(6));
        }

           rs.close();
           stmt.close();
           con.close();
        }

            catch (Exception e)
                  {
                    System.out.println(e);
                   }
        }



	}


