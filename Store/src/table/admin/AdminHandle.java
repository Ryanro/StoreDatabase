package table.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;

public class AdminHandle {
	
	Connection conn;  //与数据库建立连接
	Statement stmt;  //将SQl语句发送到数据库
	ResultSet rs;   //保存符合SQL语句条件的所有数据行
	
	public boolean CheckAdmin(Admin admin){
	
		boolean blnResult = false;
		
		String Admname = admin.getAdmName();
		String Admpassword = admin.getAdmPassword();
		
		try {
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select * from admin where Admname='"+Admname+"'and Admpassword='"+Admpassword+"'";
			rs=stmt.executeQuery(str);
			
			while(rs.next()){
				blnResult=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				stmt.close();
				conn.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return blnResult;
	}
	
}
