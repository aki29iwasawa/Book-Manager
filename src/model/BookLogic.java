package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import dao.BookDAO;


public class BookLogic {
	//コンストラクタ作って、リクエストを渡す
	private String userID;
	private String bookID;
	private String title;
	private String author;
	private String publisher;
	
	private String id;
	private String pageNum;
	private String direction;
	
	public BookLogic(HttpServletRequest request) {
		//リクエストパラメータを取得
		this.userID =request.getParameter("userID");
		this.title =request.getParameter("title");
		this.author =request.getParameter("author");
		this.publisher =request.getParameter("publisher");	
		this.bookID =request.getParameter("bookID");
		this.id =request.getParameter("id");
		this.pageNum =request.getParameter("pageNum");
		this.direction =request.getParameter("direction");
	}
	
	
	//書籍情報を一冊分取得
	public void getBookInfo(HttpServletRequest request){	
		//JSPから受け取ったIDをintに変換
		int uID = Integer.parseInt(userID);
		int bID = Integer.parseInt(bookID);
		
		//書籍情報一覧を取得
		Book book = new Book(bID, uID);					
		BookDAO dao = new BookDAO();
		Book bookData = dao.getOneBookData(book);

		request.setAttribute("BookInfo", bookData);
	}
	
	
	//書籍情報を更新
	public void updateBook(HttpServletRequest request){
		//JSPから受け取ったIDを数字に変換
		int bID = Integer.parseInt(bookID);
		int uID = Integer.parseInt(userID);
		
		//書籍情報を取得し、更新処理を実行
		Book nBook = new Book(bID, title, author, publisher, uID);
		BookDAO dao = new BookDAO();
		boolean rs = dao.updateBook(nBook);

		//更新結果をメッセージとしてリクエスト保存
		String aMess = null;
		if(rs) {
			aMess ="書籍情報を保存しました";
		} else {
			aMess ="エラーが発生しました";
		}
		request.setAttribute("aMess", aMess);
		
		//書籍情報一覧を取得
		getBookInfo(request);
	}
		
		
	//本のデータを削除する
	public void deleteBookData(HttpServletRequest request){
		//JSPから受け取ったIDを数字に変換
		int bID = Integer.parseInt(bookID);
		int uID = Integer.parseInt(userID);
		
		//書籍の削除を実行
		Book book = new Book(bID, uID);		
		BookDAO dao = new BookDAO();
		boolean rs = dao.deleteBookData(book);

		//実行結果をメッセージとしてリクエスト保存
		String aMess = null;
		if(rs) {
			aMess = "書籍の削除が完了しました";
		}else if(!rs) {
			aMess = "エラーが発生しました";
		}		
		request.setAttribute("aMess", aMess);
	}

	
	//書籍追加
	public void addBook(HttpServletRequest request) {
		//JSPから受け取ったIDを数字に変換
		int uID = Integer.parseInt(userID);
		
		Book nbook = new Book(title, author, publisher, uID);
		BookDAO dao = new BookDAO();
		boolean rs = dao.addBookData(nbook);
		
		//実行結果をメッセージとしてリクエスト保存
		String aMess = null;
		if(!rs) {
			aMess ="エラーが発生しました";
		} else {
			aMess ="書籍情報を保存しました";
		}
		request.setAttribute("aMess", aMess);
	}
	
	//初期表示。ページ番号は0
	public void BookList(HttpServletRequest request) {
		//JSPから受け取ったIDを数字に変換、初期ページ番号を設定
		int uID = Integer.parseInt(id);
		int pn = 0;
		
		//書籍一覧を取得
		BookDAO dao = new BookDAO();
		ArrayList<Book> books = dao.getBook(uID, pn);
		
		request.setAttribute("books", books);
		request.setAttribute("pageNum", 0);//ページは初期値0
		request.setAttribute("uID", uID);
	}
	
	public void BookSerch(HttpServletRequest request) {
		//JSPから受け取ったIDを数字に変換、初期ページ番号を設定
		int uID = Integer.parseInt(id);
		int pn = 0;
		
		//検索書籍一覧を取得
		BookDAO dao = new BookDAO();
		ArrayList<Book> books = dao.searchBook(uID, pn);
		
		request.setAttribute("books", books);
		request.setAttribute("pageNum", 0);//ページは初期値0
		request.setAttribute("uID", uID);
	}	
	
	public void getPaged(HttpServletRequest request) {	
		
		//JSPから受け取ったIDを数字に変換
		int uID = Integer.parseInt(id);
		int pn = Integer.parseInt(pageNum);
		int di = Integer.parseInt(direction);
			
		//前のページへ行くか次のページへ行くかdirectionを判断
		if(di == 0) {
		//前のページへ
			
			//ページナンバーを1減らす
			pn -= 1;
			
			//表示させたい書籍数
			int min = pn * 10;
			
			BookDAO dao = new BookDAO();
			ArrayList<Book> bookDatas = dao.getBook(uID, min);	
				
			request.setAttribute("books", bookDatas);
			request.setAttribute("pageNum", pn);
			request.setAttribute("uID", uID);
							
		}else {
		//次のページへ
				
			//ページナンバーに1増やす
			pn += 1;
		
			//表示させたい書籍数
			int min = pn * 10;
					
			BookDAO dao = new BookDAO();			
			ArrayList<Book> bookDatas = dao.getBook(uID, min);
			
			request.setAttribute("books", bookDatas);
			request.setAttribute("pageNum", pn);
			request.setAttribute("uID", uID);				
			}
		}
}

