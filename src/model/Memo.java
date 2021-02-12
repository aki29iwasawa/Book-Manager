package model;

public class Memo {
	
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
	
	public int getUserID() { return userID; }
	public String getAccountMemo() { return memo; }
}
