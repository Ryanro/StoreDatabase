package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.io.io;
import table.io.ioHandle;
import table.remarks.remarks;
import table.remarks.remarksHandle;
import comm.MyCommProc;


public class ioEdit02 extends HttpServlet {

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
		io io=new io();
//		remarks remarks=new remarks();
//		String remark=request.getParameter("remark");
//		remark=commhandle.getString(remark);
//		remarks.setremark(remark);
		remarksHandle handle2=new remarksHandle();
		
		String item_no=request.getParameter("item_no");
		//item_no=commhandle.getString(item_no);
		String supplier=request.getParameter("supplier");
		supplier=commhandle.getString(supplier);
		
		String io_num=request.getParameter("io_num");
		//io_num=commhandle.getString(io_num);		
		
		String io_date=request.getParameter("io_date");
		//io_date=commhandle.getString(io_date);
		
		String pro_date=request.getParameter("pro_date");
		//pro_date=commhandle.getString(pro_date);
		

		//storage_life=commhandle.getString(storage_life);
	
		String best_before=request.getParameter("best_before");
		//best_before=commhandle.getString(best_before);
		
		String remain_num=request.getParameter("remain_num");
		//remain_num=commhandle.getString(remain_num);

		

		
		
		io.setItem_no(item_no);
		io.setSupplier(supplier);
		io.setIo_num(io_num);	
		io.setIo_date(io_date);
		io.setPro_date(pro_date);
		
		io.setBest_before(best_before);
		io.setRemain_num(remain_num);
		
		
		
		ioHandle handle=new ioHandle();
		
		if(handle.update(io)&&handle2.save10(item_no,supplier,io_num,io_date,pro_date,best_before))
			response.sendRedirect(request.getContextPath()+"/addSuccess.jsp");
		else
			response.sendRedirect(request.getContextPath()+"/addFail.jsp");
	}

}

