package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.MyCommProc;
import table.io.io;
import table.remarks.remarks;
import table.remarks.remarksHandle;
import table.io.ioHandle;
import table.iteminfo.Iteminfo;
import table.iteminfo.IteminfoHandle;

public class iteminfoAdd extends HttpServlet {

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
		Iteminfo itemInfo=new Iteminfo();
		io io=new io();
		remarks remarks=new remarks();
		
		String item_no=request.getParameter("item_no");
		String item_name=request.getParameter("item_name");
		item_name=commhandle.getString(item_name);
		String goods_type=request.getParameter("goods_type");
		goods_type=commhandle.getString(goods_type);
		String sale_price=request.getParameter("sale_price");
		String buying_price=request.getParameter("buying_price");
//		String remark=request.getParameter("remark");
//		remark=commhandle.getString(remark);
		String supplier=request.getParameter("supplier");
		supplier=commhandle.getString(supplier);		
		String io_num=request.getParameter("io_num");		
		String io_date=request.getParameter("io_date");	
		String pro_date=request.getParameter("pro_date");
		String best_before=request.getParameter("best_before");
		
		
		itemInfo.setItem_no(item_no);
		itemInfo.setItem_name(item_name);
		itemInfo.setGoods_type(goods_type);
		itemInfo.setSale_price(sale_price);
		itemInfo.setBuying_price(buying_price);
//		remarks.setremark(remark);
		io.setItem_no(item_no);
		io.setSupplier(supplier);
		io.setIo_num(io_num);	
		io.setIo_date(io_date);
		io.setPro_date(pro_date);		
		io.setBest_before(best_before);
		
		IteminfoHandle handle=new IteminfoHandle();
		ioHandle handle1=new ioHandle();
		remarksHandle handle2=new remarksHandle();
		if(handle.save(itemInfo)&&handle1.save(io)&&handle2.save1(item_no))
			response.sendRedirect(request.getContextPath()+"/addSuccess.jsp");
		else
			response.sendRedirect(request.getContextPath()+"/addFail.jsp");
		
	}

}
