package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.MyCommProc;
import table.noinformation.noinformation;
import table.noinformation.noinformationHandle;
import table.remarks.remarks;
import table.remarks.remarksHandle;


public class noinformationAdd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public noinformationAdd() {
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
//		remarks remarks=new remarks();
//		String remark=request.getParameter("remark");
//		remark=commhandle.getString(remark);
//		remarks.setremark(remark);
		remarksHandle handle2=new remarksHandle();
		
		String sale_no=request.getParameter("sale_no");
		String item_no=request.getParameter("item_no");
		String number=request.getParameter("number");
		
		noinformation.setSale_no(sale_no);
		noinformation.setGoods_no(item_no);
		noinformation.setNumber(number);
		

		noinformationHandle handle=new noinformationHandle();
		Integer[] bin=handle.save(noinformation);
		
		//b[0]=0且b[1]!=0时，说明卖出的数量超过了原库存，b[1]的值为原库存量
		//b[0]=0且b[1]=0时，说明卖出的数量等于原库存量
		//b[0]！=0且b[1]=0时，说明卖出的数量小于原库存量，b[0]的值为现库存量
		
		
		if(bin[0]==0 & bin[1]==0 &bin[2]==1){
			String msg="找不到该单号或商品！";
			msg=URLEncoder.encode(msg,"utf-8");
			request.getRequestDispatcher("addFail.jsp?msg="+msg).forward(request, response);
			
		}else{
			if(bin[2]!=0){
				if(bin[0]==0 & bin[1]!=0){
					handle2.save8(sale_no,item_no);
					String msg="库存不足，只有'"+bin[1]+"'个！";
					msg=URLEncoder.encode(msg,"utf-8");
					request.getRequestDispatcher("addFail.jsp?msg="+msg).forward(request, response);
					}
				else if(bin[0]==0 & bin[1]==0&&handle2.save7(sale_no,item_no,number)){
					String msg="出售成功！该商品已卖完下架！";
					msg=URLEncoder.encode(msg,"utf-8");
					request.getRequestDispatcher("addSuccess.jsp?msg="+msg).forward(request, response);
					}else if(bin[0]!=0 & bin[1]==0&&handle2.save7(sale_no,item_no,number)){
						String msg="出售成功！该商品还剩'"+bin[0]+"'个！";
						msg=URLEncoder.encode(msg,"utf-8");
						request.getRequestDispatcher("addSuccess.jsp?msg="+msg).forward(request, response);
					}
			}else{
					handle2.save8(sale_no,item_no);
					String msg="库存不足，只有0个！";
					msg=URLEncoder.encode(msg,"utf-8");
					request.getRequestDispatcher("addFail.jsp?msg="+msg).forward(request, response);
				}
		}
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
