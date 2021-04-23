package com.actions;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.bean.User;
import com.dao.UserDAO;

public class Search {		
	
	private String email;
	private String first_name;
	private String last_name;
	private String user_name;
	
	private String basicKeyWord="";
	private String keyWordEmail="";
	private String keyWordFirst_Name="";
	private String keyWordLast_Name="";
	private String keyWordUser_Name="";


	
	
	private String status;
	private ResultSet rs;
	private UserDAO userDao = new UserDAO();
	private ArrayList<User> listUser = new ArrayList<User>();
	private String dataResult="false";
	private String act="all";
	
	public String execute() {
		status = (String) ServletActionContext.getRequest().getSession().getAttribute("status");
		
		if(!(status!=null)) {
			status="";
		}
		
		if(status.equals("")) {
			return "ERROR";
		}
		
		
	if(act.equals("basicSearch")) {
		try{
			rs = userDao.basicSearchUser(basicKeyWord);
			while(rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_name(rs.getString("user_name"));
				listUser.add(user);
			}
				
			}catch(Exception e) {
				
			}
		
	} else if (act.equals("advanceSearch")) {
		try{
			rs = userDao.advanceSearchUser(keyWordEmail, keyWordFirst_Name, keyWordLast_Name, keyWordUser_Name);
			while(rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_name(rs.getString("user_name"));
				listUser.add(user);
			}
				
			}catch(Exception e) {
				
			}
	} else {
		try{
			rs = userDao.report();
			while(rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setFirst_name(rs.getString("firstName"));
				user.setLast_name(rs.getString("lastName"));
				user.setUser_name(rs.getString("user_name"));
				listUser.add(user);
			}
				
			}catch(Exception e) {
				
			}
	}
		
	
	
		if(!listUser.isEmpty()) {
			dataResult = "true";
		} else {
			dataResult = "false";
		}
		
		return "SUCCESS";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getBasicKeyWord() {
		return basicKeyWord;
	}

	public void setBasicKeyWord(String basicKeyWord) {
		this.basicKeyWord = basicKeyWord;
	}

	public String getKeyWordEmail() {
		return keyWordEmail;
	}

	public void setKeyWordEmail(String keyWordEmail) {
		this.keyWordEmail = keyWordEmail;
	}

	public String getKeyWordFirst_Name() {
		return keyWordFirst_Name;
	}

	public void setKeyWordFirst_Name(String keyWordFirst_Name) {
		this.keyWordFirst_Name = keyWordFirst_Name;
	}

	public String getKeyWordLast_Name() {
		return keyWordLast_Name;
	}

	public void setKeyWordLast_Name(String keyWordLast_Name) {
		this.keyWordLast_Name = keyWordLast_Name;
	}

	public String getKeyWordUser_Name() {
		return keyWordUser_Name;
	}

	public void setKeyWordUser_Name(String keyWordUser_Name) {
		this.keyWordUser_Name = keyWordUser_Name;
	}

	public String getAct() {
		return act;
	}

	public void setAct(String act) {
		this.act = act;
	}

	public ArrayList<User> getListUser() {
		return listUser;
	}

	public void setListUser(ArrayList<User> listUser) {
		this.listUser = listUser;
	}

	public String getDataResult() {
		return dataResult;
	}

	public void setDataResult(String dataResult) {
		this.dataResult = dataResult;
	}

}
