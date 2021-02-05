package model;

public class Book {
	
	private int id;
	private String title;
	private String author;
	private String publisher;
	private int userID;
	
	public Book(int id, String title, String author, String publisher, int userID) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.userID = userID;
	}
	
	public Book(int id, int userID) {
		this.id = id;
		this.userID = userID;
	}
	
	public Book(String title, String author, String publisher, int userID) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.userID = userID;
	}
	
	
	public int getId() { return id; }
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public String getPublisher() { return publisher; }
	public int getUserID() { return userID; }
	

}


