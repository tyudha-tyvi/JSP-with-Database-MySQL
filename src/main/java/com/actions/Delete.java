package com.actions;

import com.dao.UserDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Delete extends ActionSupport {

	private static final long serialVersionUID = -1L;
	String email, message;
	UserDAO dao = new UserDAO();

	@Override
	public String execute() throws Exception {
		try {
			int isDeleted = dao.deleteUserDetails(email);
			if (isDeleted > 0) {
				message = "Record deleted successfully";
			} else {
				message = "Error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "delete";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}