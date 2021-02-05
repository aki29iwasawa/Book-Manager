package model;

import java.util.ArrayList;

import dao.BmDAO;
import dao.BookDAO;

public class LoginLogic {
	//ログイン処理
	public User execute(User BmLogin) {
		BmDAO dao = new BmDAO();
		User user = dao.findByLogin(BmLogin);
		return user;
	}
	
	//ユーザー情報をintIDから取得
	public User getUserInfo(int uID){
		BmDAO dao = new BmDAO();
		User userData = dao.RefleshUserInfo(uID);
		return userData;		
	}

	//書籍一覧を取得
	public ArrayList<Book> getBookInfo(int uID){		
		BookDAO dao = new BookDAO();
		ArrayList<Book> bookDatas = dao.getAllDataBook(uID);		
		return bookDatas;	
	}
	
	//ユーザー情報の更新
	public boolean updateUser(User user){
		BmDAO dao = new BmDAO();
		boolean rs = dao.updateUser(user);
		return rs;		
	}
	
	
//	public ArrayList<String> getBookList(int userData){
//		
//		BookDAO dao = new BookDAO();
//		ArrayList<String> bookData = dao.getAllData(userData);
//		
//		return bookData;	
//	}
//	
//	public ArrayList<String> getBooks(int userData){
//		
//		BookDAO dao = new BookDAO();
//		ArrayList<String> bookDatas = dao.getBooks(userData);
//		
//		return bookDatas;	
//	}
	
}
