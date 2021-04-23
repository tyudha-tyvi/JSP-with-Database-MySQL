package com.actions;

import java.sql.ResultSet;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAdmin extends ActionSupport {
	private static final long serialVersionUID = -1L;
	private String first_name = "";
	private String last_name = "";
	private String email = "";
	private String user_name = "";
	private String password = "";
	private String emailhidden = "";
	private String message = "";
	ResultSet rs = null;
	UserDAO dao = new UserDAO();
	String submitType;

	@Override
	public String execute() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				rs = dao.fetchUserDetails(email.trim());
				if (rs != null) {
					while (rs.next()) {
						first_name = rs.getString("FIRST_NAME");
						last_name = rs.getString("LAST_NAME");
						email = rs.getString("EMAIL");
						user_name = rs.getString("USER_NAME");
						password = rs.getString("PASSWORD");
					}
				}
			} else {
				int i = dao.updateUserDetails(first_name, last_name, email, user_name, password, emailhidden);
				if (i > 0) {
					message = "Record Updated Successfuly";
				} else {
					message = "Error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "update";
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

	public String getEmailhidden() {
		return emailhidden;
	}

	public void setEmailhidden(String emailhidden) {
		this.emailhidden = emailhidden;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
}
