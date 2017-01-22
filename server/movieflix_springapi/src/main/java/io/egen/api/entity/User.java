package io.egen.api.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "User.findByemailId", query = "SELECT e FROM User e WHERE e.emailId=:emailId") 
})
public class User
{
	@Id
	private String uId;
	
	@Column(unique=true)
	private String emailId;
	private String password;
	private String userRole;
	
	public User() {
		this.uId = UUID.randomUUID().toString();
	}
	
	public String getEmailId() {
		return emailId;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
}
