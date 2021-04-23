package com.actions;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Thread;
import com.dao.ThreadDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ThreadList extends ActionSupport {
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	Thread bean = null;
	List<Thread> beanList = null;
	ThreadDAO post = new ThreadDAO();

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<Thread>();
			rs = post.report();
			if (rs != null) {
				while (rs.next()) {
					bean = new Thread();
					bean.setTitle(rs.getString("TITLE"));
					bean.setText(rs.getString("TEXT"));
					beanList.add(bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "threadlist";
	}

	public List<Thread> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<Thread> beanList) {
		this.beanList = beanList;
	}

}
