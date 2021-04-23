package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
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

		//save user data in database
		public int registerUser(String first_name, String last_name, String email, String user_name, String password) throws Exception {
			int i = 0;
			try {
				String sql = "INSERT INTO USER VALUES (?,?,?,?,?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, first_name);
				ps.setString(2, last_name);
				ps.setString(3, email);
				ps.setString(4, user_name);
				ps.setString(5, password);
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

		//fetch saved user data
		public ResultSet report() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT FIRST_NAME,LAST_NAME,EMAIL,USER_NAME,PASSWORD FROM USER";
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

		//fetch old data to be update
		public ResultSet fetchUserDetails(String email) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT FIRST_NAME,LAST_NAME,EMAIL,USER_NAME,PASSWORD FROM USER WHERE EMAIL=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, email);
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

		//update new data in database
		public int updateUserDetails(String first_name, String last_name, String email, String user_name, String password, String emailhidden)
				throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE USER SET FIRST_NAME=?,LAST_NAME=?,EMAIL=?,USER_NAME=?,PASSWORD=? WHERE EMAIL=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, first_name);
				ps.setString(2, last_name);
				ps.setString(3, email);
				ps.setString(4, user_name);
				ps.setString(5, password);
				ps.setString(6, emailhidden);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}
		
		// method for delete the record
		public int deleteUserDetails(String email) throws SQLException, Exception {
			getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM USER WHERE EMAIL=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, email);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				getConnection().rollback();
				return 0;
			} finally {
				if (getConnection() != null) {
					getConnection().close();
				}
			}
		}

		//login		
		public static boolean validate(String email,String password) {
			boolean status=false;
			try {
				String sql = "SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,email);  
				ps.setString(2,password);  
				ResultSet rs=ps.executeQuery();  
				status=rs.next();
				}
			catch(Exception e) {
				e.printStackTrace();
				}
			return status;
		}		
		
		//login	admin	
		public static boolean validateadmin(String email,String password) {
			boolean status=false;
			try {
				String sql = "SELECT * FROM ADMIN WHERE EMAIL=? AND PASSWORD=?";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1,email);  
				ps.setString(2,password);  
				ResultSet rs=ps.executeQuery();  
				status=rs.next();
				}
			catch(Exception e) {
				e.printStackTrace();
				}
			return status;
		}		
		
		public String searchValidation(String param) {
			if(param == null) {
				return "";	
			} else {
				return param;
			}
		}
		
		// Advance Search User
		public ResultSet advanceSearchUser(String email, String first_name, String last_name, String user_name) throws SQLException, Exception {
			ResultSet rs = null;

			email=searchValidation(email);
			first_name=searchValidation(first_name);
			last_name=searchValidation(last_name);
			user_name=searchValidation(user_name);
			
			try {

				String sql = "SELECT * FROM USER WHERE (email like ? and first_name like ? and last_name like ? and user_name like ?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, "%"+email+"%");
				ps.setString(2, "%"+first_name+"%");
				ps.setString(3, "%"+last_name+"%");
				ps.setString(4, "%"+user_name+"%");
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
		
		//basicSearchUser
		public ResultSet basicSearchUser(String keyWord) throws SQLException, Exception {
			ResultSet rs = null;

			keyWord=searchValidation(keyWord);
			
			
			try {
				String sql = "SELECT * FROM USER WHERE (email like ? or first_name like ? or last_name like ? or user_name like ?)";
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, "%"+keyWord+"%");
				ps.setString(2, "%"+keyWord+"%");
				ps.setString(3, "%"+keyWord+"%");
				ps.setString(4, "%"+keyWord+"%");
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
