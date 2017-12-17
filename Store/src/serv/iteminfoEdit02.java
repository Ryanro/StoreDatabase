package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.MyCommProc;
import table.iteminfo.Iteminfo;
import table.iteminfo.IteminfoHandle;
import table.remarks.remarks;
import table.remarks.remarksHandle;

public class iteminfoEdit02 extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MyCommProc commhandle=new MyCommProc();
		
		
		
//		remarks remarks=new remarks();
//		String remark=request.getParameter("remark");
//		remark=commhandle.getString(remark);
//		remarks.setremark(remark);
		Iteminfo itemInfo1=new Iteminfo();
		remarksHandle handle3=new remarksHandle();
		Integer n = 0;
		String item_no=request.getParameter("item_no");
		itemInfo1.setItem_no(item_no);
		
		String item_name=request.getParameter("item_name");
		item_name=commhandle.getString(item_name);
		String goods_type=request.getParameter("goods_type");
		goods_type=commhandle.getString(goods_type);
		
		String sale_price1=request.getParameter("sale_price");
		
		String buying_price1=request.getParameter("buying_price");
		
		IteminfoHandle handle2=new IteminfoHandle();
		itemInfo1=handle2.searchByItem_no(itemInfo1);
//		request.setAttribute("itemInfo1", itemInfo1);
//		Iteminfo itemInfo2=(Iteminfo)request.getAttribute("itemInfo1");
		System.out.println(itemInfo1.getSale_price());
		Float a=Float.valueOf(itemInfo1.getSale_price());
		System.out.println(sale_price1);
		Float b=Float.valueOf(sale_price1);
		System.out.println(itemInfo1.getBuying_price());
		Float a1=Float.valueOf(itemInfo1.getBuying_price());
		System.out.println(buying_price1);
		Float b1=Float.valueOf(buying_price1);
		
		
		
//		if(Double.valueOf(itemInfo1.getSale_price())!=Double.valueOf(sale_price1) & Double.valueOf(itemInfo1.getBuying_price())!=Double.valueOf(buying_price1))  {
//			
//			//更改了进货价和出售价
//			n=1;	
//			System.out.println(n);
//		}else if(Double.valueOf(itemInfo1.getSale_price())!=Double.valueOf(sale_price1) & Double.valueOf(itemInfo1.getBuying_price())==Double.valueOf(buying_price1)){
//			//更改了销售价
//			n=2;
//			System.out.println(n);
//		}else if(Double.valueOf(itemInfo1.getSale_price())==Double.valueOf(sale_price1) & Double.valueOf(itemInfo1.getBuying_price())==Double.valueOf(buying_price1)){
//			//更改了进货价
//			n=3;
//			System.out.println(n);
//		}
		
		
		Iteminfo itemInfo=new Iteminfo();
		itemInfo.setItem_no(item_no);
		itemInfo.setItem_name(item_name);
		itemInfo.setGoods_type(goods_type);
		itemInfo.setSale_price(sale_price1);
		itemInfo.setBuying_price(buying_price1);
		
		
		IteminfoHandle handle=new IteminfoHandle();
		
		if(handle3.judge(a, b, a1, b1)==1){
			
			if(handle.update(itemInfo)&&handle3.save2(item_no,sale_price1,buying_price1))
				response.sendRedirect(request.getContextPath()+"/addSuccess.jsp");
			else
				response.sendRedirect(request.getContextPath()+"/addFail.jsp");		
		}
		if(handle3.judge(a, b, a1, b1)==2){
			if(handle.update(itemInfo)&&handle3.save3(item_no,sale_price1))
				response.sendRedirect(request.getContextPath()+"/addSuccess.jsp");
			else
				response.sendRedirect(request.getContextPath()+"/addFail.jsp");
		}
		if(handle3.judge(a, b, a1, b1)==3){
			if(handle.update(itemInfo)&&handle3.save4(item_no,buying_price1))
				response.sendRedirect(request.getContextPath()+"/addSuccess.jsp");
			else
				response.sendRedirect(request.getContextPath()+"/addFail.jsp");
		}
		}
		
		
		

}
