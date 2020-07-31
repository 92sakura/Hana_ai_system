package controllers.shohin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Hanamast;

/**
 * Servlet implementation class ShohinIndexServlet
 * 商品マスタのマスタメンテ画面
 */
@WebServlet("/shohin/index")
public class ShohinIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShohinIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
 *  頁の初期設定
 */
        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(NumberFormatException e) { }

 /*
  * 【商品マスタ】データベース名=hanaya /テーブル名=hana_master
  *
  * ＤＢの読み込み
  *
*/
        // 保持するためのリストを作成
        ArrayList<Hanamast> so = new ArrayList<Hanamast>();

        // データベース接続と結果取得のための変数
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int Record_cnt = 0;

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
            rs = stmt.executeQuery("select count(*) from hana_master");
            if (rs.next()){
            	Record_cnt = rs.getInt(1);
            }

            // 4. Select文の実行と結果を格納／代入
            rs = stmt.executeQuery(String.format("select * from hana_master order by hanaCode limit %s, 15",(page - 1)*15));

            // 5. 結果を保持する
            while (rs.next()) {
                // インスタンスを生成
        		Hanamast hana = new Hanamast();
        		// セット
            	hana.setHanaCode(rs.getString("hanaCode"));
            	hana.setHanaBun(rs.getString("hanaBun"));
            	hana.setHanaName(rs.getString("hanaName"));
            	hana.setHanaKana(rs.getString("hanaKana"));
            	hana.setHanaTank(rs.getString("hanaTank"));
            	hana.setHanaBiko(rs.getString("hanaBiko"));

            	so.add(hana);
            }
 /*
  *            // 6. 商品マスタの内容表示
  *
  *         for (Hanamast ixdata: so){
  *         	System.out.println(ixdata.getHanaCode());
  *
  *         }
 */
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
/*
 * 商品マスタを表示
 */
        request.setAttribute("shodisp", so);
        request.setAttribute("shodisp_count", Record_cnt);
        request.setAttribute("page", page);

        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/shohin/index.jsp");
        rd.forward(request, response);
	}
}


