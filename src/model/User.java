package model;

public class User {
	
	private int id;
	private String mail;
	private String pass;
	
	public User(int id, String mail, String pass) {
		this.id = id;
		this.mail = mail;
		this.pass = pass;
	}
	
	public User(String mail, String pass) {
		this(0, mail, pass);
	}
	
	public User(int id) {
		this.id = id;
	}
	
	public int getId() { return id; }
//	public void setId(int id) { this.id = id; }
	public String getMail() { return mail; }
	public String getPass() { return pass; }
	
}
