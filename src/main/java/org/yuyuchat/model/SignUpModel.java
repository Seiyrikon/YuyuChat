package org.yuyuchat.model;

public class SignUpModel {

	private String username,
				   password,
				   firstName,
				   middleName,
				   lastName;

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
}
