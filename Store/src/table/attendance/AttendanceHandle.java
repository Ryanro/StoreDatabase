package table.attendance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;
import table.attendance.Attendance;


public class AttendanceHandle {
	Connection conn;  //与数据库建立连接
	Statement stmt;  //将SQl语句发送到数据库
	ResultSet rs;   //保存符合SQL语句条件的所有数据行
	
	public boolean save(Attendance attendance){
		boolean bln=false;
		
		String staff_no = attendance.getstaff_no();
		String absence_date = attendance.getabsence_date();
		String absence_reason= attendance.getabsence_reason();
				
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="insert into hr_attendance values('"+staff_no+"','"+absence_date+"','"+absence_reason+"')";
			stmt.executeUpdate(str);
			bln=true;
		}catch(Exception e){
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
		return bln;
	}
	
	
	
	public Attendance searchByStaff_no_date(Attendance attendance){
		Attendance rstattendance = null;
		
		String staff_no=attendance.getstaff_no();
		String absence_date=attendance.getabsence_date();
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select * from hr_attendance where staff_no='"+staff_no+"' AND absence_date='"+absence_date+"'";
			rs=stmt.executeQuery(str);
			
			while(rs.next()){
				rstattendance=new Attendance();			
				rstattendance.setstaff_no(staff_no);
				rstattendance.setabsence_date(rs.getString("absence_date"));
				rstattendance.setabsence_reason(rs.getString("absence_reason"));
		
			}
		}catch(Exception e){
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
		return rstattendance;
	}
	
	
	
	public boolean update(Attendance attendance){
		boolean bln=false;
		
		String staff_no = attendance.getstaff_no();
		String absence_date = attendance.getabsence_date();
		String absence_reason= attendance.getabsence_reason();


		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();

			String str="update hr_attendance set absence_date='"+absence_date+"',absence_reason='"+absence_reason+"' where staff_no='"+staff_no+"'";
			stmt.executeUpdate(str);
			bln=true;
		}catch(Exception e){
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
		return bln;
		}
	
	
	public boolean delete(Attendance attendance){
		boolean bln=false;
		
		String staff_no = attendance.getstaff_no();
		String absence_date = attendance.getabsence_date();

		
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="delete from hr_attendance where staff_no='"+staff_no+"' AND absence_date='"+absence_date+"'";
			stmt.executeUpdate(str);
			bln=true;
		}catch(Exception e){
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
		return bln;
		}
	
}
