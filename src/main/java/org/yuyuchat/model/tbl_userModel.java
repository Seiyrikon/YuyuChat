package org.yuyuchat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.yuyuchat.config.DatabaseConfig;

public class tbl_userModel extends ActionForm{
	
	private Long user_id;
	
	private String username,
				   password;
	
	private int del_flag;
	
	private Timestamp created_at,
				      updated_at;
	
	public Long getUser_id()
	{
		return user_id;
	}
	
	public void setUser_id(Long setter)
	{
		this.user_id = setter;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String setter)
	{
		this.username = setter;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String setter)
	{
		this.password = setter;
	}
	
	public int getDel_flag()
	{
		return del_flag;
	}
	
	public void setDel_flag(int setter)
	{
		this.del_flag = setter;
	}
	
	public Timestamp getCreated_at()
	{
		return created_at;
	}
	
	public void setCreated_at(Timestamp setter)
	{
		this.created_at = setter;
	}
	
	public Timestamp getUpdated_at()
	{
		return updated_at;
	}
	
	public void setUpdated_at(Timestamp setter)
	{
		this.updated_at = setter;
	}
	
	public List<tbl_userModel> getAllUser(HttpServletRequest request) {
	    List<tbl_userModel> users = new ArrayList<tbl_userModel>();
	    
	    try (Connection connection = DatabaseConfig.getConnection()) {
	        String getAllUser = "SELECT * FROM tbl_user WHERE del_flag = 0";

	        try (PreparedStatement statement = connection.prepareStatement(getAllUser)) {
	          
	        	try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    tbl_userModel user = new tbl_userModel();
	                    user.setUser_id(resultSet.getLong("user_id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setPassword(resultSet.getString("password"));
	                    user.setDel_flag(resultSet.getInt("del_flag"));
	                    user.setCreated_at(resultSet.getTimestamp("created_at"));
	                    user.setUpdated_at(resultSet.getTimestamp("updated_at"));

	                    users.add(user);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return users;
	}
	
	public tbl_userModel getUserByUsername(String username) {
		tbl_userModel user = new tbl_userModel();

	    try (Connection connection = DatabaseConfig.getConnection()) {
	        String getUserByUsername = "SELECT * FROM tbl_user WHERE username = ?";

	        try (PreparedStatement statement = connection.prepareStatement(getUserByUsername)) {

	            statement.setString(1, username);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                	user.setUser_id(resultSet.getLong("user_id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setPassword(resultSet.getString("password"));
	                    user.setDel_flag(resultSet.getInt("del_flag"));
	                    user.setCreated_at(resultSet.getTimestamp("created_at"));
	                    user.setUpdated_at(resultSet.getTimestamp("updated_at"));
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}
	
	public tbl_userModel getUserByUserId(Long user_id) {
		tbl_userModel user = new tbl_userModel();

	    try (Connection connection = DatabaseConfig.getConnection()) {
	        String getUserByUserId = "SELECT * FROM tbl_user WHERE user_id = ?";

	        try (PreparedStatement statement = connection.prepareStatement(getUserByUserId)) {

	            statement.setLong(1, user_id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                	user.setUser_id(resultSet.getLong("user_id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setPassword(resultSet.getString("password"));
	                    user.setDel_flag(resultSet.getInt("del_flag"));
	                    user.setCreated_at(resultSet.getTimestamp("created_at"));
	                    user.setUpdated_at(resultSet.getTimestamp("updated_at"));
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}
	
	public List<UserModel> getAllUserModel(HttpServletRequest request) {
	    List<UserModel> users = new ArrayList<UserModel>();
	    
HttpSession session = request.getSession();
	    
	    Long principal_id = Long.parseLong(session.getAttribute("userId").toString());


	    try (Connection connection = DatabaseConfig.getConnection()) {
	        String getAllUserModel = "SELECT users.user_id AS user_id, users.username AS username, pi.first_name AS first_name, pi.middle_name AS middle_name, pi.last_name AS last_name FROM tbl_user AS users INNER JOIN tbl_personal_info AS pi ON users.user_id = pi.user_id WHERE users.user_id != ? AND users.del_flag = 0";

	        try (PreparedStatement statement = connection.prepareStatement(getAllUserModel)) {

	        	statement.setLong(1, principal_id);
	        	
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                	UserModel user = new UserModel();
	                    user.setUser_id(resultSet.getLong("user_id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setFirst_name(resultSet.getString("first_name"));
	                    user.setMiddle_name(resultSet.getString("middle_name"));
	                    user.setLast_name(resultSet.getString("last_name"));
	                    
	                    users.add(user);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return users;
	}
	
	public UserModel getUserModelByUsername(String username) {
	    UserModel user = new UserModel();

	    try (Connection connection = DatabaseConfig.getConnection()) {
	        String getUserModelByUsername = "SELECT users.user_id AS user_id, users.username AS username, pi.first_name AS first_name, pi.middle_name AS middle_name, pi.last_name AS last_name FROM tbl_user AS users INNER JOIN tbl_personal_info AS pi ON users.user_id = pi.user_id WHERE users.username = ? AND users.del_flag = 0";

	        try (PreparedStatement statement = connection.prepareStatement(getUserModelByUsername)) {
	            statement.setString(1, username);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    user.setUser_id(resultSet.getLong("user_id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setFirst_name(resultSet.getString("first_name"));
	                    user.setMiddle_name(resultSet.getString("middle_name"));
	                    user.setLast_name(resultSet.getString("last_name"));
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}
	
	public UserModel getUserModelByUserId(Long user_id) {
	    UserModel user = new UserModel();

	    try (Connection connection = DatabaseConfig.getConnection()) {
	        String getUserModelByUserId = "SELECT users.user_id AS user_id, users.username AS username, pi.first_name AS first_name, pi.middle_name AS middle_name, pi.last_name AS last_name FROM tbl_user AS users INNER JOIN tbl_personal_info AS pi ON users.user_id = pi.user_id WHERE users.user_id = ? AND users.del_flag = 0";

	        try (PreparedStatement statement = connection.prepareStatement(getUserModelByUserId)) {
	            statement.setLong(1, user_id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    user.setUser_id(resultSet.getLong("user_id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setFirst_name(resultSet.getString("first_name"));
	                    user.setMiddle_name(resultSet.getString("middle_name"));
	                    user.setLast_name(resultSet.getString("last_name"));
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}


}
