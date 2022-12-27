package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Assignment4 {
	public static void main(String args[])
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Assignment?useSSL=false","root","password");
		
			PreparedStatement s=con.prepareStatement("select * from student order by marks");
			ResultSet rs=s.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
			}
		
			s.close();
			con.close();
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("done");
	}
	

}