package com.actions;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String first_name;
	private String last_name;
	private String email;
	private String user_name;
	private String password;
	private String message = "";
	UserDAO register = null;
	int ctr = 0;
	
	@Override
	public String execute() throws Exception {
		register = new UserDAO();

		try {
			ctr = register.registerUser(first_name, last_name, email, user_name, password);
			if (ctr > 0) {
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}
}
