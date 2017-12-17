package table.iteminfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;

public class IteminfoHandle {
	Connection conn;  //与数据库建立连接
	Statement stmt;  //将SQl语句发送到数据库
	ResultSet rs;   //保存符合SQL语句条件的所有数据行
	
	public String searchMaxItem_no(){
		String item_no=null;
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select * from warehouse_iteminfo order by item_no desc";
			rs=stmt.executeQuery(str);
			
			if(rs.next())
			{
				item_no=rs.getString("item_no");
				
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
		return item_no;
	}
	
	public boolean save(Iteminfo iteminfo){
		boolean bln=false;
		
		String item_no = iteminfo.getItem_no();
		String item_name = iteminfo.getItem_name();
		String goods_type= iteminfo.getGoods_type();
		String sale_price= iteminfo.getSale_price();
		String buying_price= iteminfo.getBuying_price();
		String item_ps= iteminfo.getItem_ps();
		
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="insert into warehouse_iteminfo values(";
			str+="'"+item_no+"','"+item_name+"','"+goods_type+"','"+sale_price+"','"+buying_price+"','"+item_ps+"')";
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
	
	
	
	public Iteminfo searchByItem_no(Iteminfo itemInfo){
		Iteminfo rstIteminfo = null;
		
		String item_no=itemInfo.getItem_no();
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select * from warehouse_iteminfo where item_no='"+item_no+"'";
			rs=stmt.executeQuery(str);
			
			while(rs.next()){
				rstIteminfo=new Iteminfo();
				
				rstIteminfo.setItem_no(item_no);
				rstIteminfo.setItem_name(rs.getString("item_name"));
				rstIteminfo.setGoods_type(rs.getString("goods_type"));
				rstIteminfo.setSale_price(rs.getString("sale_price"));
				rstIteminfo.setBuying_price(rs.getString("buying_price"));
				rstIteminfo.setItem_ps(rs.getString("item_ps"));
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
		return rstIteminfo;
	}
	
	public boolean update(Iteminfo iteminfo){
		boolean bln=false;
		
		String item_no = iteminfo.getItem_no();
		String item_name = iteminfo.getItem_name();
		String goods_type= iteminfo.getGoods_type();
		String sale_price= iteminfo.getSale_price();
		String buying_price= iteminfo.getBuying_price();
		String item_ps= iteminfo.getItem_ps();
		
		try
		{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="update warehouse_iteminfo set item_name='"+item_name+"',goods_type='"+goods_type+"',sale_price='"+sale_price+"',buying_price='"+buying_price+"',item_ps='"+item_ps+"' where item_no='"+item_no+"'";
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




















