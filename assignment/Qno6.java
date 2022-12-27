
package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Qno6 {
	private static ResultSet rs;
	private static Scanner sc=new Scanner(System.in);
	
	public static void insert(Connection con,Statement s) throws SQLException
	{
		System.out.println("Enter Rno");
		int rno=sc.nextInt();
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Marks");
		float marks=sc.nextFloat();
		System.out.println("Enter Dob(DD-MM-YYYY)");
		String dob=sc.next();
		int i=s.executeUpdate("insert into student values("+rno+",'"+name+"',"+marks+",'"+dob+"')");
		System.out.println(i+"rows inserted");
		
		
	}
	public static void update(Connection con,Statement s) throws SQLException
	{
		System.out.println("Enter Rno you want to update");
		int rno=sc.nextInt();
		System.out.println("Enter Name");
		String name=sc.next();
		System.out.println("Enter Marks");
		float marks=sc.nextFloat();
		System.out.println("Enter Dob(DD-MM-YYYY)");
		String dob=sc.next();
		int i=s.executeUpdate("update student set name='"+name+"', marks="+marks+", dob='"+dob+"' where rno="+rno);
		System.out.println(i+"rows updated");
		
		
	}
	public static void delete(Connection con,Statement s) throws SQLException
	{
		System.out.println("Enter Rollno you want to update");
		int rno=sc.nextInt();
		
		int i=s.executeUpdate("delete from student where rno="+rno+"");
		System.out.println(i+"rows updated");
		
		
	}
	public static void main(String args[])
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/Assignment?useSSL=false","root","password");
		
			Statement s=con.createStatement();
			int choice;
		
			do {
				System.out.println("0.Exit \n 1.Insert \n 2.Update  \n 3.Delete");
				choice=sc.nextInt();
				switch(choice)
				{
					case 0: break;
					case 1: insert(con,s);
							break;
					case 2: update(con,s);
							break;
					case 3: delete(con,s);
							break;
					default: System.out.println("Wrong Choice");;
							break;
				}	
					
			}while(choice!=0);
			
			s.close();
			con.close();
			 
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Application Closed...");
	}

}
