package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.User;

@WebServlet("/login")
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
				//request.setAttribute("user", username);
				isValidUser = true;
				loggedUser = user;
			}
		}
		
		if(isValidUser) {
			//request.setAttribute("user", username);
			session.setAttribute("logged_user", loggedUser);
			//httpSession.setMaxInactiveInterval(10 * 60);
			
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
