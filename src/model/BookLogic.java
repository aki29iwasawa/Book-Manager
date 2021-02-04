package model;

import dao.BookDAO;

public class BookLogic {
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
	
	//本を追加
	public boolean updateBook(Book book){
		BookDAO dao = new BookDAO();
		boolean nBook = dao.updateBook(book);
		return nBook;
	}
}

