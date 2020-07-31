package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

/*
 * 商品マスタ(Hana_master)に関するクラス
 */
public class Hanamast {

	    private String hanaCode;
	    private String hanaBun;
	    private String hanaName;
	    private String hanaKana;
	    private String hanaTank;
	    private String hanaBiko;

		public String getHanaCode() {
			return hanaCode;
		}

		public void setHanaCode(String hanaCode) {
			this.hanaCode = hanaCode;
		}

		public String getHanaBun() {
			return hanaBun;
		}

		public void setHanaBun(String hanaBun) {
			this.hanaBun = hanaBun;
		}

		public String getHanaName() {
			return hanaName;
		}

		public void setHanaName(String hanaName) {
			this.hanaName = hanaName;
		}

		public String getHanaKana() {
			return hanaKana;
		}

		public void setHanaKana(String hanaKana) {
			this.hanaKana = hanaKana;
		}

		public String getHanaTank() {
			return hanaTank;
		}

		public void setHanaTank(String hanaTank) {
			this.hanaTank = hanaTank;
		}

		public String getHanaBiko() {
			return hanaBiko;
		}

		public void setHanaBiko(String hanaBiko) {
			this.hanaBiko = hanaBiko;
		}
/**********************
 * 登録処理（Insert）
 **********************/
		public boolean Insert(){
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try{
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
            	String sql = String.format("INSERT into Hana_master VALUES ('%s','%s','%s','%s',%s,'%s')",
            			this.hanaCode,
            			this.hanaBun,
            			this.hanaName,
            			this.hanaKana,
            			this.hanaTank,
            			this.hanaBiko);
                stmt.execute(sql);
            	return true;
            } catch (SQLException e) {
            	// DBとの処理で何らかのエラーがあった場合の例外
            	e.printStackTrace();
            	return false;
            } catch (ClassNotFoundException e) {
            	// JDBCドライバを読み込めないエラーがあった場合の例外
            	e.printStackTrace();
            	return false;
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
/**********************
* 更新処理 (Update)
***********************/
		public boolean Update(){
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try{
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
            	String sql = String.format("UPDATE Hana_master SET hanaBun = '%s',hanaName = '%s',hanaKana = '%s',hanaTank = %s,hanaBiko = '%s' WHERE hanaCode = '%s'",
            			this.hanaBun,
            			this.hanaName,
            			this.hanaKana,
            			this.hanaTank,
            			this.hanaBiko,
            			this.hanaCode);
//            	System.out.println(sql);
                stmt.execute(sql);
            	return true;
            } catch (SQLException e) {
            	// DBとの処理で何らかのエラーがあった場合の例外
            	e.printStackTrace();
            	return false;
            } catch (ClassNotFoundException e) {
            	// JDBCドライバを読み込めないエラーがあった場合の例外
            	e.printStackTrace();
            	return false;
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
/**********************
* 削除処理 (Delete)
***********************/
		public boolean Delete(){
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try{
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
            	String sql = String.format("DELETE from Hana_master WHERE hanaCode = '%s' LIMIT 1",this.hanaCode);
//            	System.out.println(sql);
                stmt.execute(sql);
            	return true;
            } catch (SQLException e) {
            	// DBとの処理で何らかのエラーがあった場合の例外
            	e.printStackTrace();
            	return false;
            } catch (ClassNotFoundException e) {
            	// JDBCドライバを読み込めないエラーがあった場合の例外
            	e.printStackTrace();
            	return false;
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
/**********************
* レコード取得
***********************/
		public boolean GetRecord(String code){
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;
            try{
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
            	rs = stmt.executeQuery("select * from hana_master where hanaCode = '"+ code + "'");
            	// 5. 存在チェック true:あった時はセットする
            	if(rs.next()) {
            		this.hanaCode = rs.getString("hanaCode");
            		this.hanaBun = rs.getString("hanaBun");
            		this.hanaName = rs.getString("hanaName");
            		this.hanaKana = rs.getString("hanaKana");
            		this.hanaTank = rs.getString("hanaTank");
            		this.hanaBiko = rs.getString("hanaBiko");
            		return true;
            	} else {
            		return false;
            	}
            } catch (SQLException e) {
            	// DBとの処理で何らかのエラーがあった場合の例外
            	e.printStackTrace();
            	return false;
            } catch (ClassNotFoundException e) {
            	// JDBCドライバを読み込めないエラーがあった場合の例外
            	e.printStackTrace();
            	return false;
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
/**********************
* マスタ内容のセット
***********************/
		public void SetData(HttpServletRequest request){
			this.hanaCode = request.getParameter("code");
			this.hanaBun = request.getParameter("bun");
			this.hanaName = request.getParameter("name");
			this.hanaKana = request.getParameter("kana");
			this.hanaTank = request.getParameter("tank");
			this.hanaBiko = request.getParameter("biko");
		}
	}
