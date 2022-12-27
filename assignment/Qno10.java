
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Qno10 {
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Assignment?useSSL=false","root","password");
			int rno;
			
			PreparedStatement ps=con.prepareStatement("select count(rno) from student");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				System.out.println("No. of Columns="+rs.getInt(1));
			}
			else
			{
				System.out.println("No Record Found");
			}
		
			ps.close();
			con.close();
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("done");
	}
	

}
