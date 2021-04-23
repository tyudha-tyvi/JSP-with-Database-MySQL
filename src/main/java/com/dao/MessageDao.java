package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDao {
	
	//create connection
		public static Connection getConnection() throws Exception {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/id0420ff20a", "id0420ff20a", "v8y%R#qr?QDcr7S=");
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		//save Sent message
		public int msgUser(String sender, String fromEmail, String toEmail, String msg, String dateMsg, String timeMsg) throws Exception {
			int i = 0;
			if(msg == null || msg.equals("")) {
				return 0;
			}
			try {
				String sql = "INSERT INTO PRIVATEMESSAGE VALUES (?,?,?,?,?,?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, sender);
				ps.setString(2, fromEmail);
				ps.setString(3, toEmail);
				ps.setString(4, msg);
				ps.setString(5, dateMsg);
				ps.setString(6, timeMsg);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				return i;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		//fetch previous Receiver
		public ResultSet msgReceiver(String fromEmail) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT email FROM user WHERE ( ((email IN (SELECT fromEmail FROM privatemessage WHERE (fromEmail=? OR toEmail=?))) OR (email IN (SELECT toEmail FROM privatemessage WHERE (fromEmail=? OR toEmail=?)))) AND ((NOT (email =?))))";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, fromEmail);
				ps.setString(2, fromEmail);
				ps.setString(3, fromEmail);
				ps.setString(4, fromEmail);
				ps.setString(5, fromEmail);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		
		
		//fetch message
		public ResultSet fetchMessages(String email1, String email2) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT * FROM PRIVATEMESSAGE WHERE (fromEmail=? and toEmail=?) or (fromEmail=? and toEmail=?) ORDER BY DATE DESC, TIME ASC";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, email1);
				ps.setString(2, email2);
				ps.setString(3, email2);
				ps.setString(4, email1);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}


		


}
