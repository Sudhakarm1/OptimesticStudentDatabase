package org.jsp.StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDelete {
	Scanner Sc = new Scanner(System.in);
	PreparedStatement Ptsm = null;
	Statement Stm = null;
	DBConnection DB = new DBConnection();
	int Num = 0;
	ResultSet Rs = null;

	public void DeleteData(Connection Con) throws Exception {
		Con = DB.Database();
		System.out.println("Which Column Data You want to Delete");
		System.out.println("1. First Name");
		System.out.println("2. Registeration Number");
		System.out.println("3. Mobile Number");
		int Ch = Sc.nextInt();
		switch (Ch) {
		case 1:
			Con = DB.Database();
			System.out.println("Enter Your First Name");
			String Str = Sc.next();
			String Str1 = "Select S_Fname, count(*) from Student_data_Management_System WHERE S_Fname=?";
			// int Num1=Integer.parseInt(Str1);
			Ptsm = Con.prepareStatement(Str1);
			Ptsm.setString(1, Str);
			Rs = Ptsm.executeQuery();
			Rs.next();
			if (Rs.getInt(2) != 0) {
				Rs = Ptsm.executeQuery();
				while (Rs.next()) {
					// System.out.println(Rs.getString(1)+"\t\t"+Rs.getInt(2));
					Con = DB.Database();
					String Str2 = Rs.getString(1);
					if (Str2.equals(Str) && Rs.getInt(2) > 1) {
						Con = DB.Database();
						Ptsm = Con.prepareStatement(
								"SELECT * from " + "Student_data_Management_System " + "WHERE S_Fname= ?");
						Ptsm.setString(1, Str2);
						Rs = Ptsm.executeQuery();
						System.out.println("\t\t\t\t\t\t\t\tYOU DATE IS DUPLICATE ROW");
						System.out.println("\t\t\t\t\t\t\t\t--------------------------");
						System.out.println(
								"-----------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_RegNo"
								+ "\t\t" + "S_Gendar" + "\t" + "S_MobileNo" + "\t\t  " + "S_Fees" + "\t\t" + "S_Address");
						System.out.println(
								"-----------------------------------------------------------------------------------------------------------------------------------------------");
						while (Rs.next()) {
							System.out.println(Rs.getInt(1) + "\t\t" + Rs.getString(2) + "\t\t" + Rs.getString(3)
									+ "\t\t" + Rs.getInt(4) + "\t\t" + Rs.getString(5) + "\t\t" + "+91-"+Rs.getLong(6) + "\t\t"
									+ "INR "+Rs.getDouble(8) + "\t\t" + Rs.getString(7));
						}
						System.out.println(
								"-----------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("Please Enter Your Register Number Based on Table");
						int RegNo = Sc.nextInt();
						Con = DB.Database();
						Ptsm = Con.prepareStatement(
								"DELETE FROM " + "Student_data_Management_System " + "WHERE S_RegNo= ?");
						Ptsm.setInt(1, RegNo);
						Ptsm.executeUpdate();
						System.out.println("Your Data Sucessfully Deleted");
					} else {
						Con = DB.Database();
						Ptsm = Con.prepareStatement(
								"DELETE FROM " + "Student_data_Management_System " + "WHERE S_Fname= ?");
						Ptsm.setString(1, Str2);
						Ptsm.executeUpdate();
						System.out.println("Your Data Sucessfully Deleted");
					}
				}
			} else {
				System.out.println("Your Firstname Mismatch Please Try Again");
				DeleteData(Con);
			}
			break;
		case 2:
			System.out.println("Please Enter Your Register Number");
			int RegNo = Sc.nextInt();
			String Str2 = "Select S_Fname, count(*) from Student_data_Management_System WHERE S_RegNo=?";
			// int Num1=Integer.parseInt(Str1);
			Ptsm = Con.prepareStatement(Str2);
			Ptsm.setInt(1, RegNo);
			Rs = Ptsm.executeQuery();
			while (Rs.next()) {
				if (Rs.getInt(2) > 0) {
					Ptsm = Con
							.prepareStatement("DELETE FROM " + "Student_data_Management_System " + "WHERE S_RegNo= ?");
					Ptsm.setInt(1, RegNo);
					Ptsm.executeUpdate();
					System.out.println("Your Data Sucessfully Deleted");
				} else {
					System.out.println("Your Register Number Mismatch Please Try Again");
					Con = DB.Database();
					DeleteData(Con);
				}
			}
			break;
		case 3:
			System.out.println("Please Enter Your Mobile Number");
			long Mobile = Sc.nextLong();
			String Str3 = "Select S_Fname, count(*) from Student_data_Management_System WHERE S_Mobile=?";
			// int Num1=Integer.parseInt(Str1);
			Ptsm = Con.prepareStatement(Str3);
			Ptsm.setLong(1, Mobile);
			Rs = Ptsm.executeQuery();
			while (Rs.next()) {
				if (Rs.getInt(2) > 0) {
					Ptsm = Con
							.prepareStatement("DELETE FROM " + "Student_data_Management_System " + "WHERE S_Mobile= ?");
					Ptsm.setLong(1, Mobile);
					Ptsm.executeUpdate();
					System.out.println("Your Data Sucessfully Deleted");
					break;
				} else {
					System.out.println("Your Mobile Number Mismatch Please Try Again");
					Con = DB.Database();
					DeleteData(Con);
				}
			}
		}
	}
}
