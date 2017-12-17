package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.information.information;
import table.information.informationHandle;
import table.money.money;
import table.money.moneyHandle;
import table.remarks.remarks;
import table.remarks.remarksHandle;
import comm.MyCommProc;

public class informationEdit02 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public informationEdit02() {
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
		information information=new information();
		money money=new money();
//		remarks remarks=new remarks();
//		String remark=request.getParameter("remark");
//		remark=commhandle.getString(remark);
//		remarks.setremark(remark);
		remarksHandle handle2=new remarksHandle();
		
		String sale_no=request.getParameter("sale_no");
		String staff_no=request.getParameter("staff_no");
		String sale_date=request.getParameter("sale_date");
//		String receivable=request.getParameter("receivable");
		String receipts=request.getParameter("receipts");
//		Double receivable1 = Double.valueOf(receivable);
		//Double receipts1 = Double.valueOf(receipts);
//		Double charge1=receipts1-receivable1;
//		String charge=String.valueOf(charge1);
		
		information.setsale_no(sale_no);
		information.setstaff_no(staff_no);
		information.setsale_date(sale_date);
		money.setSale_no(sale_no);
//		money.setReceivable(receivable);
		money.setReceipts(receipts);
//		money.setCharge(charge);
		
		informationHandle handle=new informationHandle();
		moneyHandle handle1=new moneyHandle();
		if(handle.update(information)&&handle1.update(money)&&handle2.save6(sale_no,receipts))
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
