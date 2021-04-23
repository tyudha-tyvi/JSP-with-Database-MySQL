package com.actions;

import com.dao.JobDAO;
import com.opensymphony.xwork2.ActionSupport;

public class JobPost extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String job_name;
	private String company;
	private String address;
	private String deadline;
	private String message = "";
	JobDAO post = null;
	int ctr = 0;
	
	@Override
	public String execute() throws Exception {
		post = new JobDAO();

		try {
			ctr = post.postJob(job_name, company, address, deadline);
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

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
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
