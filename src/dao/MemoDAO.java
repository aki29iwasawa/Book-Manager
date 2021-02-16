package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Memo;

public class MemoDAO {
	//新規アカウントメモを3件分取得
	@SuppressWarnings("null")
	public ArrayList<Memo> getAccountMemo(int uID) {	
		Connection conn = null;
		ArrayList<Memo> aMemo = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "SELECT * FROM accountMemo WHERE userID = ?"
							+ " limit 3";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uID);
						
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//データが存在するか
//			if(rs.next()) {
				while(rs.next()) {
				
					int userID = rs.getInt("userID");
					String memo  = rs.getString("memo");
					
					aMemo.add(new Memo(userID, memo));			
					}
				
//				//データを取得
//				String memo = rs.getString("memo");
//				aMemo = new Memo(memo);
//			}else {
//				String memo = "メモが見つかりませんでした";
//				aMemo = new Memo(memo);
//			}
			
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

//	//メモを全件取得
//	public Memo getAllaMemo(int memo) {
//		Connection conn = null;
//		Memo aMemo = null;
//		
//		try {
//			
//			//JDBCドライバの読み込み
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			//データベース接続
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
//			
//			//select文		
//			String sql = "SELECT * FROM accountMemo WHERE userID = ?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//
//			pstmt.setInt(1, memo);
//						
//			//SQL実行、結果取得
//			ResultSet rs = pstmt.executeQuery();
//			
//			//データが存在するか
//			if(rs.next()) {
//				//データを取得
//				String allMemo = rs.getString("memo");
//				aMemo = new Memo(allMemo);
//			}else {
//				String allMemo = "メモが見つかりませんでした";
//				aMemo = new Memo(memo);
//			}
//			
//		} catch(SQLException e) {
//			System.out.println("データベースへのアクセスでエラーが発生しました。");
//			e.printStackTrace();
//			return null;
//		} catch(ClassNotFoundException e) {
//			System.out.println("JDBCドライバのロードでエラーが発生しました");
//			e.printStackTrace();
//			return null;
//		} finally {
//			//データベース切断
//			if(conn != null) {
//				try {
//					conn.close();
//				} catch(SQLException e) {
//					System.out.println("finallyデータベースへのアクセスでエラーが発生しました。");
//					e.printStackTrace();
//					return null;
//				}
//			}
//		}
//		return aMemo;
//	}

}
