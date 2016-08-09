package controller.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("UTF8");
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		// 원래는 service 객체를 따로 만들어야하지만
		// 그냥 쓰겠음
		BoardService service = new BoardService();
		boolean result = service.login(uid, upw);
		
		if( result ) {
			RequestDispatcher rd = request.getRequestDispatcher("list");
			//request.setAttribute("id", uid);
			//request.setAttribute("pw", upw);
			HttpSession session = request.getSession(true);
			session.setAttribute("ID", uid);

			rd.forward(request, response);
			
		} else {
			response.sendRedirect("login.html");
		}
	}

}
