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
	    SignUpModel user = null;

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
	                    user = new SignUpModel();
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


	
	public boolean insertUser(SignUpModel body) {
		try (Connection connection = DatabaseConfig.getConnection()) {
            // SQL statement for inserting user data
            String insertUser = "INSERT INTO tbl_user (username, password) VALUES (?, ?)";

            // Create a PreparedStatement
            try (PreparedStatement statement = connection.prepareStatement(insertUser)) {
                // Set values for the parameters
                statement.setString(1, body.getUsername());
                statement.setString(2, body.getPassword());

                // Execute the INSERT statement
                int rowsAffected = statement.executeUpdate();

                // Check if the insert was successful
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, log it, or rethrow it as needed
            return false;
        }
	}
	
	public boolean insertPersonalInfo(SignUpModel body) {
		try (Connection connection = DatabaseConfig.getConnection()) {
            // SQL statement for inserting user data
            String insertPersonalInfo = "INSERT INTO tbl_personal_info (user_id, first_name, middle_name, last_name) VALUES (?, ?, ?, ?)";

            // Create a PreparedStatement
            try (PreparedStatement statement = connection.prepareStatement(insertPersonalInfo)) {
            	
            	SignUpModel userFromDb = getUserByUsername(body.getUsername());
            	
            	if(userFromDb != null) {
            		// Set values for the parameters
                    statement.setLong(1, userFromDb.getUserId());
                    statement.setString(2, body.getFirstName());
                    statement.setString(3, body.getMiddleName());
                    statement.setString(4, body.getLastName());
            	}
            	// Execute the INSERT statement
                int rowsAffected = statement.executeUpdate();

                // Check if the insert was successful
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception, log it, or rethrow it as needed
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
