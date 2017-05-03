package Source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginForm
 */
@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int count =0;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginForm() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		if(user.equals("UIT")&&pass.equals("123"))
		{
			count++;
			Cookie userCK = new Cookie("user", user);
		    Cookie passCK = new Cookie("pass", pass);
		    userCK.setMaxAge(60 * 60 * 24);
	        passCK.setMaxAge(60 * 60 * 24);
	        
	        response.addCookie(userCK);
	        response.addCookie(passCK);
	        
			int length = request.getCookies().length;
			
			if(length==1)
			{
				RequestDispatcher rd= request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
			}
			else
			{
				if(count!=5)out.println("Chào mừng trở lại");
				else out.print("Chúc mừng bạn đã nhận được voucher");
			}
		}
		else
		{
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		out.close();
		
		
	}

}
