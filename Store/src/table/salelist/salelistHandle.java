package table.salelist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.Databaseconnection;
import table.salelist.salelist;

public class salelistHandle {
	Connection conn;  //ÓëÊý¾Ý¿â½¨Á¢Á¬½Ó
	Statement stmt;  //½«SQlÓï¾ä·¢ËÍµ½Êý¾Ý¿â
	ResultSet rs;   //±£´æ·ûºÏSQLÓï¾äÌõ¼þµÄËùÓÐÊý¾ÝÐÐ
	
	

	
	public salelist searchBystaff_no(salelist salelist){
		salelist rstsalelist = null;
		
		String sale_no=salelist.getsale_no();
		System.out.println("search working!!!!");
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select * from sale_no_information where sale_no='"+sale_no+"'";
			rs=stmt.executeQuery(str);
			
			while(rs.next()){
				rstsalelist=new salelist();
				rstsalelist.setsale_no(rs.getString("sale_no"));
				rstsalelist.setitem_no(rs.getString("item_no"));
				rstsalelist.setnumber(rs.getString("number"));
	
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
		return rstsalelist;
	}
	
	
	public List<salelist> getsalelist(String sale_no){
		
		List<salelist> list=new ArrayList<salelist>();
		String str=null;
	
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
		
			str="select * from sale_no_information where sale_no='"+sale_no+"'";
			System.out.println(str);
			rs=stmt.executeQuery(str);
		
			while(rs.next())
			{
				salelist sale=new salelist();
				sale.setsale_no(sale_no);
			
				sale.setitem_no(rs.getString("item_no"));
				sale.setnumber(rs.getString("number"));
				System.out.println(sale);
				list.add(sale);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		System.out.println(list);
		return list;
	}

}
