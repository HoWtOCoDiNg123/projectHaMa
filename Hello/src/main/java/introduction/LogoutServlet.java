package introduction;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//To remove an existing coolie, you have to generate a new cookie with
		//the same name and set its maximum age to 0
		Cookie cookie = new Cookie("username", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		//After logging out, the user gets the login view
		response.sendRedirect("login");
	}
}
