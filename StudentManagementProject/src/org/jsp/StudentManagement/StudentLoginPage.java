package org.jsp.StudentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentLoginPage {
	Scanner Sc = new Scanner(System.in);   
	PreparedStatement Stm = null;
	ResultSet R = null;
	DBConnection DB = new DBConnection();
	Connection Con = null;

	public void LoginPage(Connection Con) throws Exception {
			Stm = Con.prepareStatement("SELECT * FROM Student_data_Management_System " + "WHERE S_Mobile=? AND S_Fname=?");
			System.out.println("Enter UserName : ");
			String Uname = Sc.next();
			System.out.println("Enter MobileNumber : ");
			long Mno = Sc.nextLong();
			Stm.setString(2, Uname);
			Stm.setLong(1, Mno);
			R = Stm.executeQuery();
			if (R.next() == true) {
				//System.out.println("Your FirstName is Correct and Mobile Number is Correct");
				Con = DB.Database();
				PrintDisplay(Uname,Mno,Con);
			} else {
				//System.out.println("Mobile Number is Wrong Please Enter Correct MobileNumber");
				System.out.println("Invalid Username / Mobile Number");
				LoginPage(Con);
			}
		}
	public void PrintDisplay(String Uname,long Mno,Connection Con) throws Exception
	{
		Statement Stm = null;
		ResultSet R = null;
		try {
			Stm = Con.createStatement();
			System.out.println("");
			System.out.println("\t\t\t\t\t\t\t\tTHIS IS "+Uname.toUpperCase()+" DETAIL");
			System.out.println("\t\t\t\t\t\t\t----------------------------------------");
			R = Stm.executeQuery("SELECT * from " + "Student_data_Management_System "+"WHERE S_Mobile= "+Mno);
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("S_Id" + "\t\t" + "S_Fname" + "\t\t" + "S_Lname" + "\t\t" + "S_RegNo" + "\t\t"
					+ "S_Gendar" + "\t" + "S_MobileNo" + "\t\t" + "S_Address" + "\t\t" + "S_Fees");
			System.out.println(
					"-----------------------------------------------------------------------------------------------------------------------------------------------");
			while (R.next()) {
				System.out.println(R.getInt(1) + "\t\t" + R.getString(2) + "\t\t" + R.getString(3) + "\t\t" + R.getInt(4)
						+ "\t\t" + R.getString(5) + "\t\t" + "+91-"+R.getLong(6) + "\t\t" + R.getString(7) + "\t\t"
						+ R.getDouble(8));
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