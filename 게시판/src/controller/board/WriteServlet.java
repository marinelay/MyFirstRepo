package controller.board;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BoardEntity;
import service.BoardService;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
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
		request.setCharacterEncoding("UTF8");
		
		// 1. 입력을 받음
		String title = request.getParameter("title");
		String writer = request.getParameter("id");
		String content = request.getParameter("content");
		
		// 2. 입력받은 데이터를 service 객체에 넘김
		//	  이 데이터를 개별적으로 전달하는 것이 아닌
		//    객체화 시켜서 전달
		BoardEntity entity = new BoardEntity();
		entity.setArticleTitle(title);
		entity.setArticleWriter(writer);
		entity.setArticleContent(content);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy년MM월dd일");
		entity.setArticleDate(format.format((new Date())));
		
		BoardService service = new BoardService();
		boolean result = service.registerArticle(entity);
		
		// 3. 출력처리
		// 고정된 내용으로 출력한다? html
		// 결과에 따라 다른 내용으로 출력한다? jsp
		// 성공일 경우 success.html
		// 실패일 경우 fail.html
		if (result) {
			response.sendRedirect("success.html");
		} else {
			response.sendRedirect("fail.html");
		}
	}

}
