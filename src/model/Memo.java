package model;

public class Memo {
	
	private int id;
	private int userID;
	private String memo;
	
	public Memo(int userID, String memo) {
		this.userID = userID;
		this.memo = memo;
	}
	
	public Memo(int userID) {
		this.userID = userID;
	}
	
	public Memo(String memo) {
		this.memo = memo;
	}
	
	public Memo(int id, String memo, int userID) {
		this.id = id;
		this.memo = memo;
		this.userID = userID;
	}
	
	public int id() { return id; }
	public String getAccountMemo() { return memo; }
	public int getUserID() { return userID; }
}
