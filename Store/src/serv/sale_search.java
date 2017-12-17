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
import table.information.informationHandle;
import table.money.money;
import table.money.moneyHandle;
import table.salelist.salelist;
import table.salelist.salelistHandle;

public class sale_search extends HttpServlet {

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
		salelist salelist=new salelist();
		
		String sale_no;
		sale_no=request.getParameter("sale_no");
		
		money money=new money();
		money.setSale_no(sale_no);
		moneyHandle mhandle =new moneyHandle();
		money=mhandle.searchBysale_no(money);
		
		
		information information=new information();
		information.setsale_no(sale_no);
		informationHandle ihandle =new informationHandle();
		information=ihandle.searchBysale_no(information);
		
		salelistHandle handle=new salelistHandle();
		List<salelist>list=handle.getsalelist(sale_no);
		System.out.println("search dopost is working"+list);

		
		if(money==null&&information==null){
			String msg="对不起，没有查询到此条记录！";
			msg=URLEncoder.encode(msg,"utf-8");
			request.getRequestDispatcher("salelistSearch.jsp?msg="+msg).forward(request, response);
		}else{
		if(list==null)
		{	
			System.out.println("99999"+list);
			String msg3="ssaaa";
			msg3=URLEncoder.encode(msg3,"utf-8");
			request.getRequestDispatcher("salelistSearchResult.jsp?msg="+msg3).forward(request, response);
		}else
		{
		
			request.setAttribute("list", list);
			System.out.println("0000000"+list);
			request.setAttribute("information",information);
			System.out.println("0000000"+information);
			request.setAttribute("money",money);
			System.out.println("0000000"+money);
			
	        HttpSession session=request.getSession();
	        session.setAttribute("list", list);
			request.getRequestDispatcher("salelistSearchResult.jsp").forward(request, response);
		}

		}
	}

}
