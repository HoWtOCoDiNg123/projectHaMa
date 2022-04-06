package introduction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.DAO;
import entity.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedUser = null;
		Cookie[] cookies = request.getCookies();
		try {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					for(int i = 0; i < DAO.users.size(); i++) {
						if(DAO.users.get(i).getUsername().equals(cookie.getValue())) {
							loggedUser = DAO.users.get(i);
						}
					}
				}
			}
		}
		catch(Exception exception) {
			PrintWriter out = response.getWriter();
			out.println("<html>\n"
					+ "    <head><title>Login</title></head>\n"
					+ "    <body>\n"
					+ "        <h1>Cookie request failed!</h1>\n"
					+ "    </body></html>");
		}

		
		if(loggedUser == null) {
			//request.setAttribute("user", loggedUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} 
		else {
			if(loggedUser != null) {
				
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User tempUser = new User(username, password);
		User loggedUser = null;
		List<User> users = DAO.users;
		boolean isValidUser = false;
		for(User user : users) {
			if(user.equals(tempUser)) {
				isValidUser = true;
				loggedUser = user;
			}
		}
		
		if(isValidUser) {
			session.setAttribute("logged_user", loggedUser);			
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(20);
			response.addCookie(cookie);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("login");
		}
	}

}
