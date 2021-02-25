package model;

public class Memo {
	
	private int memoID;
	private int userID;
	private String memo;
	private String create;
	private String update;
	
	public Memo(String memo, int userID) {
		this.userID = userID;
		this.memo = memo;
	}
	
	public Memo(int userID) {
		this.userID = userID;
	}
	
	public Memo(String memo) {
		this.memo = memo;
	}
	
	public Memo(int memoID, int userID) {
		this.memoID = memoID;
		this.userID = userID;
	}
	
	public Memo(int memoID, String memo, int userID) {
		this.memoID = memoID;
		this.memo = memo;
		this.userID = userID;
	}
	
	public Memo(int memoID, String memo, String create, String update, int userID) {
		this.memoID = memoID;
		this.memo = memo;
		this.create = create;
		this.update = update;
		this.userID = userID;
	}

	public int getMemoID() { return memoID; }
	public String getMemo() { return memo; }
	public String getCreate() { return create; }
	public String getUpdate() { return update; }
	public int getUserID() { return userID; }
}
