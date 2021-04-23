package com.actions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Job;
import com.dao.JobDAO;
import com.opensymphony.xwork2.ActionSupport;

public class JobList extends ActionSupport {
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	Job bean = null;
	List<Job> beanList = null;
	JobDAO post = new JobDAO();

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<Job>();
			rs = post.report();
			if (rs != null) {
				while (rs.next()) {
					bean = new Job();
					bean.setJob_name(rs.getString("JOB_NAME"));
					bean.setCompany(rs.getString("COMPANY"));
					bean.setAddress(rs.getString("ADDRESS"));
					bean.setDeadline(rs.getString("DEADLINE"));
					beanList.add(bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "joblist";
	}

	public List<Job> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<Job> beanList) {
		this.beanList = beanList;
	}

}
