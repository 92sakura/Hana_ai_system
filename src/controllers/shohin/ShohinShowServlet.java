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
 * Servlet implementation class ShohinShowServlet
 * 商品マスタ内容表示
 */
@WebServlet("/shohin/show")
public class ShohinShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShohinShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // データベース接続と結果取得のための変数
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        // インスタンスを生成
		Hanamast hana = new Hanamast();

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

            // 4. Select文の実行と結果を格納／代入
            rs = stmt.executeQuery("select * from hana_master where hanaCode = '"+ request.getParameter("id") + "'");

            // 5. 存在チェック
            if(rs.next()) {
        		// セット
            	hana.setHanaCode(rs.getString("hanaCode"));
            	hana.setHanaBun(rs.getString("hanaBun"));
            	hana.setHanaName(rs.getString("hanaName"));
            	hana.setHanaKana(rs.getString("hanaKana"));
            	hana.setHanaTank(rs.getInt("hanaTank"));
            	hana.setHanaBiko(rs.getString("hanaBiko"));

            } else {

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

        request.setAttribute("shohin", hana);
        request.setAttribute("_token", request.getSession().getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/show.jsp");
        rd.forward(request, response);
  	}

}
