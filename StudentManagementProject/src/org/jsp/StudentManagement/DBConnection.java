package org.jsp.StudentManagement;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
	public Connection Database() throws Exception {
		Properties Pro = new Properties();
		Pro.load(new FileReader(new File("./Test.Properties")));
		Class.forName(Pro.getProperty("driver"));
		Connection Con = DriverManager.getConnection(Pro.getProperty("url"), Pro);
		return Con;
	}
}
