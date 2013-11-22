package market;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class Verify extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException,IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		  HttpSession session = req.getSession();
		 PrintWriter out = resp.getWriter();
		 UserController uc = new UserController();
		 int type = uc.ChenkUserType(username);
		 String status = uc.ChenkUserStatus(username);
		 String pw = uc.Chenkpassword(username);
		try{
			if(status.equals("TRUE")){
				out.println("<html><body><center><h1>User no longer exists</h1>");
				 out.println("<a href='login.jsp'>LoginIn</a></center></body></html>");
			}else if (type == 1 && password.equals(pw)){
			  
			    session.setAttribute("userlevel", "1");
			    session.setAttribute("username", username);
			  resp.sendRedirect("home.jsp");
			  
		  }else if (type == 2 && password.equals(pw)){
			  session.setAttribute("username", username);
			  session.setAttribute("userlevel", "2");
			  
			  resp.sendRedirect("home.jsp");
		  }else if (type == 0 && password.equals(pw)){
			session.setAttribute("username", username);
			session.setAttribute("userlevel", "0");
			resp.sendRedirect("home.jsp");
			  
		  }else if(type == 0 || type == 1 || type == 2 || password == null){
			  out.println("<html><body><center><h1>Wrong Password or Username</h1>");
				 out.println("<a href='login.jsp'>Please Login Again</a></center></body></html>");
			  
			  
		  }
		  
		  
		  else {
			
			out.println("<html><body><center><h1>Please register before login</h1>");
			 out.println("<a href='register.jsp'>Register</a></center></body></html>");
			  //resp.sendRedirect("register.jsp");
			
		  }
		  } catch(Exception e){}	
	}
	public void doPost(HttpServletRequest req,HttpServletResponse resp)
	         throws ServletException,java.io.IOException{
		this.doGet(req, resp);
	}
	
	
	
	}
