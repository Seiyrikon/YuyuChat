package org.yuyuchat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.yuyuchat.config.DatabaseConfig;

public class tbl_chatsModel extends ActionForm{

		private Long c_id,
					 user_id,
					 friend_id;
		
		private int del_flag;
		
		private String message;
		
		private Timestamp created_at,
						  updated_at;
	

		public Long getC_id()
		{
			return c_id;
		}
		
		public void setC_id(Long setter)
		{
			this.c_id = setter;
		}
		
		public Long getUser_id()
		{
			return user_id;
		}
		
		public void setUser_id(Long setter)
		{
			this.user_id = setter;
		}
		
		public Long getFriend_id()
		{
			return friend_id;
		}
		
		public void setFriend_id(Long setter)
		{
			this.friend_id = setter;
		}
		
		public String getMessage()
		{
			return message;
		}
		
		public void setMessage(String setter)
		{
			this.message = setter;
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
		
		
		
		public List<tbl_chatsModel> getAllChatsOfUser(Long user_id) {
			List<tbl_chatsModel> chats = new ArrayList<tbl_chatsModel>();

		    try (Connection connection = DatabaseConfig.getConnection()) {
		    	
		        String getAllChatsOfUser = "SELECT * FROM tbl_chats WHERE user_id = ?";

		        try (PreparedStatement statement = connection.prepareStatement(getAllChatsOfUser)) {
		            statement.setLong(1, user_id);

		            try (ResultSet resultSet = statement.executeQuery()) {
		                while (resultSet.next()) {
		                	tbl_chatsModel chat = new tbl_chatsModel();
		                	chat.setC_id(resultSet.getLong("c_id"));
		                	chat.setUser_id(resultSet.getLong("user_id"));
		                	chat.setFriend_id(resultSet.getLong("friend_id"));
		                	chat.setMessage(resultSet.getString("message"));
		                	chat.setDel_flag(resultSet.getInt("del_flag"));
		                	chat.setCreated_at(resultSet.getTimestamp("created_at"));
		                	chat.setUpdated_at(resultSet.getTimestamp("updated_at"));
		                	
		                	chats.add(chat);
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return chats;
		}
		
		public List<tbl_chatsModel> getAllChatsOfUserWithFriend(Long user_id, Long friend_id) {
			List<tbl_chatsModel> chats = new ArrayList<tbl_chatsModel>();

		    try (Connection connection = DatabaseConfig.getConnection()) {
		    	
		        String getAllChatsOfUser = "SELECT * FROM tbl_chats WHERE user_id = ? AND friend_id = ?";

		        try (PreparedStatement statement = connection.prepareStatement(getAllChatsOfUser)) {
		            statement.setLong(1, user_id);
		            statement.setLong(2, friend_id);

		            try (ResultSet resultSet = statement.executeQuery()) {
		                while (resultSet.next()) {
		                	tbl_chatsModel chat = new tbl_chatsModel();
		                	chat.setC_id(resultSet.getLong("c_id"));
		                	chat.setUser_id(resultSet.getLong("user_id"));
		                	chat.setFriend_id(resultSet.getLong("friend_id"));
		                	chat.setMessage(resultSet.getString("message"));
		                	chat.setDel_flag(resultSet.getInt("del_flag"));
		                	chat.setCreated_at(resultSet.getTimestamp("created_at"));
		                	chat.setUpdated_at(resultSet.getTimestamp("updated_at"));
		                	
		                	chats.add(chat);
		                }
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return chats;
		}
		
		public boolean insertChat(tbl_chatsModel body) {
			try (Connection connection = DatabaseConfig.getConnection()) {
	            String insertChat = "INSERT INTO tbl_chats (user_id, friend_id, message) VALUES (?, ?, ?)";

	            try (PreparedStatement statement = connection.prepareStatement(insertChat)) {
	                
	                statement.setLong(1, body.getUser_id());
	                statement.setLong(2, body.getFriend_id());
	                statement.setString(3, body.getMessage());

	                int rowsAffected = statement.executeUpdate();

	                return rowsAffected > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
		}
}
