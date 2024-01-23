package org.yuyuchat.model;

public class UserModel {

	private Long user_id;
	
	private String username,
				   first_name,
				   middle_name,
				   last_name;
	
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
	
	public String getFirst_name()
	{
		return first_name;
	}
	
	public void setFirst_name(String setter)
	{
		this.first_name = setter;
	}
	
	public String getMiddle_name()
	{
		return middle_name;
	}
	
	public void setMiddle_name(String setter)
	{
		this.middle_name = setter;
	}
	
	public String getLast_name()
	{
		return last_name;
	}
	
	public void setLast_name(String setter)
	{
		this.last_name = setter;
	}

}
