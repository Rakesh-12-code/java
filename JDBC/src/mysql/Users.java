package mysql;
import java.sql.*;
public class Users {
public static void main(String[] a) {
	String url="jdbc:mysql://localhost:3306/db1";
	String user="root";
	String pwd="1234";
	try(Connection con=DriverManager.getConnection(url,user,pwd);
			Statement stmt=con.createStatement()){
		String dropTableQ="DROP TABLE IF EXISTS Users";
		stmt.executeUpdate(dropTableQ);
		String createTableQ="create table Users(user_id int primary key,name varchar(50),email varchar(50),phone varchar(15))";
		stmt.executeUpdate(createTableQ);
		String insertQ="insert into Users(user_id,name,email,phone) values (101,'Sairaj','sairaj123@gmail.com','8564236945'),(102,'Pavan','pavan43@gmail.com','6532454465'),(103,'Srinadh','Sri@gmail.com','9658675482')";
		stmt.executeUpdate(insertQ);
		String selectQuery="select *from Users";
		ResultSet res=stmt.executeQuery(selectQuery);
		while(res.next()) {
			int uid=res.getInt("user_id");
			String name=res.getString("name");
			String email=res.getString("email");
			String phone=res.getString("phone");
			System.out.println(uid+"|"+name+"|"+email+"|"+phone);
		}
		res.close();
		String updateQ="update Users set phone='9948312642' where user_id=101";
		stmt.executeUpdate(updateQ);
		String deleteQ="delete from Users where user_id=101";
		stmt.executeUpdate(deleteQ);
	}
	catch (SQLException e) {
        System.err.println("SQL Exception occurred: " + e.getMessage());
        e.printStackTrace();
    }
}
}

