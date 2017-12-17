package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.job.HR_jobHandle;
import table.job.hr_job;


public class HR_jobEdit01 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HR_jobEdit01() {
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

			hr_job HR_job=new hr_job();
	        String job;
	        job=request.getParameter("job");
	        HR_job.setjob(job);
	        
	        HR_jobHandle handle=new HR_jobHandle();
	        HR_job=handle.searchByjob(HR_job);
	        if(HR_job==null)
	        {
	        	
	        	String msg="对不起，没有查询到此条记录！";
				msg=URLEncoder.encode(msg,"utf-8");
	        	request.getRequestDispatcher("HR_jobEdit.jsp?msg="+msg).forward(request, response);
	        	
	        }
	        else{
	        	request.setAttribute("HR_job", HR_job);
	        	request.getRequestDispatcher("HR_jobEdit02.jsp").forward(request,response);
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
