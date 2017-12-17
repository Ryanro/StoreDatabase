package table.wage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;
import table.wage.wage;

public class wageHandle {
	Connection conn;  //与数据库建立连接
	Statement stmt;  //将SQl语句发送到数据库
	ResultSet rs;   //保存符合SQL语句条件的所有数据行
	
	
	public boolean save(wage wage){
		boolean bln=false;
		
		String staff_no = wage.getstaff_no();
		String wage_date= wage.getwage_date();
		
		
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String absent_num="100";
			String pay_wage="10000";
			
			String getabsence_num="SELECT count(absence_date) FROM hr_attendance WHERE staff_no='"+staff_no+"'";
			rs=stmt.executeQuery(getabsence_num);
			while(rs.next()){
			Integer len=rs.getInt(1);
			absent_num=String.valueOf(len);}
		
	
			String getrealwage="select basic_wage from hr_job where job=(SELECT job FROM hr_employee WHERE staff_no='"+staff_no+"')";
			rs=stmt.executeQuery(getrealwage);
			while(rs.next()){
				Integer len1=rs.getInt(1);
			pay_wage=String.valueOf(len1-Integer.valueOf(absent_num)*70);
			}
			
			String str="insert into finance_wage(staff_no,absent_num,wage_date,pay_wage) values('"+staff_no+"','"+absent_num+"','"+wage_date+"','"+pay_wage+"')";
			stmt.executeUpdate(str);
//			String s="insert into finance_wage(absent_num) where staff_no='"+staff_no+"'"
//					+ "select sum(case when staff_no like '"+staff_no+"' then 1 else 0 end)from hr_attendance";
//			stmt.executeUpdate(s);
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
	
	public wage searchByStaff_no_date(wage wage){
		wage rstwage = null;
		
		String staff_no=wage.getstaff_no();
		String wage_date=wage.getwage_date();
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String absent_num="100";
			String pay_wage="10000";
			
			String getabsence_num="SELECT count(absence_date) FROM hr_attendance WHERE staff_no='"+staff_no+"'";
			rs=stmt.executeQuery(getabsence_num);
			while(rs.next()){
			Integer len=rs.getInt(1);
			absent_num=String.valueOf(len);}
		
	
			String getrealwage="select basic_wage from hr_job where job=(SELECT job FROM hr_employee WHERE staff_no='"+staff_no+"')";
			rs=stmt.executeQuery(getrealwage);
			while(rs.next()){
				Integer len1=rs.getInt(1);
			pay_wage=String.valueOf(len1-Integer.valueOf(absent_num)*70);
			
			
			String str1="update finance_wage set absent_num='"+absent_num+"',wage_date='"+wage_date+"',pay_wage='"+pay_wage+"' where staff_no='"+staff_no+"'";
			stmt.executeUpdate(str1);
			
			
			String str="select * from finance_wage where staff_no='"+staff_no+"' AND wage_date='"+wage_date+"'";
			rs=stmt.executeQuery(str);
			
			while(rs.next()){
				rstwage=new wage();
				
				rstwage.setstaff_no(staff_no);
				rstwage.setabsent_num(rs.getString("absent_num"));
				rstwage.setwage_date(rs.getString("wage_date"));
	
				rstwage.setpay_wage(rs.getString("pay_wage"));
		
			}
			}}catch(Exception e){
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
		return rstwage;
	}
	
	public boolean update(wage wage){
		boolean bln=false;
		
		String staff_no = wage.getstaff_no();
		String absent_num = wage.getabsent_num();
		String wage_date= wage.getwage_date();
		String pay_wage= wage.getpay_wage();

		
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="update finance_wage set absent_num='"+absent_num+"',wage_date='"+wage_date+"',pay_wage='"+pay_wage+"' where staff_no='"+staff_no+"'";
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
}}
