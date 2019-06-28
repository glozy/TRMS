package com.revature.pojo;

public class Employee {
	
	private Integer employeeId;
	
	private String firstname;
	
	private String lastname;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String phone;
	
	private Integer reportsto;
	
	private Double balance;
	
	public Employee(String username, String password, String fullname) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = fullname;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer employeeId, String username, String password) {
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int id) {
		this.employeeId = id;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String fullname) {
		this.firstname = fullname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getReportsto() {
		return reportsto;
	}

	public void setReportsto(Integer reportsto) {
		this.reportsto = reportsto;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Employee(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", phone=" + phone
				+ ", reportsto=" + reportsto + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((reportsto == null) ? 0 : reportsto.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (reportsto == null) {
			if (other.reportsto != null)
				return false;
		} else if (!reportsto.equals(other.reportsto))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}
