package controllers.shohin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Hanamast;

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
* 商品マスタの新規登録画面
*/
		request.setAttribute("_token",request.getSession().getId());
		Hanamast h = new Hanamast();
	    request.setAttribute("hanamast", h);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/new.jsp");
        rd.forward(request, response);
	}

}