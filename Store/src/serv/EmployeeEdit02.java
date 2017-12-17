package serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.MyCommProc;
import table.employee.Employee;
import table.employee.EmployeeHandle;

public class EmployeeEdit02 extends HttpServlet {

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
		Employee employee=new Employee();
		
		String staff_no=request.getParameter("staff_no");
		String staff_name=request.getParameter("staff_name");
		staff_name=commhandle.getString(staff_name);
		String sex=request.getParameter("sex");
		sex=commhandle.getString(sex);
		String age=request.getParameter("age");
		String job=request.getParameter("job");
		String staff_ps=request.getParameter("staff_ps");
		staff_ps=commhandle.getString(staff_ps);
		
		
		employee.setStaff_no(staff_no);
		employee.setStaff_name(staff_name);
		employee.setSex(sex);
		employee.setAge(age);
		employee.setJob(job);
		employee.setStaff_ps(staff_ps);
		
		EmployeeHandle handle=new EmployeeHandle();
		
		if(handle.update(employee))
			response.sendRedirect(request.getContextPath()+"/addSuccess.jsp");
		else
			response.sendRedirect(request.getContextPath()+"/addFail.jsp");
	}

}
