package model;

import dao.BmDAO;

public class SignUpLogic {
	public boolean execute(User user) {
		BmDAO dao = new BmDAO();
		boolean NewUser = dao.create(user);
		return NewUser;
	}
}
