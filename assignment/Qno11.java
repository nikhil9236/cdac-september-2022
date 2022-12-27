package assignment;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Qno11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rno");
		int rno = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter marks");
		float marks = sc.nextFloat();

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/assignment?useSSL=false","root","password");
			CallableStatement s = con.prepareCall("{ call insertRecord(?,?,?) }");
			s.setInt(1, rno);
			s.setString(2, name);
			s.setFloat(3, marks);

			int i = s.executeUpdate();
			
			System.out.println(i+" rows inserted");
			s.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
		}
		
		System.out.println("done");
		
	}

}
