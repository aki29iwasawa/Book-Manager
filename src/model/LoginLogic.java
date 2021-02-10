package model;

import java.util.ArrayList;

import dao.BmDAO;
import dao.BookDAO;

public class LoginLogic {
	//ログイン処理
	public User execute(User user) {
		BmDAO dao = new BmDAO();
		User userInfo = dao.findByLogin(user);
		return userInfo;
	}
	
	//ユーザー情報をintIDから取得
	public User getUserInfo(int uID){
		BmDAO dao = new BmDAO();
		User userData = dao.RefleshUserInfo(uID);
		return userData;		
	}

	//mypageの更新、書籍一覧を取得
	public ArrayList<Book> getBookInfo(int uID){		
		BookDAO dao = new BookDAO();
		ArrayList<Book> bookDatas = dao.getAllDataBook(uID);		
		return bookDatas;	
	}
	
	//mypageの更新、ユーザー情報
	public boolean updateUser(User user){
		BmDAO dao = new BmDAO();
		boolean rs = dao.updateUser(user);
		return rs;		
	}
	
	//アカウントを削除する
	public boolean deleteUser(User user){
		BmDAO dao = new BmDAO();
		boolean rs = dao.deleteUser(user);
		return rs;
	}
	

	
}
