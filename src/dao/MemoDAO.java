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
	public ArrayList<Memo> getNewMemo(int uID) {	
		Connection conn = null;
		ArrayList<Memo> aMemo = new ArrayList<Memo>();
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "SELECT * FROM memo WHERE userID = ?"
					+ " order by id desc"		
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
					
					aMemo.add(new Memo(memo, userID));			
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

	//メモを全件取得
	public ArrayList<Memo> getAllaMemo(int uID) {
		Connection conn = null;
		ArrayList<Memo> aMemo = new ArrayList<Memo>();
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "SELECT * FROM memo WHERE userID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uID);
						
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//データを取得
			while(rs.next()) {
			
			int id = rs.getInt("id");
			String memo = rs.getString("memo");
			String create = rs.getString("created_at");
			String update  = rs.getString("updated_at");
			int userID = rs.getInt("userID");
			
			aMemo.add(new Memo(id, memo, create, update, userID));	
			}
			

//			//データが存在するか
//			
//			if(rs.next()) {
//				//データを取得
//				String allMemo = rs.getString("memo");
//				aMemo = new Memo(allMemo);
//			}else {
//				String allMemo = "メモが見つかりませんでした";
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

	public boolean addMemoData(Memo nMemo) {
		
		Connection conn = null;
		
		try {		
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//insert文　データの格納		
			String sql = "insert into memo (memo, userID) values (?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nMemo.getMemo());
			pstmt.setInt(2, nMemo.getUserID());
			
			//SQL実行、結果取得
			int result = pstmt.executeUpdate();
			
			if(result !=1) {
				return false;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	
	public Memo getOneMemoData(Memo oneMemo) {	
		Connection conn = null;
		Memo memoData = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
		
			//select文		
			String sql = "select * from memo"
					+ " where id = ? "
					+ " and userID = ? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, oneMemo.getMemoID());
			pstmt.setInt(2, oneMemo.getUserID());
						
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//データを取得
			while(rs.next()) {
			
			int id = rs.getInt("id");
			String memo = rs.getString("memo");
			String create = rs.getString("created_at");
			String update  = rs.getString("updated_at");
			int userID = rs.getInt("userID");
			
			memoData = new Memo(id, memo, create, update, userID);
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
		return memoData;
	}

}
