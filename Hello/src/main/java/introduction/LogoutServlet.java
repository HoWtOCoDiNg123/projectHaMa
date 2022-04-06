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
		Cookie cookie = new Cookie("username", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		response.sendRedirect("login");
	}
}
