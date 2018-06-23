package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userTable")
public class LoginUserTable {

	public LoginUserTable() {
			
	}
	
	public LoginUserTable(String userName, String password) {
		this.username = userName;
		this.password = password;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

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

	@Override
	public String toString() {
		return "LoginUserTable [username=" + username + ", password=" + password + "]";
	}
}
