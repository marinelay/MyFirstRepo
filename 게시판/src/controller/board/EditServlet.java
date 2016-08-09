package controller.board;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BoardEntity;
import service.BoardService;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		
		String num = request.getParameter("num");
		
		BoardService service = new BoardService();
		BoardEntity entity = new BoardEntity();
		entity.setArticleNum(Integer.parseInt(num));
		
		BoardEntity article = service.searchArticleByNum(entity);
		
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		request.setAttribute("Article", article);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardEntity entity = new BoardEntity();
		entity.setArticleTitle(title);
		entity.setArticleContent(content);
		entity.setArticleNum(num);
		
		BoardService service = new BoardService();
		boolean result = service.editArticle(entity);
		
		if(result) {
			response.sendRedirect("success.html");
		} else {
			response.sendRedirect("fail.html");
		}
		
		//response.sendRedirect("list");
	}

}
