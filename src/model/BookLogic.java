package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;
import dao.BookDAO;


public class BookLogic {
	//コンストラクタ作って、リクエストを渡す
	private String userID;
//	private String mail;
//	private String pass;
	private String bookID;
	
	public BookLogic(HttpServletRequest request) {
		//リクエストパラメータを取得
		this.userID =request.getParameter("userID");
//		this.mail =((ServletRequest) request).getParameter("mail");
//		this.pass =((ServletRequest) request).getParameter("password");
		
		this.bookID =request.getParameter("bookID");		
		
		
	}
	
	
	//書籍情報を一冊分取得
	public void getBookInfo(HttpServletRequest request){	
		//JSPから受け取ったIDをintに変換
		int uID = Integer.parseInt(userID);
		int bID = Integer.parseInt(bookID);
		
		//書籍情報一覧を取得
		Book book = new Book(bID, uID);			
//		BookLogic bl = new BookLogic();
//		book = bl.getBookData(book);
		
		BookDAO dao = new BookDAO();
		Book bookData = dao.getOneBookData(book);

		
		
		request.setAttribute("BookInfo", bookData);
	}
	
	
	
	
	
	//書籍検索、一覧画面「前へ」
	public ArrayList<Book> BookListChange(String id, int pageNum){
		int uID = Integer.parseInt(id);
		
		//表示させたい最大書籍数
		int min = pageNum * 10;
		int max = 10;
		
		BookDAO dao = new BookDAO();
		ArrayList<Book> bookDatas = dao.getBook(uID, min, max);		
		return bookDatas;
		
	}
	
	//初期表示。ページ番号は0
	public ArrayList<Book> BookList(String id, int pn) {
		int uID = Integer.parseInt(id);
			
		//表示させたい最大書籍数
		int max = pn + 10;
		
		BookDAO dao = new BookDAO();
		ArrayList<Book> bookDatas = dao.getBook(uID, pn, max);		
		return bookDatas;
	}	
	
	

//model内で方向判断をしたいが、戻せる値が一つのみなので、リストとページナンバーふたつをサーブレットに返せない。
//リクエストスコープへの保存はサーブレットからしかできないのか。
	public ArrayList<Book> BookList(String id, String pageNum, String direction) {
//	public void BookList(HttpServletRequest request, String id, String pageNum, String direction) {
		int uID = Integer.parseInt(id);
		int pn = Integer.parseInt(pageNum);
		int di = Integer.parseInt(direction);
		
		//前のページへ行くか次のページへ行くか
		if(di == 0) {
			//前のページへ	
			
			//ページナンバーを1減らす
			pn -= 1;
			
			//表示させたい書籍数
			int min = pn * 10;
			int max = min + 9;
			
			BookDAO dao = new BookDAO();
			ArrayList<Book> bookDatas = dao.getBook(uID, min, max);	

			return bookDatas;
			
//			request.setAttribute("books", bookDatas);
//			request.setAttribute("pageNum", pn);
//			request.setAttribute("uID", uID);
			
//ここでリクエスト保存ができたらいいなぁと思う。が、エラーが出てしまう。			
		}else {
			//次のページへ行く処理
			
			//ページナンバーに1増やす
			pn += 1;
			
			//表示させたい書籍数
			int min = pn * 10;
			int max = min + 9;
					
			BookDAO dao = new BookDAO();			
			ArrayList<Book> bookDatas = dao.getBook(uID, min, max);
			
			return bookDatas;
	
//			request.setAttribute("books", bookDatas);
//			request.setAttribute("pageNum", pn);
//			request.setAttribute("uID", uID);
			
		}


	}
	
	//本の詳細情報を表示する
	public Book getBookData(Book book) {
		BookDAO dao = new BookDAO();
		Book bookData = dao.getOneBookData(book);
		return bookData;
	}

	//本のデータを削除する
	public boolean deleteBookData(Book book){
		BookDAO dao = new BookDAO();
		boolean rs = dao.deleteBookData(book);
		return rs;
	}
	
	
	//書籍情報を更新
	public boolean updateBook(Book book){
		BookDAO dao = new BookDAO();
		boolean nBook = dao.updateBook(book);
		return nBook;
	}

	//書籍追加
	public boolean addBook(Book nbook) {
		BookDAO dao = new BookDAO();
		boolean rs = dao.addBookData(nbook);
		return rs;
	}
}

