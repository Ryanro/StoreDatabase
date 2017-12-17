package table.job;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import comm.MyCommProc;
import database.Databaseconnection;



public class HR_jobHandle {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public boolean save(hr_job HR_JOB){
		boolean bln=false;
		String job=HR_JOB.getjob();
		String partment=HR_JOB.getpartment();
		String basic_wage=HR_JOB.getbasic_wage();
    try{
    	conn=Databaseconnection.getConnection();
    	stmt=conn.createStatement();
    	String str="insert into hr_job values('"+job+"','"+partment+"','"+basic_wage+"')";
    	stmt.executeUpdate(str);
    	bln=true;}
    catch(Exception e){e.printStackTrace();}
    finally{try{
    	stmt.close();
    	conn.close();} 
            catch(SQLException e){
            	e.printStackTrace();}
            }
            
    	return bln;}
	
	public hr_job searchByjob(hr_job HR_job)
	{
		hr_job rsthr_job=null;
		
		String job=HR_job.getjob();
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select * from hr_job where job='"+job+"'";
			rs=stmt.executeQuery(str);
			
			while(rs.next()){
				rsthr_job=new hr_job();
				
				rsthr_job.setjob(job);
				rsthr_job.setpartment(rs.getString("partment"));
				rsthr_job.setbasic_wage(rs.getString("basic_wage"));
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				conn.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return rsthr_job;
	}
	
    public boolean update(hr_job HR_job){
    	boolean bln=false;
    	String job=HR_job.getjob();
		String partment=HR_job.getpartment();
		String basic_wage=HR_job.getbasic_wage();
    
		try{
    	
		conn=Databaseconnection.getConnection();
    	stmt=conn.createStatement();
    	String str="update hr_job set partment='"+partment+"',basic_wage='"+basic_wage+"' where job='"+job+"'";
    	stmt.executeUpdate(str);
    	bln=true;}
    catch(Exception e){e.printStackTrace();}
    finally{try{
    	stmt.close();
    	conn.close();} 
            catch(SQLException e){
            	e.printStackTrace();}
            }
            
    	return bln;}
    	

    }

    
