package serv;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import table.admin.Admin;
import table.admin.AdminHandle;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		AdminHandle adminHandle=new AdminHandle();
		response.setHeader("content-type", "text/html;charset=UTF-8");  
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");  
		
		String Admname=request.getParameter("Admname");
		String Admpassword=request.getParameter("Admpassword");
		System.out.println(Admname);
		String b="lizechen2";
		admin.setAdmName(Admname);
		admin.setAdmPassword(Admpassword);
	
		if(adminHandle.CheckAdmin(admin))
		{
			HttpSession session=request.getSession();
			session.setAttribute("login", "ok");
			session.setMaxInactiveInterval(-1);
		
			if(Admname.equals(b)){
				request.getRequestDispatcher("admin_index2.jsp").forward(request,response);
				}else{
			
			request.getRequestDispatcher("admin_index.jsp").forward(request,response);}

		}else{
			String msg="Something is wrong with your username or password, please check again";
			msg=URLEncoder.encode(msg,"utf-8");
			request.getRequestDispatcher("index.jsp?msg="+msg).forward(request,response);
		}
		
	}
	}



