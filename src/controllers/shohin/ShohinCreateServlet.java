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
 * Servlet implementation class ShohinCreateServlet 新規に商品登録
 */
@WebServlet("/shohin/create")
public class ShohinCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShohinCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response) 新規にデータベースに書き込む処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _token = (String) request.getParameter("_token");
		ArrayList<String> errors = new ArrayList<>();
		String NewCode = null;
		if (_token != null && _token.equals(request.getSession().getId())) {
			// インスタンスを生成
			Hanamast hana = new Hanamast();
			//
			NewCode = request.getParameter("code");
			// データの存在チェック
			if (hana.GetRecord(NewCode)) {
				// エラー処理（すでに登録済）
				// 入力内容の保持(登録済みのデータを表示しないと消えてしまう)
				hana.SetData(request);
				// エラーＭＳＧ表示
				errors.add("すでに登録済です");
				request.setAttribute("shohin", hana);
			} else {
				// 入力内容の保持
				hana.SetData(request);
				// 入力項目のチェック
				if (Check_err(hana, errors)) {
					// 登録処理のクラスへ
					hana.Insert();
					request.setAttribute("flush_new", "登録が完了しました。");
				} else {
					request.setAttribute("shohin", hana);
				}
			}
			request.setAttribute("_token", request.getSession().getId());
			request.setAttribute("errors", errors);
			request.setAttribute("flg", "0");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/new.jsp");
			rd.forward(request, response);

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
