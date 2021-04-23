package com.actions;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.dao.UserDAO;

public class LoginAdmin implements SessionAware  {
	private String email, password;
	SessionMap<String,Object> sessionMap; 
	String message =""; 
	String act="";
			
	public String execute() { 
		if(act.equals("logout")) {			
			sessionMap.remove("email");  
	        sessionMap.invalidate();
	        act="";
	        return "login";  		   
		} else {
		    try {
			   HttpSession session = ServletActionContext.getRequest().getSession(true);
				if (email != null) {				
					if (UserDAO.validateadmin(email, password)) {
						// add the attribute in session				
						sessionMap.put("email", email);	
						return "success";
					} else {
						return "login";
					}
				} else {	
					String getSessionAttr = (String) session.getAttribute("email");					
					if (getSessionAttr != null) {	
						return "success";	
					} else {
						return "login";
					}
				}
		    } catch(Exception e) {
		    	return "error";
		    }			
		}		
	}
		
	public void setSession(Map<String, Object> map) {  
		sessionMap = (SessionMap<String, Object>) map; 
    } 
		        
    public String logout(){  
        sessionMap.remove("email");  
        sessionMap.invalidate();       
        return "login";  
    }  	
    
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getAct() {
		return act;
	}
	
	public void setAct(String act) {
		this.act = act;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	  	
}