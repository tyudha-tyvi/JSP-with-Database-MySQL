package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThreadDAO {
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

		//save job data in database
		public int postThread(String title, String text) throws Exception {
			int i = 0;
			try {
				String sql = "INSERT INTO THREAD VALUES (?,?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, title);
				ps.setString(2, text);
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

		//fetch saved job data
		public ResultSet report() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT TITLE,TEXT FROM THREAD";
				PreparedStatement ps = getConnection().prepareStatement(sql);
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
