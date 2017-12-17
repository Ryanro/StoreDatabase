package table.money;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;


public class moneyHandle {
	Connection conn;
	Statement stmt;
	ResultSet rs;

	public boolean save(money money){
		boolean bin=false;
		
		String sale_no=money.getSale_no();
		String receivable=money.getReceivable();
		String receipts=money.getReceipts();
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str ="insert into sale_money values(";
			str+="'"+sale_no+"','"+receivable+"','"+receipts+"')";
			stmt.executeUpdate(str);
			bin=true;
		}
	    catch(Exception e){e.printStackTrace();}
	    finally{try{
	    	stmt.close();
	    	conn.close();} 
	            catch(SQLException e){
	            	e.printStackTrace();}
	            }
	            
	    	return bin;}

	public money searchBysale_no(money money)
	{
		money rstinformation=null;

	    String sale_no=money.getSale_no();
	try{
		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		String str="select *from sale_money where sale_no='"+sale_no+"'";
		rs=stmt.executeQuery(str);
		
		while(rs.next())
		{
			rstinformation=new money();
			
			rstinformation.setSale_no(rs.getString("sale_no"));
			rstinformation.setReceivable(rs.getString("receivable"));
			rstinformation.setReceipts(rs.getString("receipts"));			
			
		}
	}
	catch(Exception e){
	e.printStackTrace();	
	}finally{
		try{
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return rstinformation;
	}
	
	public boolean update(money money){
		boolean bln=false;
		
		String sale_no=money.getSale_no();
		String receivable=money.getReceivable();
		String receipts=money.getReceipts();		
		
		
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="update sale_money set receipts='"+receipts+"' where sale_no='"+sale_no+"'";
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
