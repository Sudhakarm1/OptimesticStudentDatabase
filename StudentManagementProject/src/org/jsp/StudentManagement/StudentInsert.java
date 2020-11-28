package org.jsp.StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class StudentInsert {
	Scanner Sc = new Scanner(System.in);
	Random R = new Random();

	public void InsertTable(Connection Con) throws Exception {
		PreparedStatement Ptsm = null;
		int Number = 0;
		try {
			Ptsm = Con.prepareStatement(
					"INSERT INTO Student_data_Management_System (S_Fname,S_Lname,S_RegNo,S_Gender,S_Mobile,S_Address,S_Fees) VALUES (?,?,?,?,?,?,?)");
			System.out.println("Enter Number of Rows You want to Insert :");
			System.out.println("-------------------------------------------");
			int Length = Sc.nextInt();
			Number = Length;
			// S_Fname, S_Lname, S_Gendar, S_MobileNo, S_Fees, S_Address
			for (int i = 0; i < Length; i++) {
				System.out.println("Enter Student First Name");
				String Fname = Sc.next();
				System.out.println("-------------------------------------------");
				System.out.println("Enter Student Last Name");
				String Lname = Sc.next();
				System.out.println("-------------------------------------------");
				int G = Gender();
				String Gen = "";
				switch (G) {
				case 1:
					Gen = "M";
					break;
				case 2:
					Gen = "F";
					break;
				case 3:
					Gen = "O";
					break;
				default:
					System.out.println("Invalid Data Try Again");
					Gender();
				}
				System.out.println("-------------------------------------------");
				long Mno = Mobile();
				System.out.println("-------------------------------------------");
				double Fee = Fees();
				System.out.println("-------------------------------------------");
				System.out.println("Enter Student Address");
				String Add = Sc.next();
				System.out.println("-------------------------------------------");
				// System.out.println("Enter Student Id");
				// int Id= Sc.nextInt();
				int min = 1;
				int max = 1000;
				int Random = (int) (Math.random() * (max - min + 1) + min);
				System.out.println("This is Your Registeration Number : "+Random);
				Ptsm.setString(1, Fname);
				Ptsm.setString(2, Lname);
				Ptsm.setInt(3, Random);
				Ptsm.setString(4, Gen);
				Ptsm.setLong(5, Mno);
				Ptsm.setString(6, Add);
				Ptsm.setDouble(7, Fee);
				Ptsm.executeUpdate();
			}
			if (Number > 0) {
				System.out.println("Sucessfully " + Number + " rows Inserted");
				System.out.println("If you Want to Insert More Rows Please Enter 1 Otherwise Enter 2");
				int Enter = Sc.nextInt();
				More(Enter);
			} else {
				System.out.println(Number + " rows Inserted");
				System.out.println("If you Want to Insert Enter 1 Otherwise Enter 2");
				int Enter = Sc.nextInt();
				More(Enter);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Con.close();
			Ptsm.close();
		}
	}

	public void More(int Enter) throws Exception {
		switch (Enter) {
		case 1:
			DBConnection DB = new DBConnection();
			Connection Con = DB.Database();
			InsertTable(Con);
			break;
		case 2:
			break;
		}
	}

	public int Gender() {
		System.out.println("Enter Student Gender");
		System.out.println("1.Male 2.Female 3.Others");
		int Num = Sc.nextInt();
		return Num;
	}

	public long Mobile() {
		System.out.println("Enter Student Mobile Number(Should Be 10 Digit)");
		long Mno = Sc.nextLong();
		String Mno1 = Mno + "";
		if (Mno1.length() == 10) {
			System.out.println("Accepted");
			return Mno;
		} else {
			System.out.println("Not Accepted Should Be 10 Digit");
			return Mobile();
		}
	}
	public double Fees()
	{
		System.out.println("Enter Student Fees");
		double Fee = Sc.nextDouble();
		if(Fee>100.00)
		{
			return Fee;
		}
		else
		{
			System.out.println("Please Pay More then 100.00 INR : ");
			return Fees();
		}
	}
}