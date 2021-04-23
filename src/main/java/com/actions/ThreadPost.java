package com.actions;

import com.dao.ThreadDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ThreadPost extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String title;
	private String text;
	private String message = "";
	ThreadDAO post = null;
	int ctr = 0;
	
	@Override
	public String execute() throws Exception {
		post = new ThreadDAO();

		try {
			ctr = post.postThread(title, text);
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
