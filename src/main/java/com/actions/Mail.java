package com.actions;

import com.opensymphony.xwork2.ActionSupport;

public class Mail extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String senderEmail;
	private String senderPassword;
	private String receiverEmail;
	private String subject;
	private String message;
	SendEmail obj = null;
	int resp = 0;
	
	@Override
	public String execute() throws Exception {
		obj = new SendEmail();
		resp = obj.sendMail(senderEmail, senderPassword, receiverEmail, subject, message);
		if (resp == 1) {
			return "success";
		} else {
			return "error";
		}		
	}

	public String getSenderEmail() {
		return senderEmail;
	}
	
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	
	public String getSenderPassword() {
		return senderPassword;
	}
	
	public void setSenderPassword(String senderPassword) {
		this.senderPassword = senderPassword;
	}
	
	public String getReceiverEmail() {
		return receiverEmail;
	}
	
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
}
