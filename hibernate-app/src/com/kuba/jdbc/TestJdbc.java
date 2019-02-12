package com.kuba.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user= "root";
		String pass = "polakpl51";
		
		try{
			
			System.out.println("Testing conn: " + jdbcUrl);
			
			Connection myConnection = 
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful");
			
		}catch (Exception exc){
			exc.printStackTrace();
		}
		
		
	}

}
