package controllers.shohin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Hanamast;

/**
 * Servlet implementation class ShohinDeleteServlet
 * 商品の削除処理
 */
@WebServlet("/shohin/delete")
public class ShohinDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShohinDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * データの削除
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        ArrayList<String> errors = new ArrayList<>();

        if(_token != null && _token.equals(request.getSession().getId())) {
			// インスタンスを生成
			Hanamast hana = new Hanamast();
 			hana.SetData(request);
			// 削除処理のクラスへ
			hana.Delete();
			request.getSession().setAttribute("flush", "削除が完了しました。");
            request.getSession().setAttribute("_token", request.getSession().getId());
            response.sendRedirect("/Hana_ai_system/shohin/index");
//          RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/edit.jsp");
//          rd.forward(request, response);
         }
	}

}
