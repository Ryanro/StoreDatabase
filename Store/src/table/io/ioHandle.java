package table.io;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;

//import DatabaseConnection;

public class ioHandle {
	Connection conn;  //与数据库建立连接
	Statement stmt;  //将SQl语句发送到数据库
	ResultSet rs;//保存符合SQL语句条件的所有数据行

public String searchMaxOnNo()
{
	String item_no=null;
	try{
		conn=Databaseconnection.getConnection();
	    stmt=conn.createStatement();
	    String str="select * from warehouse_io order by item_no desc";
	    rs=stmt.executeQuery(str);
    	if(rs.next())
     	{item_no=rs.getString("item_no");}
	}
	catch(Exception e){e.printStackTrace();}
	finally{try{
		stmt.close();
     	conn.close();
	}
	catch(SQLException e){e.printStackTrace();}
	}	
	return item_no;
}
	
public boolean save(io io){
	boolean bin=false;
	
	String item_no=io.getItem_no();
	String supplier=io.getSupplier();	
	String io_num=io.getIo_num();
	String io_date=io.getIo_date();
	String pro_date=io.getPro_date();
	String remain_num=io.getRemain_num();
	String best_before=io.getBest_before();
	
	
	try{
		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		
		//查询原库存量

		
		
//		String getremain_num="select sum(number) from sale_no_information where item_no='"+item_no+"'";
//		stmt.executeUpdate(getremain_num);
//		while(rs.next()){
//			Integer len=rs.getInt(1);
//			remain_num=String.valueOf(Integer.valueOf(remain_num)-len+Integer.valueOf(io_num));}
		
		String str ="insert into warehouse_io values(";
		str+="'"+item_no+"','"+supplier+"','"+io_num+"','"+io_date+"','"+pro_date+"','"+best_before+"','"+io_num+"')";
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

public io searchByitem_no(io io)
{
io rstinformation=null;

String item_no=io.getItem_no();
try{
	conn=Databaseconnection.getConnection();
	stmt=conn.createStatement();
	
//	//查询该商品进货量,得出现在库存量
//	String remain_num="0";
//	String getio_num="select io_num from warehouse_io where item_no='"+item_no+"'";
//	rs=stmt.executeQuery(getio_num);
//	while(rs.next()){
//		Integer len2=rs.getInt(1);
//		remain_num=String.valueOf(Integer.valueOf(remain_num1)+len2-Integer.valueOf(num));}
//	
//	//更新库存量
//	String setremain_num="update warehouse_io set remain_num='"+remain_num+"' where item_no='"+item_no+"'";
//	stmt.executeUpdate(setremain_num);
	
	String str="select * from warehouse_io where item_no='"+item_no+"'";
	rs=stmt.executeQuery(str);
	
	while(rs.next())
	{
		rstinformation=new io();
			
		rstinformation.setItem_no(rs.getString("item_no"));
		rstinformation.setSupplier(rs.getString("supplier"));
		rstinformation.setIo_num(rs.getString("io_num"));
		rstinformation.setIo_date(rs.getString("io_date"));
		rstinformation.setPro_date(rs.getString("pro_date"));
		rstinformation.setBest_before(rs.getString("best_before"));
		rstinformation.setRemain_num(rs.getString("remain_num"));	
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


public boolean update(io io){
	boolean bln=false;
	
	String item_no=io.getItem_no();
	String supplier=io.getSupplier();	
	String io_num=io.getIo_num();
	String io_date=io.getIo_date();
	String pro_date=io.getPro_date();	
	String best_before=io.getBest_before();
	
	
	try
	{
		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		
		Integer len=0;
		String getremain_num="select remain_num from warehouse_io where item_no='"+item_no+"'";
		System.out.println(getremain_num);
		
		String remain_num="";
		rs=stmt.executeQuery(getremain_num);
		while(rs.next()){
			System.out.println(len);
			len=rs.getInt(1)+Integer.valueOf(io_num);
			System.out.println(len);
			}
		remain_num=String.valueOf(len);
		System.out.println(remain_num);
		String str="update warehouse_io set supplier='"+supplier+"',io_num='"+io_num+"',io_date='"+io_date+
		"',pro_date='"+pro_date+"',best_before='"+best_before+"',remain_num='"+remain_num+"' where item_no='"+item_no+"'";
		System.out.println(str);
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

public String listallio()
{
	String resultstr="";
	
	resultstr="<table ><tr><th>商品编号</th><th>供货商</th><th>进货量</th><th>进货日期</th><th>生产日期</th><th>过期日期</th><th>库存量</th></tr>";
	
	String sqlstr="select * from warehouse_io";
	try {

		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sqlstr);
			
		while(rs.next()){
			resultstr+="<tr><td><input type='text' id='item_no' value='"+rs.getString(1)+"'readonly ></td>"
			               +"<td><input type='text' id='supplier' value='"+rs.getString(2)+"'readonly></td>"
			               +"<td><input type='text' id='io_num' value='"+rs.getInt(3)+"'readonly></td>"
			               +"<td><input type='text' id='io_date' value='"+rs.getString(4)+"'readonly></td>"
			               +"<td><input type='text' id='pro_date' value='"+rs.getString(5)+"'readonly></td>"
			               +"<td><input type='text' id='best_before' value='"+rs.getString(6)+"'readonly></td>"
			               +"<td><input type='text' id='remain_num' value='"+rs.getString(7)+"'readonly></td>"
			               +"</tr>";			
		}		
		resultstr+="</table>";
		rs.close();
		stmt.close();
		conn.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	return resultstr;
	
}


public String listnum(Integer a)
{
	String resultstr="";
	
	resultstr="<table align=center; width=1100;><tr><th>商品编号</th><th>供货商</th><th>进货量</th><th>进货日期</th><th>生产日期</th><th>过期日期</th><th>库存量</th></tr>";
	
	String sqlstr="select * from warehouse_io where remain_num <='"+a+"'";
	try {

		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sqlstr);
			
		while(rs.next()){
			resultstr+="<tr><td><input type='text' id='item_no' value='"+rs.getString(1)+"'readonly ></td>"
			               +"<td><input type='text' id='supplier' value='"+rs.getString(2)+"'readonly></td>"
			               +"<td><input type='text' id='io_num' value='"+rs.getInt(3)+"'readonly></td>"
			               +"<td><input type='text' id='io_date' value='"+rs.getString(4)+"'readonly></td>"
			               +"<td><input type='text' id='pro_date' value='"+rs.getString(5)+"'readonly></td>"
			               +"<td><input type='text' id='best_before' value='"+rs.getString(6)+"'readonly></td>"
			               +"<td><input type='text' id='remain_num' value='"+rs.getString(7)+"'readonly></td>"
			               +"</tr>";			
		}		
		resultstr+="</table>";
		rs.close();
		stmt.close();
		conn.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	return resultstr;
	
}
}

