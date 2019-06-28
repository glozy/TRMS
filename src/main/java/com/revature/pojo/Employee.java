package com.revature.pojo;

public class Employee {
	
	private String username;
	
	private String password;
	
	private String fullname;
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Employee(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", fullname=" + fullname + ", id=" + id + "]";
	}
	
}
