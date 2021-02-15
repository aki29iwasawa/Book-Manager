package model;

import java.util.ArrayList;

import dao.BookDAO;

public class BookLogic {
	//書籍検索、一覧画面を表示
	public ArrayList<Book> BookList(String id, int pageNum, String direction) {
		int uID = Integer.parseInt(id);

		int di = Integer.parseInt(direction);
		
		int pn = pageNum;
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

