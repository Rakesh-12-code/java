package mysql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
public class Test {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("JDBC:mysql://localhost:3306/college","root","1234");
		Statement st=con.createStatement();
		st.executeUpdate("create table amt(amtid int,amtname varchar(12))");
		System.out.println("table created successfully");
		st.close();
		con.close();
	}
}