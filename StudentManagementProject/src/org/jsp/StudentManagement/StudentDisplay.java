package org.jsp.StudentManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDisplay {
	public void Display(Connection Con) throws Exception {
		Statement Stm = null;
		ResultSet R = null;
		try {
			System.out.println("");
			System.out.println("\t\t\t\t\t\t\tJSPIET STUDENT MANAGEMENT SYSTEM TABLE");
			System.out.println("\t\t\t\t\t\t\t--------------------------------------");
			Stm = Con.createStatement();
			R = Stm.executeQuery("SELECT * from " + "Student_data_Management_System");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_RegNo" + "\t\t"
					+ "S_Gendar" + "\t" + "S_MobileNo" + "\t\t  " + "S_Fees" + "\t   " + "S_Address");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");
			while (R.next()) {
				System.out.println(R.getInt(1) + "\t\t" + R.getString(2) + "\t\t" + R.getString(3) + "\t\t"
						+ R.getInt(4) + "\t\t" + R.getString(5) + "\t\t" + "+91-" + R.getLong(6) + "\t\t"
						+ "INR "+R.getDouble(8) + "\t   " + R.getString(7));
			}
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");
		} finally {
			Con.close();
			Stm.close();
			R.close();
		}
	}
}
