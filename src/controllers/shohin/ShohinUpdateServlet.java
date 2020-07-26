package controllers.shohin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Hanamast;

/**
 * Servlet implementation class ShohinUpdateServlet
 * 商品の上書き更新処理
 */
@WebServlet("/shohin/update")
public class ShohinUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShohinUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * データベースの更新処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        ArrayList<String> errors = new ArrayList<>();

        if(_token != null && _token.equals(request.getSession().getId())) {
			// インスタンスを生成
			Hanamast hana = new Hanamast();
 			hana.SetData(request);
			// 入力項目のチェック
			if (Check_err(hana, errors)) {
					// 編集処理のクラスへ
					hana.Update();
					request.getSession().setAttribute("flush", "編集が完了しました。");
                	request.getSession().setAttribute("_token", request.getSession().getId());
                    response.sendRedirect("/Hana_ai_system/shohin/index");
//                    RequestDispatcher rd = request.getRequestDispatcher("/shohin/index");
//                    rd.forward(request, response);
				} else {
                    // 項目誤りで返却する
                	request.setAttribute("shohin", hana);
                	request.setAttribute("_token", request.getSession().getId());
                	request.setAttribute("errors", errors);
                	request.setAttribute("flg","1");
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/edit.jsp");
                    rd.forward(request, response);
             }
         }
   	}
/*
 * 入力項目のエラーチェック
 */
	private boolean Check_err(Hanamast hana,ArrayList<String> errors) {
		if (hana.getHanaBun() == null || hana.getHanaBun() == "") {
			errors.add("分類が未入力です");
		}
		if (hana.getHanaName() == null || hana.getHanaName() == "") {
			errors.add("名前が未入力です");
		}
		if (hana.getHanaKana() == null || hana.getHanaKana() == "") {
			errors.add("カナが未入力です");
		}
		if (hana.getHanaTank() == null || hana.getHanaTank() == "") {
			errors.add("単価が未入力です");
		} else {
			try {
				Integer.parseInt(hana.getHanaTank());
			} catch (NumberFormatException e) {
				errors.add("単価が数値ではありません");
			}
		}
		// if(hana.getHanaBiko() == null || hana.getHanaBiko() == ""){
		// errors.add("備考が未入力です");
		// }
		// エラー=0だったら true エラーがありだったら false
		// errors.size()==0 だけでもいい
		return (errors.size() == 0);
	}

}
