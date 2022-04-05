package introduction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class HelloServlet
 */

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = request.getParameter("input");
		Calculator calculator = new Calculator(input);
		String squareResult = calculator.getSquare();
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
		out.println("<html>\n"
				+ "    <head><title>Hello Servlet!</title></head>\n"
				+ "    <body>\n"
				+ "        <h1>Hello Servlet</h1>\n <br>"
				+ "<h3> Your input paramter was " + input + "</h3><br>"
				+ "<p>The result = " + squareResult + "</p>"
				+ "    </body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
