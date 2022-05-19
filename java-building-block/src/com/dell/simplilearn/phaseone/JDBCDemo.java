package com.dell.simplilearn.phaseone;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) throws InterruptedException {
		//Step 1: Register the driver
		try {
			// Step 1: Register the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			
			// Step 2: Connect to the database
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=password");
			
			// Step 3: Create statement
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// Step 4: Create a query
			
			String name = "'Dummy' or 1=1";
			ResultSet rs = stmt.executeQuery("select * from Emp where name =" +  name) ;
			
			 
//			while (rs.next()) {
//				System.out.println(rs.getString(1) + " " + rs.getString(2));
//			}
//			
			rs.absolute(5);
			System.out.println(rs.getString(1) + " " + rs.getString(2));
			
			rs.next();
			System.out.println(rs.getString(1) + " " + rs.getString(2));
			
			rs.previous();
			System.out.println(rs.getString(1) + " " + rs.getString(2));
			
			rs.first();
			System.out.println(rs.getString(1) + " " + rs.getString(2));
			
			rs.last();
			System.out.println(rs.getString(1) + " " + rs.getString(2));
			
			
			// Statement interface
			int result = stmt.executeUpdate("delete from Emp where name = 'Sumith'");
			System.out.println("Records affected: "+ result);
			
			
			// insert into table Emp values(inpu1, input2, ...)
			
			PreparedStatement preparedStatement = con.prepareStatement("insert into Emp values(?,?,?)");
			preparedStatement.setString(1, "Simplilearn");
			preparedStatement.setString(2, "1980-12-06");
			preparedStatement.setString(3, "Denver");
			
			
			
			result = preparedStatement.executeUpdate();
			System.out.println("Records affected: "+ result);
			
			preparedStatement = con.prepareStatement("update Emp set name=? where name=?");
			preparedStatement.setString(1, "DELL Simplilearn");
			preparedStatement.setString(2, "Simplilearn");
			
			result = preparedStatement.executeUpdate();
			System.out.println("Records affected: "+ result);
			
			
			// RSMD
			
			preparedStatement = con.prepareStatement("select * from Emp");
			rs = preparedStatement.executeQuery();
			
			ResultSetMetaData data = rs.getMetaData();
			System.out.println("Total columns: " + data.getColumnCount());
			System.out.println("Column name of 1st column: " + data.getColumnName(1));
			System.out.println("Column type name of 1st column: " + data.getColumnTypeName(1));
			
			
			// DBMD
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println("Driver name: " + dbmd.getDriverName());
			System.out.println("Driver version: " + dbmd.getDriverVersion());
			System.out.println("Username: " + dbmd.getUserName());
			System.out.println("Datbase product name: " + dbmd.getDatabaseProductName());
			System.out.println("Database product version: " + dbmd.getDatabaseProductVersion());
			
			String table[] = {"TABLE", "VIEW"};
			
			rs = dbmd.getTables(null, null, null, table);
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " "  + rs.getString(3));
			}
			
			// Transaction management
			con.setAutoCommit(false);
			
			Statement stmt1 = con.createStatement();
//			stmt1.executeUpdate("insert into Emp values('Dummy', '1980-11-06', 'Denver')");
//			stmt1.executeUpdate("insert into Emp values('Dummy 2', '1980-11-06', 'Denver')");
			
			stmt1.addBatch("insert into Emp values('Dummy 3', '1980-11-06', 'Denver')");
			stmt1.addBatch("insert into Emp values('Dummy 4', '1980-11-06', 'Denver')");
			stmt1.addBatch("insert into Emp values('Dummy 5', '1980-11-06', 'Denver')");
			stmt1.addBatch("insert into Emp values('Dummy 6', '1980-11-06', 'Denver')");
			
			
			stmt1.executeBatch();
			
			preparedStatement = con.prepareStatement("insert into Emp values(?,?,?)");
			
			preparedStatement.setString(1, "Dummy 7");
			preparedStatement.setString(2, "1980-12-06");
			preparedStatement.setString(3, "Denver");
			
			
			preparedStatement.addBatch();
			
			preparedStatement.setString(1, "Dummy 8");
			preparedStatement.setString(2, "1980-12-06");
			preparedStatement.setString(3, "Denver");
			preparedStatement.addBatch();
			
			preparedStatement.setString(1, "Dummy 9");
			preparedStatement.setString(2, "1980-12-06");
			preparedStatement.setString(3, "Denver");
			preparedStatement.addBatch();
			
			preparedStatement.setString(1, "Dummy 10");
			preparedStatement.setString(2, "1980-12-06");
			preparedStatement.setString(3, "Denver");
			preparedStatement.addBatch();
			
			preparedStatement.executeBatch();
			
			con.commit();
			
//			con.rollback();
//			Thread.sleep(5000);
			
			// Batch processing
			
			// Step 5: Close the connection
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
