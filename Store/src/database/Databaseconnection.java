package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Databaseconnection {
	public static Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url="jdbc:mysql://localhost:3306/store?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
			conn=DriverManager.getConnection(url,"root","1");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		return conn;
	}
}
