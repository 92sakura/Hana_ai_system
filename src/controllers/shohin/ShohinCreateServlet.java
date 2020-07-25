package controllers.shohin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 新規にデータベースに書き込む処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        String errors = null;
        String flush_new = null;
        String NewCode = null;
//        String hanatbl = null;
        String ha = null;
        String hb = null;
        String hc = null;
        String hd = null;
        Integer he = 0;
        String hf = null;

        if(_token != null && _token.equals(request.getSession().getId())) {
            // データベース接続と結果取得のための変数
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // 1. ドライバのクラスをJava上で読み込む
                Class.forName("com.mysql.jdbc.Driver");

                // 2. DBと接続する
                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/hanaya?useSSL=false",
                    "root",
                    "12345"
                );

                // 3. DBとやりとりする窓口（Statementオブジェクト）の作成
                stmt = con.createStatement();
                NewCode = request.getParameter("code");
                // 4. Select文の実行と結果を格納／代入
                rs = stmt.executeQuery("select * from hana_master where hanaCode = '"+ NewCode + "'");
                // 5. 存在チェック
                if(rs.next()) {
            		// エラー処理
                	// 登録済みのデータを表示しないと消えてしまう
                    // インスタンスを生成
            		Hanamast hana = new Hanamast();
                	hana.setHanaCode(request.getParameter("code"));
                	hana.setHanaBun(request.getParameter("bun"));
                	hana.setHanaName(request.getParameter("name"));
                	hana.setHanaKana(request.getParameter("kana"));
                	hana.setHanaTank(Integer.parseInt(request.getParameter("tank")));
                	hana.setHanaBiko(request.getParameter("biko"));
                	// エラーＭＳＧ表示
                	errors = "すでに登録済です";
                	request.setAttribute("shohin", hana);
                	request.setAttribute("_token", request.getSession().getId());
                	request.setAttribute("errors", errors);
                	request.setAttribute("flg","0");
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/new.jsp");
                    rd.forward(request, response);
                } else {
//                	hanatbl = "(hanaCode,hanaBun,hanaName,hanaKana,hanaTank,hanaBiko)";
                	ha = request.getParameter("code");
                	hb = request.getParameter("bun");
                	hc = request.getParameter("name");
                	hd = request.getParameter("kana");
                	he = Integer.parseInt(request.getParameter("tank"));
                	hf = request.getParameter("biko");

                	stmt.execute("INSERT  into Hana_master VALUES ('"+ ha +"','" + hb +"','" + hc + "','" + hd + "'," + he + ",'" + hf+ "')");
                	request.setAttribute("flg","0");
                	request.setAttribute("errors", null);
                	request.getSession().setAttribute("flush_new", "登録が完了しました。");
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/new.jsp");
                    rd.forward(request, response);
                 }
            } catch (SQLException e) {
                // DBとの処理で何らかのエラーがあった場合の例外
                e.printStackTrace();

            } catch (ClassNotFoundException e) {
                // JDBCドライバを読み込めないエラーがあった場合の例外
                e.printStackTrace();

            } finally {
                // 7. 接続を閉じる
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (con != null) {
                    try {
                        con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
	}
}
