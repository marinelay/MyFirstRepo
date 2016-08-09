package controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BoardEntity;
import service.BoardService;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		
		
		BoardEntity entity = new BoardEntity();
		entity.setArticleNum(Integer.parseInt(num));
		
		// 게시물 내용 가져오기
		BoardService service = new BoardService();
		BoardEntity article = service.searchArticleByNum(entity);
		
		// 이름이 같은가?
		boolean equal = false;
		if(article.getArticleWriter().equals(id)) {
			equal = true;
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher("article.jsp");
		request.setAttribute("Article", article);
		request.setAttribute("Equal", equal);
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
