package com.jacks.cyw.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

	 String status = "";
	 Connection conn;
	 PreparedStatement pst;
	 ResultSet rs;
	 public UserService() {
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cyw", "root", "root");
			
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 public  String login(String id , String password) {
			
			
			
			try 
			{
				
				// replace fake_password with password (testing only)
				pst = conn.prepareStatement("select * from USER where id=? and fake_password=?");
				pst.setString(1, id);
				pst.setString(2, password);
				
				rs = pst.executeQuery();
				boolean hasRecord = rs.next();
				if(hasRecord==true)
				{
					status =  "Login Successful";
				}
				else status="Login Failure";
			}
			catch(Exception e)
			{
				status = "This Site Is Under Construction!!!\nWe Will Back Soon...";
				e.printStackTrace();
			}
			
		
			return status;
		}
	
	 public String process(String qid,String code)
	 {
		 System.out.println(qid+" "+code);
			try
			{
				// replace fake_code with code (testing only)
				pst = conn.prepareStatement("select * from DATA where id=? and fake_code=?");
				pst.setString(1, qid);
				pst.setString(2, code);
				
				rs = pst.executeQuery();
				boolean hasRecord = rs.next();
				if(hasRecord==true)
				{
					status =  "correct";
				}
				else status="wrong";
			}
			catch(Exception e)
			{
				status = "This Site Is Under Construction!!!\nWe Will Back Soon...";
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		
			return status;
	 }
}
