package atj;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	String parameter1;
	String operation;
	String result;
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		parameter1 = request.getParameter("value1");
		operation = request.getParameter("oper");
		result = calc();
		//PrintWriter printWriter = response.getWriter();
		//printWriter.println(result);
		request.setAttribute("result", result);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("NewFile.jsp");
		requestDispatcher.forward(request, response);
	}

	private String calc() {

		Double x = null;
		switch (operation) {
		case "toF":
			x = 32 + (9*Double.valueOf(parameter1)/5);
			break;
		case "toC":
			x = 5*(Double.valueOf(parameter1) - 32)/9;
			break;
		}
		return String.valueOf(x);

	}

}
