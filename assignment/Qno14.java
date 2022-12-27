
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Qno14 {
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Assignment?useSSL=false","root","password");
			System.out.println("Enter City You Want to search");
			String city= sc.next();
			PreparedStatement s=con.prepareStatement("select * from employee join eaddress on employee.Empid=eaddress.Empid where city=?");
			s.setString(1,city);
			ResultSet rs=s.executeQuery();
			boolean flag= false;
			while(rs.next()) 
			{
				flag=true;
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getInt(8));
			}
			if(!flag) 
			{
				System.out.println("No Records Found");
			}
		
			s.close();
			con.close();
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}
	

}
