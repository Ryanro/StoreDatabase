package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.MyCommProc;
import table.noinformation.noinformation;
import table.noinformation.noinformationHandle;
import table.remarks.remarks;
import table.remarks.remarksHandle;

public class noinformationEdit02 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public noinformationEdit02() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MyCommProc commhandle=new MyCommProc();
		noinformation noinformation=new noinformation();
		
		String sale_no=request.getParameter("sale_no");
		String item_no=request.getParameter("item_no");
		String number=request.getParameter("number");
//		remarks remarks=new remarks();
//		String remark=request.getParameter("remark");
//		remark=commhandle.getString(remark);
//		remarks.setremark(remark);
		remarksHandle handle2=new remarksHandle();
		
		noinformation.setSale_no(sale_no);
		noinformation.setGoods_no(item_no);
		noinformation.setNumber(number);
		

		noinformationHandle handle=new noinformationHandle();
		
		if(handle.update(noinformation)&&handle2.save9(sale_no,item_no,number))
			response.sendRedirect(request.getContextPath()+"/addSuccess.jsp");
		else
			response.sendRedirect(request.getContextPath()+"/addFail.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
