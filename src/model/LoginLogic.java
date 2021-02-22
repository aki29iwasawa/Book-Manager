package model;

import java.util.ArrayList;

//import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import dao.UserDAO;
import dao.BookDAO;
import dao.MemoDAO;


//ログインおよびマイページ表示に関するロジック
public class LoginLogic {

	private String id;
	private String mail;
	private String pass;
	
	public LoginLogic(HttpServletRequest request){
		//リクエストパラメータを取得
		this.id =request.getParameter("id");
		this.mail =request.getParameter("mail");
		this.pass =request.getParameter("password");
//		this.pass =((ServletRequest) request).getParameter("password");
	}
	
	//アカウント新規作成
	public boolean createAccount(HttpServletRequest request) {
		//アカウント作成処理
		User user = new User(mail, pass);		
		UserDAO uDao = new UserDAO();
		boolean result = uDao.create(user);
		
		if(result) {
			//ログイン処理を実行
			User uInfo = uDao.findByLogin(user);
//後で調整
			//IDから本とメモの情報を取得
//			int uID = uInfo.getId();			
//			ArrayList<Book> bookInfo = getBookInfo(uID);
			
			//セッションにデータを保存
			request.setAttribute("uInfo", uInfo);
//			request.setAttribute("books", bookInfo);
			request.setAttribute("mess", "下記内容でアカウントを登録しました");		
		}
		return result;
	}
	
	//ログイン処理
	public void Login(HttpServletRequest request) {
		//メールとパスからユーザーデータを取得
		User user = new User(mail, pass);	
		UserDAO uDao = new UserDAO();
		User uInfo = uDao.findByLogin(user);
		
		//Userからidを取り出し、マイページ表示処理にリクエストと供に渡す
		//マイページ表示で使うメモ、書籍情報取得はユーザーidが必要なのでここでidを取得
		//サーブレットのtoMypageでも同様
		int uID = uInfo.getId();		
		toMypage(request, uID);
	
//		ArrayList<Book> bookInfo = getBookInfo(uID);
//		ArrayList<Memo> memoInfo = getAccountMemo(uID);		
//		//セッションにデータを保存
//		request.setAttribute("uInfo", uInfo);
//		request.setAttribute("aMemo", aMemo);
//		request.setAttribute("books", bookInfo);		
	}
	
	
	//マイページ情報取得
	public void toMypage(HttpServletRequest request, int uID) {
		//ログイン処理でもこのメソッドを使いたいのでint変換をサーブレットにやってもらう形にした。	
//		//JSPから受け取ったIDをintに変換
//		int uID = Integer.parseInt(id);
			
		//ユーザー情報を取得
		UserDAO uDao = new UserDAO();
		User uInfo = uDao.RefleshUserInfo(uID);			
		//メモ情報を取得
		MemoDAO mDao = new MemoDAO();
		ArrayList<Memo> aMemo = mDao.getNewMemo(uID);			
		//書籍情報を取得
		BookDAO bDao = new BookDAO();
		ArrayList<Book> bookInfo = bDao.getBookMypage(uID);		
		
		//セッションにデータを保存
		request.setAttribute("uInfo", uInfo);
		request.setAttribute("aMemo", aMemo);
		request.setAttribute("books", bookInfo);
	}
	
	
	//ユーザー情報のみを取得
	public void getUserInfo(HttpServletRequest request){		
		//JSPから受け取ったIDをintに変換
		int uID = Integer.parseInt(id);
			
		//ユーザー情報を取得
		UserDAO dao = new UserDAO();
		User uInfo = dao.RefleshUserInfo(uID);
		
		//セッションにデータを保存
		request.setAttribute("uInfo", uInfo);		
	}	

	
	//ユーザー情報更新 ？？？？？
	public void updateUser(HttpServletRequest request){
		
		//JSPから受け取ったIDをintに変換
		int uID = Integer.parseInt(id);
		
		//リクエスト内のユーザー情報をuserにまとめ、更新処理
		User user = new User(uID, mail, pass);
		UserDAO uDao = new UserDAO();
		boolean rs = uDao.updateUser(user);

		//結果を表示し、マイページへ戻る
		String alertMess = null;
		if(!rs) {
			alertMess ="エラーが発生しました";
		} else {
			alertMess ="ユーザー情報を保存しました";
		}
			
		//アラートメッセージを保存し、マイページ情報取得
		request.setAttribute("aMess", alertMess);
		toMypage(request, uID);
	}
	
	
	//アカウントを削除する
	public void deleteUser(HttpServletRequest request){
	
		//JSPから受け取ったIDを数字に変換
		int uID = Integer.parseInt(id);
		
		//書籍の削除を実行
		UserDAO dao = new UserDAO();
		boolean rs = dao.deleteUser(uID);
		
		String aMess = null;
		if(rs) {
			aMess = "アカウントの削除が完了しました/nご利用ありがとうございました。";
		}else if(!rs) {
			aMess = "エラーが発生しました";
		}					
		//セッションにデータを保存
//		HttpSession session = request.getSession();
//		session.invalidate();
		request.setAttribute("deleteMess", aMess);
	}
	

//
//	//mypageの更新、書籍一覧を取得
//	public ArrayList<Book> getBookInfo(int uID){		
//		BookDAO dao = new BookDAO();
//		ArrayList<Book> bookDatas = dao.getBookMypage(uID);		
//		return bookDatas;	
//	}
//	
//	
//	//mypageの更新、メモ情報取得
//	public ArrayList<Memo> getAccountMemo(int uID) {
//		MemoDAO dao = new MemoDAO();
//		ArrayList<Memo> aMemo = dao.getNewMemo(uID);
//		return aMemo;
//	}
//	

	
}
