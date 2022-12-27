package assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Qno12 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter EmpID");
		int id = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter salary");
		int salary= sc.nextInt();
		System.out.println("Enter doj ");
		String doj = sc.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment?useSSL=false", "root",
					"password");
			con.setAutoCommit(false);
			
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setFloat(3, salary);
			ps.setString(4, doj);

			int i = ps.executeUpdate();			
			System.out.println(i + "rows inserted");
			
			
			System.out.println("Enter AddressID");
			int Aid = sc.nextInt();
			System.out.println("Enter city");
			String city = sc.next();
			System.out.println("Enter country");
			String country= sc.next();
			PreparedStatement ps1 = con.prepareStatement("insert into EAddress values(?,?,?,?)");
			ps1.setInt(1, Aid);
			ps1.setString(2, city);
			ps1.setString(3, country);
			ps1.setInt(4, id);
			
			int j = ps1.executeUpdate();			
			System.out.println(j + "rows inserted");
			
			con.commit();
			ps.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

}
