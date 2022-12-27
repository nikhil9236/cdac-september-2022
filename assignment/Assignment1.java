package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Assignment1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/assignment?useSSL=false","root","password");
			PreparedStatement ps= con.prepareStatement("select * from student");
			boolean flag = ps.execute();
			
			if(flag) 
			{
				System.out.println("Sucessfully Executed yesss");
			}
			else
			{
				System.out.println("Sucessfully Executed noooo");
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		

	}

}
