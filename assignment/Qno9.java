package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Qno9 
{
	private static ResultSet rs;
	private static Scanner sc;
	
	public static void insert() throws SQLException
	{
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter marks");
		float marks = sc.nextFloat();
		System.out.println("Enter dob");
		String dob = sc.next();
		rs.moveToInsertRow();
		rs.updateInt(1, rno);
		rs.updateString(2, name);
		rs.updateFloat(3, marks);
		rs.updateString(4, dob);
		rs.insertRow();
		rs.moveToCurrentRow();
		
	}
	
	private static void update() throws SQLException 
	{
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		boolean flag = false;
		rs.beforeFirst();
		while(rs.next()) 
		{
			if(rs.getInt(1)==rno) 
			{
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter marks");
				float marks = sc.nextFloat();
				System.out.println("Enter dob");
				String dob = sc.next();
				
				rs.updateString(2, name);
				rs.updateFloat(3, marks);
				rs.updateString(4, dob);
				
				rs.updateRow();
				rs.moveToCurrentRow();
				flag = true;
				break;
			}

			
		}
		if(!flag) {
			System.out.println("record not found");
		}
	}
	private static void delete() throws SQLException 
	{
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		boolean flag = false;
		rs.beforeFirst();
		while(rs.next()) {
			if(rs.getInt(1)==rno) {
				rs.deleteRow();
				rs.moveToCurrentRow();
				flag = true;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("record not found");
		}
	}
	public static void main(String[] args) 
	{

		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?useSSL=false","root","password");
			PreparedStatement ps= con.prepareStatement("select * from Student",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
			sc= new Scanner(System.in);
			int choice;
			do 
			{
				System.out.println("0.Exit \n 1.insert \n 2.Update \n 3.Delete");
				choice=sc.nextInt();
				switch(choice)
				{
					case 0 : System.out.println("Exiting from app");
							break;
					case 1: insert();
							break;
					case 2 :update();
							break;
					case 3: delete();
							break;
					
					default: System.out.println("Wrong Choice");
				}
				
				
			}while(choice!=0);
			
			
		} 
		
		catch ( SQLException | ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}

	}
	
}
