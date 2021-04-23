package com.actions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileList extends ActionSupport {
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	User bean = null;
	List<User> beanList = null;
	UserDAO register = new UserDAO();

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<User>();
			rs = register.report();
			if (rs != null) {
				while (rs.next()) {
					bean = new User();
					bean.setFirst_name(rs.getString("FIRST_NAME"));
					bean.setLast_name(rs.getString("LAST_NAME"));
					bean.setEmail(rs.getString("EMAIL"));
					bean.setUser_name(rs.getString("USER_NAME"));
					bean.setPassword(rs.getString("PASSWORD").replaceAll("(?s).", "*"));
					beanList.add(bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "profile";
	}

	public List<User> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<User> beanList) {
		this.beanList = beanList;
	}
}
