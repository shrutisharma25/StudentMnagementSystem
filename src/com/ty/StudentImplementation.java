package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentImplementation implements StudentInterface {

	public void addStudent() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the student Id:-");
		int id=sc.nextInt();
		System.out.println("Enter the student Name:-");
		String name=sc.next();
		System.out.println("Enter the student age:-");
		int age=sc.nextInt();
		System.out.println("Enter the student marks:-");
		int marks=sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","tiger");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?)");
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3,age);
			preparedStatement.setInt(4,marks);
			preparedStatement.execute();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Details Added");
	}
	public void updateStudent() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the student Id:-");
		int id=sc.nextInt();
		System.out.println("Enter the student Name:-");
		String name=sc.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","tiger");
			PreparedStatement preparedStatement=connection.prepareStatement("update student set name=? where id=?");
			preparedStatement.setString(1,name);
			preparedStatement.setInt(2,id);
			preparedStatement.execute();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("Updated id");
	}
	public void deleteStudent() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the student Id:-");
		int id1=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","tiger");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from student where id=?");
			preparedStatement.setInt(1,id1);
			preparedStatement.execute();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("Data Deleted");
	}
	public void deleteAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","tiger");
			PreparedStatement preparedStatement=connection.prepareStatement("truncate table student");
			preparedStatement.execute();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		System.out.println("Deleted all details");
	}
	public void getStudentById() {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the student Id:-");
		int id1=sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","tiger");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student where id=?");
			preparedStatement.setInt(1, id1);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1)+"  ");
				System.out.print(resultSet.getString(2)+"  ");
				System.out.print(resultSet.getInt(3)+"  ");
				System.out.println(resultSet.getInt(4)+"  ");
				System.out.println();
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public void getAll() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdetails","root","tiger");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from student");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.print(resultSet.getInt(1)+"  ");
				System.out.print(resultSet.getString(2)+"  ");
				System.out.print(resultSet.getInt(3)+"  ");
				System.out.println(resultSet.getInt(4)+"  ");
				System.out.println();
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
