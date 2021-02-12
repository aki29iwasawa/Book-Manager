package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;
import model.Memo;

public class MemoDAO {
	//新規アカウントメモを3件分取得
	public Memo getAccountMemo(int uID) {	
		Connection conn = null;
		Memo aMemo = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "SELECT * FROM accountMemo WHERE userID = ?";
//							+ " limit 3";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uID);
						
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//データが存在するか
			if(rs.next()) {
//				while(rs.next()) {
//					
//					int id = rs.getInt("id");
//					String title = rs.getString("title");
//					String author = rs.getString("author");
//					String publisher  = rs.getString("publisher");
//					int userID = rs.getInt("userID");
//					
//					bookDatas.add(new Book(id, title, author, publisher, userID));			
//					}
				
				//データを取得
				String memo = rs.getString("memo");
				aMemo = new Memo(memo);
			}else {
				String memo = "メモが見つかりませんでした";
				aMemo = new Memo(memo);
			}
			
		} catch(SQLException e) {
			System.out.println("データベースへのアクセスでエラーが発生しました。");
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードでエラーが発生しました");
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					System.out.println("finallyデータベースへのアクセスでエラーが発生しました。");
					e.printStackTrace();
					return null;
				}
			}
		}
		return aMemo;
	}

	public Memo getAllaMemo(Memo memo) {
		Connection conn = null;
		Memo aMemo = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "SELECT * FROM accountMemo WHERE userID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memo);
						
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//データが存在するか
			if(rs.next()) {
				//データを取得
				String memo = rs.getString("memo");
				aMemo = new Memo(memo);
			}else {
				String memo = "メモが見つかりませんでした";
				aMemo = new Memo(memo);
			}
			
		} catch(SQLException e) {
			System.out.println("データベースへのアクセスでエラーが発生しました。");
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードでエラーが発生しました");
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					System.out.println("finallyデータベースへのアクセスでエラーが発生しました。");
					e.printStackTrace();
					return null;
				}
			}
		}
		return aMemo;
	}

}
