package model;

import dao.BmDAO;

public class SignUpLogic {
	public boolean execute(BmLogin BmLogin) {
		BmDAO dao = new BmDAO();
		boolean NewUser = dao.create(BmLogin);
		return NewUser;
	}
}
