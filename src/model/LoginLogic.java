package model;

import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.BmDAO;
import dao.BookDAO;
import dao.MemoDAO;

public class LoginLogic {
	
//	private int id;
	private String mail;
	private String pass;
	
	//コンストラクタ
	public LoginLogic(HttpServletRequest request){

		
		//リクエストパラメータを取得	
		String action =((ServletRequest) request).getParameter("action");	
		String id =((ServletRequest) request).getParameter("id");
		String mail =((ServletRequest) request).getParameter("mail");
		String pass =((ServletRequest) request).getParameter("password");
		
//		String bookID =request.getParameter("bookID");		
////		String title =request.getParameter("title");
////		String author =request.getParameter("author");
////		String publisher =request.getParameter("publisher");
//		String userID =request.getParameter("userID");
//		
//		String pageNum =request.getParameter("pageNum");
//		String direction =request.getParameter("direction");
		
	}
	
	
	//アカウント新規作成
	public boolean createAccount(HttpServletRequest request) {

		User user = new User(mail, pass);		
		BmDAO dao = new BmDAO();
		boolean result = dao.create(user);
		
		if(result) {
			//ログイン処理の実行
//			User user = new User(mail, pass);
//			LoginLogic bo = new LoginLogic();
//			user = bo.execute(user);
			
			int uID = user.getId();
			
			User uInfo = getUserInfo(uID);				
			ArrayList<Book> bookInfo = getBookInfo(uID);
			
			//セッションにデータを保存
			HttpSession session = request.getSession();
			session.setAttribute("uInfo", uInfo);
			session.setAttribute("books", bookInfo);
			session.setAttribute("mess", "下記内容でアカウントを登録しました");
		
		}	return result;
	}
	
	
	//ログイン処理
	public User execute(User user) {
		BmDAO dao = new BmDAO();
		User userInfo = dao.findByLogin(user);
		return userInfo;
	}
	
	//アカウントを削除する
	public boolean deleteUser(User user){
		BmDAO dao = new BmDAO();
		boolean rs = dao.deleteUser(user);
		return rs;
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
		ArrayList<Book> bookDatas = dao.getBookMypage(uID);		
		return bookDatas;	
	}
	
	//mypageの更新、ユーザー情報取得
	public boolean updateUser(User user){
		BmDAO dao = new BmDAO();
		boolean rs = dao.updateUser(user);
		return rs;		
	}
	
	//mypageの更新、メモ情報取得
	public ArrayList<Memo> getAccountMemo(int uID) {
		MemoDAO dao = new MemoDAO();
		ArrayList<Memo> aMemo = dao.getNewMemo(uID);
		return aMemo;
	}
	

	
}
