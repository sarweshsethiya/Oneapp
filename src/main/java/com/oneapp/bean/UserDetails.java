package com.oneapp.bean;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("UserDetails")
@Scope("Prototype")
public class UserDetails {

	private int id;
	private String name;
	private String emailId;
	private String password;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", emailId="
				+ emailId + ", password=" + password + ", message=" + message
				+ "]";
	}
	
}
