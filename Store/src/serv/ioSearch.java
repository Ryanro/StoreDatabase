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

import table.information.information;
import table.information.informationHandle;
import table.io.io;
import table.io.ioHandle;
import table.iteminfo.Iteminfo;
import table.iteminfo.IteminfoHandle;
import table.money.money;
import table.money.moneyHandle;
import table.salelist.salelist;
import table.salelist.salelistHandle;

public class ioSearch extends HttpServlet {

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

		//MyCommProc commhandle=new MyCommProc();
		Iteminfo itemInfo=new Iteminfo();
		
		String item_no=request.getParameter("item_no");
		itemInfo.setItem_no(item_no);
		
		IteminfoHandle handle=new IteminfoHandle();
		itemInfo=handle.searchByItem_no(itemInfo);
		
		
		io io=new io();
		io.setItem_no(item_no);
		
		ioHandle handle1 =new ioHandle();
		io=handle1.searchByitem_no(io);
		

		if(itemInfo==null && io==null)
		{	
			String msg="对不起，没有查询到此条记录！";
			msg=URLEncoder.encode(msg,"utf-8");
			request.getRequestDispatcher("ioSearch.jsp?msg="+msg).forward(request, response);
		}else
		{
	
			request.setAttribute("itemInfo",itemInfo);
			request.setAttribute("io",io);
			request.getRequestDispatcher("ioSearchResult.jsp").forward(request, response);
		}
	}

}
