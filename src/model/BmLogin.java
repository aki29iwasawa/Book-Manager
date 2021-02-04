package model;

public class BmLogin {
	
	private String mail;
	private String pass;
	
	public BmLogin(String mail, String pass) {
		this.mail = mail;
		this.pass = pass;
	}
	
	public String getMail() { return mail; }
	public String getPass() { return pass; }
	
}
