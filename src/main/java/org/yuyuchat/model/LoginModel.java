package org.yuyuchat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.yuyuchat.config.DatabaseConfig;

public class LoginModel extends ActionForm{

	private Long userId;
	
	private String username,
	   				password;
	
	public Long getUserId()
	{
		return userId;
	}
	
	public void setUserId(Long setter)
	{
		this.userId = setter;
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
	
	public LoginModel getUserByUsername(String username) {
		LoginModel user = new LoginModel();

	    try (Connection connection = DatabaseConfig.getConnection()) {
	        String getUserByUsername = "SELECT * FROM tbl_user WHERE username = ?";

	        try (PreparedStatement statement = connection.prepareStatement(getUserByUsername)) {

	            statement.setString(1, username);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    user.setUserId(resultSet.getLong("user_id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setPassword(resultSet.getString("password"));
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return user;
	}
	
	public boolean login(LoginModel body, HttpServletRequest request) {
		try {
			LoginModel user = getUserByUsername(body.getUsername());
			if (user != null && body.getPassword().equals(user.getPassword())) {
                // Set userId in session upon successful login
                HttpSession session = request.getSession();
                session.setAttribute("userId", user.getUserId());
                return true;
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
