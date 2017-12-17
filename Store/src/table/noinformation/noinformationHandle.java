package table.noinformation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Databaseconnection;
import table.io.io;
import table.money.money;



public class noinformationHandle {
	Connection conn;
	Statement stmt;
	ResultSet rs;

	public boolean searchBysale_no(String sale_no){
		boolean bln=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select sale_no from sale_information where sale_no='"+sale_no+"'";
			rs=stmt.executeQuery(str);
			bln=true;
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
		return bln;
		}
	
	public boolean searchByitem_no(String item_no){
		boolean bln=false;
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
			String str="select item_no from warehouse_iteminfo where item_no='"+item_no+"'";
			rs=stmt.executeQuery(str);
			bln=true;
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
		return bln;
		}

	

	public Integer[] save(noinformation noinformation){
		Integer bin[]={0,0,1};
		boolean bln=false;
		//b[0]=0且b[1]!=0时，说明卖出的数量超过了原库存，b[1]的值为原库存量
		//b[0]=0且b[1]=0时，说明卖出的数量等于原库存量
		//b[0]！=0且b[1]=0时，说明卖出的数量小于原库存量，b[0]的值为现库存量
	
		
		String sale_no=noinformation.getSale_no();
		String item_no=noinformation.getGoods_no();
		String number=noinformation.getNumber();
		
		Integer len=0;
		
		Integer len1=0;
		Integer len2=0;
		Integer len3=0;
		String remain_num="replace";
		
		
		try{
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();		
			
			
			String str="insert into sale_no_information values('"+sale_no+"','"+item_no+"','"+number+"')";
			stmt.executeUpdate(str);
			bln=true;
			if(bln){
				//查原库存量
				String getremain_num="select remain_num from warehouse_io  where item_no='"+item_no+"'";
				System.out.println(getremain_num);
				rs=stmt.executeQuery(getremain_num);
				while(rs.next()){
					len=rs.getInt(1);//库存量
					}
				System.out.println(len);
				
				if(len!=0){
				//如果卖出的数量没有超过了库存
				if(len >= Integer.valueOf(number)){
					//存入该商品销售信息
					String str1 ="insert into sale_no_information values(";
					str1+="'"+sale_no+"','"+item_no+"','"+number+"')";
					stmt.executeUpdate(str1);
					
					bin[0]=len-Integer.valueOf(number);
					//更新库存
					String setremain_num="UPDATE warehouse_io SET remain_num='"+bin[0]+"' where item_no='"+item_no+"'";
					System.out.println(setremain_num);
					stmt.executeUpdate(setremain_num);
					
					//查询原应收款
					String getmoney1="select receivable from sale_money where sale_no='"+sale_no+"'";
					System.out.println(getmoney1);
					rs=stmt.executeQuery(getmoney1);
					while(rs.next()){
						len1=rs.getInt(1);
						}
					
					//加上新收款
					String getmoney="select sale_price from warehouse_iteminfo where item_no='"+item_no+"'";
					System.out.println(getmoney);
					rs=stmt.executeQuery(getmoney);
					while(rs.next()){
						len2=len1+rs.getInt(1)*Integer.valueOf(number);
						}
					
					//更新应收款
					String setreceivable="UPDATE sale_money SET receivable='"+len2+"' where sale_no='"+sale_no+"'";
					System.out.println(setreceivable);
					stmt.executeUpdate(setreceivable);
					
					
				}else{
					bin[1]=len; //bin[1]为原库存量
				}}else{bin[2]=0;}
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
		return bin;
	}

	public noinformation searchBysale_no(noinformation noinformation)
	{
		noinformation rstinformation=null;

	String sale_no=noinformation.getSale_no();
	String item_no=noinformation.getGoods_no();
	
	try{
		conn=Databaseconnection.getConnection();
		stmt=conn.createStatement();
		String str="select * from sale_no_information where sale_no='"+sale_no+"'AND item_no='"+item_no+"'";
		rs=stmt.executeQuery(str);
		
		while(rs.next())
		{
			rstinformation=new noinformation();
			
			rstinformation.setSale_no(sale_no);
			rstinformation.setGoods_no(rs.getString("item_no"));
			rstinformation.setNumber(rs.getString("number"));
					
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

	public boolean update(noinformation noinformation){
		boolean bln=false;
		
		String sale_no=noinformation.getSale_no();
		String item_no=noinformation.getGoods_no();
		String number=noinformation.getNumber();	
		Integer len=0;
		Integer len1=0;
		Integer len2=0;
		Integer len3=0;
		Integer len4=0;

		try
		{
			
			conn=Databaseconnection.getConnection();
			stmt=conn.createStatement();
		
			//查询原出售数量
			String num1="select number from sale_no_information where sale_no='"+sale_no+"' and item_no='"+item_no+"'";
			rs=stmt.executeQuery(num1);
			while(rs.next()){
				len1=rs.getInt(1);
				}
			
			//库存加上原出售数目
			String getremain_num="select remain_num from warehouse_io  where item_no='"+item_no+"'";
			System.out.println(getremain_num);
			rs=stmt.executeQuery(getremain_num);
			while(rs.next()){
				len=rs.getInt(1)+len1-Integer.valueOf(number);
				}
			
			String setremain_num="UPDATE warehouse_io SET remain_num='"+len+"' where item_no='"+item_no+"'";
			System.out.println(setremain_num);
			stmt.executeUpdate(setremain_num);
			
			//查询原该商品应收钱
			String getmoney="select sale_price from warehouse_iteminfo where item_no='"+item_no+"'";
			System.out.println(getmoney);
			rs=stmt.executeQuery(getmoney);
			while(rs.next()){
				len2=rs.getInt(1)*Integer.valueOf(len1);
				}
			
			//减去这些钱
			String getmoney1="select receivable from sale_money where sale_no='"+sale_no+"'";
			System.out.println(getmoney1);
			rs=stmt.executeQuery(getmoney1);
			while(rs.next()){
				len3=rs.getInt(1)-len2;
				}
			
			String setreceivable="UPDATE sale_money SET receivable='"+len3+"' where sale_no='"+sale_no+"'";
			System.out.println(setreceivable);
			stmt.executeUpdate(setreceivable);
			
			
			//查询原应收款
			String getmoney2="select receivable from sale_money where sale_no='"+sale_no+"'";
			System.out.println(getmoney2);
			rs=stmt.executeQuery(getmoney2);
			while(rs.next()){
				len1=rs.getInt(1);
				}
			
			//加上新收款
			String getmoney3="select sale_price from warehouse_iteminfo where item_no='"+item_no+"'";
			System.out.println(getmoney3);
			rs=stmt.executeQuery(getmoney3);
			while(rs.next()){
				len2=len1+rs.getInt(1)*Integer.valueOf(number);
				}
			
			String setreceivable1="UPDATE sale_money SET receivable='"+len2+"' where sale_no='"+sale_no+"'";
			System.out.println(setreceivable1);
			stmt.executeUpdate(setreceivable1);
			
			
			String str="update sale_no_information set number='"+number+"' where sale_no='"+sale_no+"' and item_no='"
			+item_no+"'";
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
