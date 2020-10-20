package com.simplilearn.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class Main2 {

	public Main2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert into employee(name,salary,phone,gender,company) values(?,?,?,?,?)";

		try {
			DriverManager.registerDriver(new Driver());
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8", "root", "admin123");

			preparedStatement = connection.prepareStatement(query);

			System.out.println("Enter the recored count");
			Scanner sc = new Scanner(System.in);
			String n = sc.nextLine();
			int nn = Integer.parseInt(n);

			for (int i = 0; i < nn; i++) {

				// set values ?
				System.out.println("Enter name");
				String name = sc.nextLine();
				System.out.println("Enter salary");
				float salary = Float.parseFloat(sc.nextLine());
				System.out.println("Enter phone");
				String phone = sc.nextLine();

				System.out.println("Enter gender");
				char gender = sc.nextLine().charAt(0);

				System.out.println("Enter company");
				String company = sc.nextLine();

				preparedStatement.setString(1, name);
				preparedStatement.setFloat(2, salary);
				preparedStatement.setString(3, phone);
				preparedStatement.setString(4, "" + gender);
				preparedStatement.setString(5, company);

				int count = preparedStatement.executeUpdate();
				System.out.println("inserted=" + count);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {

			try {

				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error while closing");
			}

		}

	}

}
