package org.yuyuchat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		LoginModel user = null;

	    try (Connection connection = DatabaseConfig.getConnection()) {
	        // SQL statement for retrieving user data by username
	        String getUserByUsername = "SELECT * FROM tbl_user WHERE username = ?";

	        // Create a PreparedStatement
	        try (PreparedStatement statement = connection.prepareStatement(getUserByUsername)) {
	            // Set the username parameter
	            statement.setString(1, username);

	            // Execute the SELECT statement
	            try (ResultSet resultSet = statement.executeQuery()) {
	                // Check if the user with the given username exists
	                if (resultSet.next()) {
	                    // Map the result set to SignUpModel fields
	                    user = new LoginModel();
	                    user.setUserId(resultSet.getLong("user_id"));
	                    user.setUsername(resultSet.getString("username"));
	                    user.setPassword(resultSet.getString("password"));
	                    // Set other fields accordingly
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle the exception, log it, or rethrow it as needed
	    }

	    return user;
	}
	
	public boolean login(LoginModel body) {
		try {
			LoginModel user = new LoginModel();
			
			user = getUserByUsername(body.getUsername());
			
			if(body.getPassword() != user.getPassword())
			{
				return false;
			}
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
