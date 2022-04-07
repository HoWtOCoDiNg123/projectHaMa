package introduction;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;


public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CalculatorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("calculator.jsp");
		dispatcher.forward(request, response);	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operand = request.getParameter("number_input");
	
		request.setAttribute("input_text", operand);	
		RequestDispatcher dispatcher = request.getRequestDispatcher("calculator.jsp");
		dispatcher.forward(request, response);
	}

}
