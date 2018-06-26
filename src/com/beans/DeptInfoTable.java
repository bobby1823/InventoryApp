package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deptinfo")
public class DeptInfoTable {

	public DeptInfoTable() {
		
	}
	
	public DeptInfoTable(String username, String password) {
		this.username = username;
		this.password = password;
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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deptId")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Override
	public String toString() {
		return "DeptInfoTable [username=" + username + ", password=" + password + "]";
	}
}
