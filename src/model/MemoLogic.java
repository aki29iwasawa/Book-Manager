package model;

//import dao.BookDAO;
import dao.MemoDAO;

public class MemoLogic {
	//メモ情報を表示する
	public Memo getMemoData(Memo memo) {
		MemoDAO dao = new MemoDAO();
		Memo aMemo = dao.getAllaMemo(memo);
		return aMemo;
	}

}
