package table.information;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;
import table.money.money;

public class informationHandle {
Connection conn;
Statement stmt;
ResultSet rs;

public String searchMaxsale_no(){
	String sale_no=null;
	try{
		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		String str="select * from sale_information order by sale_no desc";
		rs=stmt.executeQuery(str);
		if (rs.next()){
			sale_no=rs.getString("sale_no");
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
	return sale_no;
	}	

public boolean save(information information){
	boolean bin=false;
	
	String sale_no=information.getsale_no();
	String staff_no=information.getstaff_no();
	String sale_date=information.getsale_date();
	
	
	try{
		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		String str ="insert into sale_information values(";
		str+="'"+sale_no+"','"+staff_no+"','"+sale_date+"')";
		stmt.executeUpdate(str);
		bin=true;
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
	return bin;
}

public information searchBysale_no(information information)
{
information rstinformation=null;

String sale_no=information.getsale_no();
try{
	conn=Databaseconnection.getConnection();
	stmt=conn.createStatement();
	String str="select * from sale_information where sale_no='"+sale_no+"'";
	rs=stmt.executeQuery(str);
	
	while(rs.next())
	{
		rstinformation=new information();
		
		rstinformation.setsale_no(rs.getString("sale_no"));
		rstinformation.setstaff_no(rs.getString("staff_no"));
		rstinformation.setsale_date(rs.getString("sale_date"));
	
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

public boolean update(information information){
	boolean bln=false;
	
	String sale_no=information.getsale_no();
	String staff_no=information.getstaff_no();
	String sale_date=information.getsale_date();
	
	try{
		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		String str="update sale_information set staff_no='"+staff_no+"',sale_date='"+sale_date+"' where sale_no='"+sale_no+"'";
		stmt.executeUpdate(str);
		bln=true;
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
		return bln;
	}

}