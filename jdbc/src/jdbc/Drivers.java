package jdbc;

import java.sql.*;

public class Drivers {

	public static void main(String[] args) {
		
		try {
			// 1. Get a connection to database
			// where demo is goes the name of the database create in sql workbench
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "BeastMode27");
			
			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute a sql query
			ResultSet myRs = myStmt.executeQuery("select * from employees");
			
			// 4. Process the result set
			while(myRs.next()) {
				System.out.println(myRs.getString("last_Name") + ", " + myRs.getString("first_Name"));
			}
			
		}catch(Exception exc){
			exc.printStackTrace();
		}

	}

}
