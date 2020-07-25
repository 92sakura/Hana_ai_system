package controllers.shohin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShohinNewServlet 商品マスタの新規登録画面
 */
@WebServlet("/shohin/new")
public class ShohinNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShohinNewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*
* new の　jsp を呼ぶ
*/

		request.setAttribute("_token",request.getSession().getId());
//jspから帰ってきた値のflgをそのままセットしている
        request.setAttribute("flg",request.getParameter("flg"));
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/new.jsp");
        rd.forward(request, response);
	}

}
