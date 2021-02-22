package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

//user tableの処理

public class UserDAO {
	//新規ユーザーを登録
	public boolean create(User user) {
		
		Connection conn = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//insert文　データの格納		
			String sql = "insert into user (mail, password) values (?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, user.getMail());
			pstmt.setString(2, user.getPass());
			
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

	//ログイン処理
	public User findByLogin(User bmLogin) {	
		Connection conn = null;
		User user = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "SELECT * FROM user WHERE mail = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bmLogin.getMail());
			pstmt.setString(2, bmLogin.getPass());
			
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//ユーザーが存在
			if(rs.next()) {
				//データを取得
				int id = rs.getInt("id");
				String mail = rs.getString("mail");
				String pass = rs.getString("password");
			
				user = new User(id, mail, pass);
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
		return user;
	}
	
	//IDからユーザー情報を取得
	public User RefleshUserInfo(int uID) {	
		Connection conn = null;
		User user = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uID);
						
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//ユーザーが存在
			if(rs.next()) {
				//データを取得
				int id = rs.getInt("id");
				String mail = rs.getString("mail");
				String pass = rs.getString("password");
			
				user = new User(id, mail, pass);
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
		return user;
	}

	//ユーザー情報の更新
	public boolean updateUser(User user) {
		
		Connection conn = null;
		
		try {
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//insert文　データの格納		
			String sql = "update user set mail=?, password=? where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, user.getMail());
			pstmt.setString(2, user.getPass());
			pstmt.setInt(3, user.getId());
			
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
	
	//アカウント情報の削除
	public boolean deleteUser(int uID) {
		Connection conn = null;
		
		try {			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "delete from user"
					+ " where id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, uID);
						
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
	
	
}
	

