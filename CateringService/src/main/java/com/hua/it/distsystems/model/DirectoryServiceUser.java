package com.hua.it.distsystems.model;

public class DirectoryServiceUser {
	
	private String email;
	private String password;
	private String username;
	private String roleid;
	
   public DirectoryServiceUser() {
    	
    
	}
	
	
    public DirectoryServiceUser(String email,String password,String username,String roleid) {
    	
    	this.email=email;
    	this.password=password;
    	this.username=username;
    	this.roleid=roleid;
		
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
