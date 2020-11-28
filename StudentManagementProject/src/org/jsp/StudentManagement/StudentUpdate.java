package org.jsp.StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.Scanner;

public class StudentUpdate {
	Scanner Sc = new Scanner(System.in);
	DBConnection DB = new DBConnection();
	Connection Con = null;
	PreparedStatement Ptsm = null;

	public void UpdateTable(Connection Con) throws Exception {
		Ptsm = null;
		System.out.println("which Column You are Going to use Operation");
		System.out.println("-------------------------------------------");
		System.out.println("1.Mobile Number");
		System.out.println("2.Register Number");
		// System.out.println("3.First Name");
		System.out.println("-------------------------------------------");
		int Ch = Sc.nextInt();
		UpdateValue(Ch);
	}

	public void UpdateValue(int Ch) throws Exception {
		switch (Ch) {
		case 1:
			System.out.println("Please Enter Student Mobile Number");
			long Mobil = Sc.nextLong();
			System.out.println("-------------------------------------");
			UpdateMob(Mobil);
			break;
		case 2:
			System.out.println("Please Enter Student Register Number");
			int Reg = Sc.nextInt();
			System.out.println("-------------------------------------");
			UpdateReg(Reg);
			break;
		}
	}

	public void UpdateMob(long mobil) throws Exception {
		System.out.println("Which Colum You are going to Update");
		System.out.println("-------------------------------------");
		System.out.println("1.Fee");
		System.out.println("2.First Name");
		System.out.println("3.Last Name");
		System.out.println("4.Gender");
		System.out.println("5.Address");
		System.out.println("6.Mobile Number");
		System.out.println("------------------------------------");
		int Ch1 = Sc.nextInt();
		Con = DB.Database();
		UpdateValueUsingMob(Ch1, null, Con, mobil);
	}

	public void UpdateValueUsingMob(int Ch1, PreparedStatement Ptsm, Connection Con, long mobil) throws Exception {
		double Fee = 0.0;
		String Fname2 = null;
		String Lname = null;
		String Address = null;
		long Mobile = 0;
		String Gender = null;
		switch (Ch1) {
		case 1:
			System.out.println("Please Enter Student Fees");
			Fee = Sc.nextDouble();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Fees=" + Fee + " WHERE S_Mobile=" + mobil);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 2:
			System.out.println("Please Enter Student FirstName");
			Fname2 = Sc.next();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Fname=?" + " WHERE S_Mobile=" + mobil);
			Ptsm.setString(1, Fname2);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 3:
			System.out.println("Please Enter Student Last name");
			Lname = Sc.next();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Lname=?" + " WHERE S_Mobile=" + mobil);
			Ptsm.setString(1, Lname);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 4:
			System.out.println("Please Enter Student Gender");
			Gender = Sc.next();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Gender=?" + " WHERE S_Mobile=" + mobil);
			Ptsm.setString(1, Gender);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 5:
			System.out.println("Please Enter Student Address");
			Address = Sc.next();
			Ptsm = Con.prepareStatement(
					"UPDATE student_management_system" + " SET S_Address=?" + " WHERE S_Mobile=" + mobil);
			Ptsm.setString(1, Address);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 6:
			System.out.println("Please Enter Student Mobile No");
			Mobile = Sc.nextLong();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_MobileNo=" + Mobile + " WHERE S_Mobile=" + mobil);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		}
		UpdateAgain(Fee, Fname2, Lname, Gender, Address, Mobile);
	}

	public void UpdateReg(int Reg) throws Exception {
		System.out.println("Which Colum You are going to Update");
		System.out.println("-------------------------------------");
		System.out.println("1.Fee");
		System.out.println("2.First Name");
		System.out.println("3.Last Name");
		System.out.println("4.Gender");
		System.out.println("5.Address");
		System.out.println("6.Mobile Number");
		System.out.println("------------------------------------");
		int Ch1 = Sc.nextInt();
		Con = DB.Database();
		UpdateValueUsingReg(Ch1, null, Con, Reg);
	}

	public void UpdateValueUsingReg(int Ch1, PreparedStatement Ptsm, Connection Con, int Reg) throws Exception {
		double Fee = 0.0;
		String Fname2 = null;
		String Lname = null;
		String Address = null;
		long Mobile = 0;
		String Gender = null;
		switch (Ch1) {
		case 1:
			System.out.println("Please Enter Student Fees");
			System.out
					.println("---------------------------------------------------------------------------------------");
			Fee = Sc.nextDouble();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Fees=" + Fee + " WHERE S_RegNo=" + Reg);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 2:
			System.out.println("Please Enter Student Firt Name");
			System.out
					.println("---------------------------------------------------------------------------------------");
			Fname2 = Sc.next();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Fname=?" + " WHERE S_RegNo=" + Reg);
			Ptsm.setString(1, Fname2);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 3:
			System.out.println("Please Enter Student Last name");
			System.out
					.println("---------------------------------------------------------------------------------------");
			Lname = Sc.next();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Lname=?" + " WHERE S_RegNo=" + Reg);
			Ptsm.setString(1, Lname);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 4:
			System.out.println("Please Enter Student Gender");
			System.out
					.println("---------------------------------------------------------------------------------------");
			Gender = Sc.next();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Gender=?" + " WHERE S_RegNo=" + Reg);
			Ptsm.setString(1, Gender);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 5:
			System.out.println("Please Enter Student Address");
			System.out
					.println("---------------------------------------------------------------------------------------");
			Address = Sc.next();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_Address=?" + " WHERE S_RegNo=" + Reg);
			Ptsm.setString(1, Address);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		case 6:
			System.out.println("Please Enter Student Mobile No");
			System.out
					.println("---------------------------------------------------------------------------------------");
			Mobile = Sc.nextLong();
			Ptsm = Con.prepareStatement(
					"UPDATE Student_data_Management_System" + " SET S_MobileNo=" + Mobile + " WHERE S_RegNo=" + Reg);
			Ptsm.executeUpdate();
			System.out.println("Sucessfully Updated");
			break;
		}
		// UpdateAgain();
		UpdateAgain(Fee, Fname2, Lname, Gender, Address, Mobile);
	}

	public void UpdateAgain(double Fee, String Fname2, String Lname, String Gender, String Address, long Mobile)
			throws Exception {
		System.out.println("If You want to Update Again Enter 1");
		System.out.println("If You want to Display Your Updated row Enter 2");
		int Ch = Sc.nextInt();
		switch (Ch) {
		case 1:
			Con = DB.Database();
			UpdateTable(Con);
			break;
		case 2:
			ResultSet R = null;
			if (Fname2 != null) {
				Ptsm = Con.prepareStatement("SELECT * from " + "Student_data_Management_System " + "WHERE S_Fname= ?");
				Ptsm.setString(1, Fname2);
			} else if (Lname != null) {
				R = null;
				Ptsm = Con.prepareStatement("SELECT * from " + "Student_data_Management_System " + "WHERE S_Lname= ?");
				Ptsm.setString(1, Lname);
			} else if (Fee != 0.0) {
				R = null;
				Ptsm = Con.prepareStatement("SELECT * from " + "Student_data_Management_System " + "WHERE S_Fees= ?");
				Ptsm.setDouble(1, Fee);
			} else if (Gender != null) {
				R = null;
				Ptsm = Con.prepareStatement("SELECT * from " + "Student_data_Management_System " + "WHERE S_Gendar= ?");
				Ptsm.setString(1, Gender);
			} else if (Address != null) {
				R = null;
				Ptsm = Con
						.prepareStatement("SELECT * from " + "Student_data_Management_System " + "WHERE S_Address= ?");
				Ptsm.setString(1, Address);
			} else if (Mobile != 0) {
				R = null;
				Ptsm = Con.prepareStatement("SELECT * from " + "Student_data_Management_System " + "WHERE S_Mobile= ?");
				Ptsm.setLong(1, Mobile);
			}
			R = Ptsm.executeQuery();
			System.out.println("\t\t\t\t\t\t\t\tUPDATED ROW");
			System.out.println("\t\t\t\t\t\t\t\t------------");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_RegNo" + "\t\t"
					+ "S_Gendar" + "\t" + "S_MobileNo" + "\t\t  " + "S_Fees"+ "\t\t" + "S_Address");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");
			while (R.next()) {
				System.out.println(R.getInt(1) + "\t\t" + R.getString(2) + "\t\t" + R.getString(3) + "\t\t"
						+ R.getInt(4) + "\t\t" + R.getString(5) + "\t\t" +"+91-"+ R.getLong(6) + "\t\t"+ "INR "+R.getDouble(8) + "\t\t"+ R.getString(7)
						);
			}
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");
			break;
		}
	}
}