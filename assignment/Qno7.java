
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Qno7 {
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Assignment?useSSL=false","root","password");
			int rno;
			
			PreparedStatement ps=con.prepareStatement("select * from student where rno=?");
			
			System.out.println("Enter Roll no to search");
			rno=sc.nextInt();
			ps.setInt(1,rno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getString(4));
			}
			else
			{
				System.out.println("Record Not Found");
			}
		
			ps.close();
			con.close();
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("done");
	}
	

}
