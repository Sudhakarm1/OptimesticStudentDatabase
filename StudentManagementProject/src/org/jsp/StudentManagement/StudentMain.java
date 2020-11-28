package org.jsp.StudentManagement;

import java.sql.Connection;
import java.util.Scanner;

public class StudentMain {
	static {
		System.out.println("\t\t\t\t\t\t\t\tWELCOME TO JSP");
		System.out.println("\t\t\t\t\t\t\t\t---------------");
		System.out.println("\t\t\t\t\t\t\tJSPIET STUDENT MANAGEMENT SYSTEM");
		System.out.println("\t\t\t\t\t\t\t---------------------------------");
		System.out.println("");
		DBConnection DB = new DBConnection();
		try {
			Connection Con = DB.Database();
			System.out.println("USER LOGIN PAGE : ");
			System.out.println("----------------");
			new StudentLoginPage().LoginPage(Con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		DBConnection DB = new DBConnection();
		Connection Con = DB.Database();
		Scanner Sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Your Option ");
			System.out.println("------------------");
			System.out.println("1.Display Table");
			System.out.println("2.Insert Data");
			System.out.println("3.Update Data ");
			System.out.println("4.Delete Data ");
			System.out.println("5.Search Data ");
			System.out.println("------------------");
			int Num = Sc.nextInt();
			switch (Num) {
			case 1:
				Con = DB.Database();
				new StudentDisplay().Display(Con);
				break;
			case 2:
				Con = DB.Database();
				new StudentInsert().InsertTable(Con);
				break;
			case 3:
				Con = DB.Database();
				new StudentUpdate().UpdateTable(Con);
				break;
			case 4:
				Con = DB.Database();
				new StudentDelete().DeleteData(Con);
				break;
			case 5:
				Con = DB.Database();
				new StudentSearch().Search(Con);
				break;
			case 6:
				System.out.println("Thank you JSP Student");
				Con.close();
				break;
			}
		}
	}
}