package org.jsp.StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentSearch {
	DBConnection DB = new DBConnection();
	Connection Con = null;
	Scanner Sc = new Scanner(System.in);

	public void Search(Connection Con) throws Exception {
		Con = DB.Database();
		PreparedStatement Ptsm = null;
		ResultSet R = null;
		System.out.println("Enter Which Column You want to Search");
		System.out.println("1.FirstName");
		System.out.println("2.Registe Number");
		System.out.println("3.Mobile Number");
		int Ch = Sc.nextInt();
		switch (Ch) {
		case 1:
			System.out.println("Enter Your First name");
			String Str = Sc.next();
			Ptsm = Con.prepareStatement(
					"SELECT S_Fname,COUNT(*) FROM Student_data_Management_System " + "WHERE S_Fname=?");
			Ptsm.setString(1, Str);
			R = Ptsm.executeQuery();
			R.next();
			if (R.getInt(2) == 1) {
				Ptsm = Con.prepareStatement("SELECT * FROM Student_data_Management_System " + "WHERE S_Fname=?");
				Ptsm.setString(1, Str);
				R = Ptsm.executeQuery();
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_RegNo" + "\t\t"
						+ "S_Gendar" + "\t" + "S_MobileNo" + "\t\t  " + "S_Fees" + "\t   " + "S_Address");
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				while (R.next()) {
					System.out.println(R.getInt(1) + "\t\t" + R.getString(2) + "\t\t" + R.getString(3) + "\t\t"
							+ R.getInt(4) + "\t\t" + R.getString(5) + "\t\t" + "+91-" + R.getLong(6) + "\t\t" + "INR "
							+ R.getDouble(8) + "\t   " + R.getString(7));
				}
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("If you Want to Search Again Enter 1 Otherwise Enter 2");
				int Enter = Sc.nextInt();
				More(Enter);
			} else if (R.getInt(2) > 1) {
				System.out.println("Duplicate Values are there Please Try Using Aother Data");
				Con = DB.Database();
				Search(Con);
			} else {
				System.out.println("Values are Mismatch Please Try Using Aother Data");
				Search(Con);
			}
			break;
		case 2:
			System.out.println("Enter Your First name");
			int Reg = Sc.nextInt();
			Ptsm = Con.prepareStatement(
					"SELECT S_Fname,COUNT(*) FROM Student_data_Management_System " + "WHERE S_RegNo=?");
			Ptsm.setInt(1, Reg);
			R = Ptsm.executeQuery();
			R.next();
			if (R.getInt(2) == 1) {
				Ptsm = Con.prepareStatement("SELECT * FROM Student_data_Management_System " + "WHERE S_RegNo=?");
				Ptsm.setInt(1, Reg);
				R = Ptsm.executeQuery();
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_RegNo" + "\t\t"
						+ "S_Gendar" + "\t" + "S_MobileNo" + "\t\t  " + "S_Fees" + "\t   " + "S_Address");
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				while (R.next()) {
					System.out.println(R.getInt(1) + "\t\t" + R.getString(2) + "\t\t" + R.getString(3) + "\t\t"
							+ R.getInt(4) + "\t\t" + R.getString(5) + "\t\t" + "+91-" + R.getLong(6) + "\t\t" + "INR "
							+ R.getDouble(8) + "\t   " + R.getString(7));
				}
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("If you Want to Search Again Enter 1 Otherwise Enter 2");
				int Enter = Sc.nextInt();
				More(Enter);
			} else {
				System.out.println("Values are Mismatch Please Try Using Aother Data");
				Search(Con);
			}
			break;
		case 3:
			System.out.println("Enter Your Mobile Number");
			long Mobil = Sc.nextLong();
			Ptsm = Con.prepareStatement("SELECT * FROM Student_data_Management_System " + "WHERE S_Mobile=?");
			Ptsm.setLong(1, Mobil);
			Ptsm = Con.prepareStatement(
					"SELECT S_Fname,COUNT(*) FROM Student_data_Management_System " + "WHERE S_Mobile=?");
			Ptsm.setLong(1, Mobil);
			R = Ptsm.executeQuery();
			R.next();
			if (R.getInt(2) == 1) {
				Ptsm = Con.prepareStatement("SELECT * FROM Student_data_Management_System " + "WHERE S_Mobile=?");
				Ptsm.setLong(1, Mobil);
				R = Ptsm.executeQuery();
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_RegNo" + "\t\t"
						+ "S_Gendar" + "\t" + "S_MobileNo" + "\t\t  " + "S_Fees" + "\t   " + "S_Address");
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				while (R.next()) {
					System.out.println(R.getInt(1) + "\t\t" + R.getString(2) + "\t\t" + R.getString(3) + "\t\t"
							+ R.getInt(4) + "\t\t" + R.getString(5) + "\t\t" + "+91-" + R.getLong(6) + "\t\t" + "INR "
							+ R.getDouble(8) + "\t   " + R.getString(7));
				}
				System.out.println(
						"-----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println("If you Want to Search Again Enter 1 Otherwise Enter 2");
				int Enter = Sc.nextInt();
				More(Enter);
			} else {
				System.out.println("Values are Mismatch Please Try Using Aother Data");
				Search(Con);
			}
			break;
		}
	}

	public void More(int Enter) throws Exception {
		switch (Enter) {
		case 1:
			DBConnection DB = new DBConnection();
			Connection Con = DB.Database();
			Search(Con);
			break;
		case 2:
			break;
		}
	}
}
