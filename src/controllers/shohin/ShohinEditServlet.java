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
 * Servlet implementation class ShohinEditServlet
 * 商品　編集/削除　画面
 */
@WebServlet("/shohin/edit")
public class ShohinEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShohinEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // インスタンスを生成
		Hanamast hana = new Hanamast();
		// DBアクセス
		hana.GetRecord(request.getParameter("cd"));

        request.setAttribute("shohin", hana);
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("flg",request.getParameter("flg"));

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/edit.jsp");
        rd.forward(request, response);
	}

}
