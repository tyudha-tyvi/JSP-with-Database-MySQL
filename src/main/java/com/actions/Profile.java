package com.actions;

import com.dao.UserDAO;

import java.sql.ResultSet;

import org.apache.struts2.ServletActionContext;

public class Profile {

	private String email;
	private String first_name;
	private String last_name;
	private String user_name;
	private String editProfile="";
	private ResultSet rs;
	
	public String execute() {		
		UserDAO dao = new UserDAO();
		try {
			email = (String) ServletActionContext.getRequest().getSession().getAttribute("email");
			System.out.println(email);
			System.out.println(email.trim());
			rs = dao.fetchUserDetails(email.trim());
			if (rs != null) {
				while (rs.next()) {
					first_name = rs.getString("first_name");
					last_name = rs.getString("last_name");
					user_name = rs.getString("user_name");
				}
			}		
		} catch(Exception e) {			
			System.out.print(e);			
		}				
		if(editProfile.equals("edit")) {
			return "edit";
		} else {
			return "success";
		}		
	}

	public String getEditProfile() {
		return editProfile;
	}

	public void setEditProfile(String editProfile) {
		this.editProfile = editProfile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
}
