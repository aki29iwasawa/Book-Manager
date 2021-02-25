package model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import dao.MemoDAO;


public class MemoLogic {
	//コンストラクタ作って、リクエストを渡す
	private String id;
	private String memo;
	private String memoID;
//	private String pageNum;
//	private String direction;
	
	public MemoLogic(HttpServletRequest request) {
		//リクエストパラメータを取得
		this.id =request.getParameter("id");
		this.memo = request.getParameter("memo");
		this.memoID = request.getParameter("memoID");
//		this.pageNum =request.getParameter("pageNum");
//		this.direction =request.getParameter("direction");
	}
	

	//メモ全件。初期表示ページは0
	public void MemoList(HttpServletRequest request) {
		//JSPから受け取ったIDを数字に変換
		int uID = Integer.parseInt(id);
		
		//書籍情報一覧を取得
		MemoDAO mDao = new MemoDAO();
		ArrayList<Memo> aMemo = mDao.getAllaMemo(uID);
		request.setAttribute("aMemo", aMemo);
	}


	//メモ追加
	public void addMemo(HttpServletRequest request) {
		//JSPから受け取ったIDを数字に変換
		int uID = Integer.parseInt(id);
		
		Memo nMemo = new Memo(memo, uID);
		MemoDAO mDao = new MemoDAO();
		boolean rs = mDao.addMemoData(nMemo);
		
		//実行結果をメッセージとしてリクエスト保存
		String aMess = null;
		if(!rs) {
			aMess ="エラーが発生しました";
		} else {
			aMess ="メモを保存しました";
		}
		request.setAttribute("aMess", aMess);
	}


	//書籍情報を一冊分取得
	public void getMemoInfo(HttpServletRequest request) {
		//JSPから受け取ったIDをintに変換
		int uID = Integer.parseInt(id);
		int mID = Integer.parseInt(memoID);
		
		//書籍情報一覧を取得
		Memo nMemo = new Memo(mID,uID);
		MemoDAO mDao = new MemoDAO();
		Memo memoData = mDao.getOneMemoData(nMemo);

		request.setAttribute("MemoInfo", memoData);
		}
	}
		
		
	



