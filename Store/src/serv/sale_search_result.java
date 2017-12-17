package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.MyCommProc;
import table.information.information;
import table.money.money;
import table.salelist.salelist;
import table.salelist.salelistHandle;
import table.wage.wage;

public class sale_search_result extends HttpServlet {

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
	salelist salelist=new salelist();
	String sale_no=request.getParameter("sale_no");
	
	
	money money=new money();
	
	String receivable=request.getParameter("receivable");
	String receipts=request.getParameter("receipts");

	
	money.setSale_no(sale_no);
	money.setReceivable(receivable);
	money.setReceipts(receipts);
	
	
	
	
	information information=new information();
	
	String staff_no=request.getParameter("staff_no");
	staff_no=commhandle.getString(staff_no);
	String sale_date=request.getParameter("sale_date");
	sale_date=commhandle.getString(sale_date);
	
	information.setsale_no(sale_no);
	information.setstaff_no(staff_no);
	information.setsale_date(sale_date);
	System.out.println("@@@@@@@@");
	
	salelistHandle handle=new salelistHandle();
	

	
	List<salelist>list=handle.getsalelist(sale_no);
	System.out.println("@@@@@@@@"+list);
	
	if(list!=null){
		System.out.println("!!!!!!"+list);
        HttpSession session=request.getSession();
        session.setAttribute("list", list);
		response.sendRedirect(request.getContextPath()+"/addSuccess.jsp");}
	else
		{
		String msg4="对没有查询到此条记录！";
		msg4=URLEncoder.encode(msg4,"utf-8");
		response.sendRedirect(request.getContextPath()+"/addFail.jsp");	
		}

}
}