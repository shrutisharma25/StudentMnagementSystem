package com.ty;

import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		StudentInterface s=new StudentImplementation();
		System.out.println("1.Adding Student Details\n2.Updating Student Details\n3.Deleting Student Details\n4.Deleting all Student Details\n5.Get Student details By Id\n6.Get All Student Details");
		System.out.println("Enter your choice:-");
		Scanner sc=new Scanner(System.in);
		int choice =sc.nextInt();
		switch(choice) {
		case 1:
			s.addStudent();
			break;
		case 2:
			s.updateStudent();
			break;
		case 3:
			s.deleteStudent();
			break;
		case 4:
			s.deleteAll();
			break;
		case 5:
			s.getStudentById();
			break;
		case 6:
			s.getAll();
			break;
		default:
			System.out.println("Invalid Input");
				
		}
	}

}
