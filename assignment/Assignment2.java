package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter rno");
		int rno = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter marks");
		float marks = sc.nextFloat();
		System.out.println("Enter dob ");
		String dob = sc.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?useSSL=false", "root",
					"password");
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, rno);
			ps.setString(2, name);
			ps.setFloat(3, marks);
			ps.setString(4, dob);

			int i = ps.executeUpdate();
			System.out.println(i + "rows inserted");
			ps.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
