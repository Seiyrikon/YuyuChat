package org.yuyuchat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts.action.ActionForm;
import org.yuyuchat.config.DatabaseConfig;

public class SignUpModel extends ActionForm{
	
	private Long userId;

	private String username,
				   password,
				   firstName,
				   middleName,
				   lastName;
	
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
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String setter)
	{
		this.firstName = setter;
	}
	
	public String getMiddleName()
	{
		return middleName;
	}
	
	public void setMiddleName(String setter)
	{
		this.middleName = setter;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String setter)
	{
		this.lastName = setter;
	}
	
	public SignUpModel getUserByUsername(String username) {
	    SignUpModel user = new SignUpModel();

	    try (Connection connection = DatabaseConfig.getConnection()) {
	        String getUserByUsername = "SELECT * FROM tbl_user WHERE username = ?";

	        try (PreparedStatement statement = connection.prepareStatement(getUserByUsername)) {
	            
	            statement.setString(1, username);

	            // Execute the SELECT statement
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


	
	public boolean insertUser(SignUpModel body) {
		try (Connection connection = DatabaseConfig.getConnection()) {
            String insertUser = "INSERT INTO tbl_user (username, password) VALUES (?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(insertUser)) {
                
                statement.setString(1, body.getUsername());
                statement.setString(2, body.getPassword());

                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public boolean insertPersonalInfo(SignUpModel body) {
		try (Connection connection = DatabaseConfig.getConnection()) {
            String insertPersonalInfo = "INSERT INTO tbl_personal_info (user_id, first_name, middle_name, last_name) VALUES (?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(insertPersonalInfo)) {
            	
            	SignUpModel userFromDb = getUserByUsername(body.getUsername());
            	
            	if(userFromDb != null) {
                    statement.setLong(1, userFromDb.getUserId());
                    statement.setString(2, body.getFirstName());
                    statement.setString(3, body.getMiddleName());
                    statement.setString(4, body.getLastName());
            	}
                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public boolean signup(SignUpModel body) {
		try {
			insertUser(body);
			insertPersonalInfo(body);
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
