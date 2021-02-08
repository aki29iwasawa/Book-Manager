package dao;

import java.util.ArrayList;

import model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookDAO {
	//書籍詳細画面表示のための情報取得
	public Book getOneBookData(Book book) {
		
		Connection conn = null;
		Book bookData = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
		
			//select文		
			String sql = "select id, title, author, publisher, userID"
					+ " from book"
					+ " where userID = ? "
					+ " and id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, book.getUserID());
			pstmt.setInt(2, book.getId());
						
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//データを取得
			while(rs.next()) {
			
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String publisher  = rs.getString("publisher");
			int userID = rs.getInt("userID");
			
			bookData = new Book(id, title, author, publisher, userID);
			
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
		return bookData;		
	}
	
	//書籍情報編集
	public boolean updateBook(Book book) {
		
		Connection conn = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//insert文　データの格納		
			String sql = "update book set title=?, author=?, publisher=? where id=? and userID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getId());
			pstmt.setInt(5, book.getUserID());
			
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
	
	//書籍情報の削除
	public boolean deleteBookData(Book book) {
		Connection conn = null;
		
		try {			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//select文		
			String sql = "delete from book"
					+ " where userID = ? "
					+ " and id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, book.getUserID());
			pstmt.setInt(2, book.getId());
						
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
	
	
	public ArrayList<Book> getAllDataBook(int userData) {		
		Connection conn = null;
		ArrayList<Book> bookDatas = new ArrayList<Book>();
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");

			//select文		
			String sql = "select id, title, author, publisher, userID"
					+ " from book"
					+ " where userID = ? ";

			//					+ " limit 3";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userData);
						
			//SQL実行、結果取得
			ResultSet rs = pstmt.executeQuery();
			
			//データを取得
			while(rs.next()) {
			
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String publisher  = rs.getString("publisher");
			int userID = rs.getInt("userID");
			
			bookDatas.add(new Book(id, title, author, publisher, userID));			
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
		return bookDatas;		
	}

	public boolean addBookData(Book nbook) {
	
		Connection conn = null;
		
		try {
			
			//JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bm?serverTimezone=JST", "root", "pass");
			
			//insert文　データの格納		
			String sql = "insert into book (title, author, publisher, userID) values (?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nbook.getTitle());
			pstmt.setString(2, nbook.getAuthor());
			pstmt.setString(1, nbook.getPublisher());
			pstmt.setInt(1, nbook.getUserID());
			
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
