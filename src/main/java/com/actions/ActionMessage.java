package com.actions;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.bean.Message;
import com.dao.MessageDao;

public class ActionMessage {
	
	private String sender;
	private String activeEmail;
	private String fromEmail="";
	private String toEmail="";
	private String msg="";
	private String msgDate="";
	private String msgTime="";
	private ResultSet rs;
	private String act="";
	private String status="";
	private String fullName="";
	private ArrayList<String> receiver = new ArrayList<String>(); 
	private ArrayList<Message> msgList = new ArrayList<Message>();
	private MessageDao msgDao = new MessageDao();
	
	
	public String execute() {
		status = (String) ServletActionContext.getRequest().getSession().getAttribute("status");
		fromEmail = (String) ServletActionContext.getRequest().getSession().getAttribute("email");
		activeEmail= (String) ServletActionContext.getRequest().getSession().getAttribute("email");
		fullName = (String) ServletActionContext.getRequest().getSession().getAttribute("fullName");
		sender=fullName;
		System.out.println(sender);
		
		if(!(status!=null)) {
			status="";
		}
		
		if(!status.equals("active")) {
			return "ERROR";
		}
		
		System.out.println(fromEmail);
		System.out.println(toEmail);
		
		if(act.equals("")) {
			act="listChat";
		}
		
		if(act.equals("listChat")) {
			
			try {
			
				rs = msgDao.msgReceiver(fromEmail);

				if (rs != null) {
					while (rs.next()) {
						receiver.add(rs.getString("email"));
					}
				}
			}catch(Exception e) {
				
			}	
			
			return "CHATLIST";
			
		} else if(act.equals("chat")){
			
			if(!msg.equals("")) {
				try {
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
					Date date = new Date();
					msgDate = dateFormat.format(date); 
					msgTime = timeFormat.format(date);
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println(fromEmail);
					System.out.println(toEmail);
					System.out.println(msgDate);
					System.out.println(msgTime);
					System.out.println(msg);
					
					System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					int i = msgDao.msgUser(sender, fromEmail, toEmail, msg, msgDate, msgTime);
						if(i>0) {
							
						}
					} catch(Exception e) {
						System.out.println(e);
					}
	
			} 
			
			try {
				System.out.println("==========================================");
				System.out.println("OBJECT");
				System.out.println("==========================================");			
				rs = msgDao.fetchMessages(fromEmail, toEmail);
				System.out.println("==========================================");
				System.out.println("ResultSetFound");
				System.out.println("==========================================");
				if (rs != null) {
					while (rs.next()) {
						Message msg = new Message();
						msg.setSender(rs.getString("NameSender"));
						msg.setFromEmail(rs.getString("FromEmail"));
						msg.setToEmail(rs.getString("ToEmail"));
						msg.setMsgDate(rs.getString("date"));
						msg.setMsgTime(rs.getString("time"));
						msg.setMsg(rs.getString("Message"));
						msgList.add(msg);
					}
				}
			}catch(Exception e) {
				
			}			
			
			return "CHAT";
			
		} else {
			
			return "CHAT";	
		}
		
	}



	public String getFromEmail() {
		return fromEmail;
	}



	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}



	public String getToEmail() {
		return toEmail;
	}



	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getMsgDate() {
		return msgDate;
	}



	public void setMsgDate(String msgDate) {
		this.msgDate = msgDate;
	}



	public String getMsgTime() {
		return msgTime;
	}



	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}



	public String getAct() {
		return act;
	}



	public void setAct(String act) {
		this.act = act;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public ArrayList<String> getReceiver() {
		return receiver;
	}



	public void setReceiver(ArrayList<String> receiver) {
		this.receiver = receiver;
	}



	public ArrayList<Message> getMsgList() {
		return msgList;
	}



	public void setMsgList(ArrayList<Message> msgList) {
		this.msgList = msgList;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getActiveEmail() {
		return activeEmail;
	}



	public void setActiveEmail(String activeEmail) {
		this.activeEmail = activeEmail;
	}



	public String getSender() {
		return sender;
	}



	public void setSender(String sender) {
		this.sender = sender;
	}

	
	

	
	
	
}
