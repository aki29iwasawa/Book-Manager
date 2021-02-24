package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.MemoDAO;

//import dao.BookDAO;
//import dao.MemoDAO;

public class MemoLogic {
//	//コンストラクタ作って、リクエストを渡す
//	private String userID;
//	private String bookID;
//	private String title;
//	private String author;
//	private String publisher;
//	
	private String id;
//	private String pageNum;
//	private String direction;
	
	public MemoLogic(HttpServletRequest request) {
//		//リクエストパラメータを取得
//		this.userID =request.getParameter("userID");
//		this.title =request.getParameter("title");
//		this.author =request.getParameter("author");
//		this.publisher =request.getParameter("publisher");	
//		this.bookID =request.getParameter("bookID");
		this.id =request.getParameter("id");
//		this.pageNum =request.getParameter("pageNum");
//		this.direction =request.getParameter("direction");
	}
	

	public void MemoList(HttpServletRequest request) {
		//JSPから受け取ったIDを数字に変換
		int uID = Integer.parseInt(id);
		
		//書籍情報一覧を取得
//		Memo memo = new Memo(uID);
		MemoDAO dao = new MemoDAO();
		ArrayList<Memo> memo = dao.getAllaMemo(uID);
		request.setAttribute("aMemo", memo);
		
	}



}
