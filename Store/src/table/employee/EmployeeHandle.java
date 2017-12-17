package table.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;
import table.employee.Employee;

public class EmployeeHandle {
	Connection conn;  //与数据库建立连接
	Statement stmt;  //将SQl语句发送到数据库
	ResultSet rs;   //保存符合SQL语句条件的所有数据行
	
	public String searchMaxStaff_no(){
		String staff_no=null;
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select * from hr_employee order by staff_no desc";
			rs=stmt.executeQuery(str);
			
			if(rs.next())
			{
				staff_no=rs.getString("staff_no");
				
			}
		}
		catch(Exception e){
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
		return staff_no;
	}
	
	public boolean save(Employee employee){
		boolean bln=false;
		
		String staff_no = employee.getStaff_no();
		String staff_name = employee.getStaff_name();
		String sex= employee.getSex();
		String age= employee.getAge();
		String job= employee.getJob();
		String staff_ps= employee.getStaff_ps();
		
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="insert into hr_employee values('"+staff_no+"','"+staff_name+"','"+sex+"','"+age+"','"+job+"','"+staff_ps+"')";
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
	
	public Employee searchByStaff_no(Employee employee){
		Employee rstEmployee = null;
		
		String staff_no=employee.getStaff_no();
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select * from hr_employee where staff_no='"+staff_no+"'";
			rs=stmt.executeQuery(str);
			
			while(rs.next()){
				rstEmployee=new Employee();
				
				rstEmployee.setStaff_no(staff_no);
				rstEmployee.setStaff_name(rs.getString("staff_name"));
				rstEmployee.setSex(rs.getString("sex"));
				rstEmployee.setAge(rs.getString("age"));
				rstEmployee.setJob(rs.getString("job"));
				rstEmployee.setStaff_ps(rs.getString("staff_ps"));
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
		return rstEmployee;
	}
	
	public boolean update(Employee employee){
		boolean bln=false;
		
		String staff_no = employee.getStaff_no();
		String staff_name = employee.getStaff_name();
		String sex= employee.getSex();
		String age= employee.getAge();
		String job= employee.getJob();
		String staff_ps= employee.getStaff_ps();
		
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="update hr_employee set staff_name='"+staff_name+"',sex='"+sex+"',age='"+age+"',job='"+job+"',staff_ps='"+staff_ps+"' where staff_no='"+staff_no+"'";
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
