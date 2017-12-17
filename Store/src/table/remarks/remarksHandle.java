package table.remarks;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;
import table.remarks.remarks;

public class remarksHandle {
	
	Connection conn;  //与数据库建立连接
	Statement stmt;  //将SQl语句发送到数据库
	ResultSet rs;//保存符合SQL语句条件的所有数据行
	
	public String listallremarks()
	{
		String resultstr="";
		
		resultstr="<table  border=1 width=600 align=center><tr><th>操作记录</th></tr>";
		
		String sqlstr="select * from remarks ";
		try {

			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sqlstr);
				
			while(rs.next()){
				resultstr+="<tr  ><td ><input type='text' id='remark' value='"+rs.getString(1)+"' size=83 readonly ></td>"
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
	
	public boolean save1(String item_no){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('新增加了编号为"+item_no+"的商品')";
			
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
	
	public boolean save2(String item_no,String sale_price, String buying_price){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('同时更改了了编号为"+item_no+"的商品的销售价为"+sale_price+"和进货价为"+buying_price+"')";
			
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
	
	public boolean save3(String item_no,String sale_price){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('更改了了编号为"+item_no+"的商品的销售价为"+sale_price+"')";
			
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
	
	public boolean save4(String item_no,String buying_price){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('更改了了编号为"+item_no+"的商品的进货价为"+buying_price+"')";
			
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
	
	public Integer judge(Float a,Float a1,Float b,Float b1){
		Integer bln=0;		
		if(!a.equals(a1) & !b.equals(b1)) {
			bln=1;
		}else if(!a.equals(a1) & b.equals(b1)){
			bln=2;
		}else if(a.equals(a1) & !b.equals(b1)){
			bln=3;
		}
		
		return bln;
	}
	
	public boolean save5(String sale_no,String staff_no){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('添加了了由员工"+staff_no+"操作的单号"+sale_no+"')";
			
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
	
	public boolean save6(String sale_no,String receipts){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('修改了单号"+sale_no+"的实收金额为"+receipts+"')";
			
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
	
	public boolean save7(String sale_no,String item_no,String number){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('单号为"+sale_no+"的商品"+item_no+"出售成功"+number+"个')";
			
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
	
	public boolean save8(String sale_no,String item_no){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('库存不足导致单号"+sale_no+"的商品"+item_no+"出售失败')";
			
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
	
	public boolean save9(String sale_no,String item_no,String number){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('更改单号"+sale_no+"销售的商品"+item_no+"数量为"+number+"')";
			
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
	
	public boolean save10(String item_no,String supplier,String io_num,String io_date,String pro_date,String best_before){
		boolean bin=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			
			String str ="insert into remarks values('供货商"+supplier+"于"+io_date+"进货商品"+item_no+"共"+io_num+"个，生产日期为"+pro_date+"，过期日期为"+best_before+"')";
			
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
}
