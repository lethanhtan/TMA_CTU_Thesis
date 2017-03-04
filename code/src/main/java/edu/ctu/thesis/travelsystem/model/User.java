/***********************************************************************
 * Module:  Customer.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class User
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.persistence.CascadeType;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class User {

	@Id
	@Column(name = "ID", nullable = false, unique = true, length = 10)
	private String id;
	
	@Column(name = "USER_NAME", nullable = false, length = 40)
	private String userName;
	
	@Column(name = "PASSWORD", nullable = false, length = 20)
	private String password;
	
	@Column(name = "PASSWORD_CONFIRM", nullable = true, length = 20)
	private String passwordConfirm;
	
	@Column(name = "BIRTH_DATE", nullable = true)
	private String birthDate;
	
	@Column(name = "FULL_NAME", nullable = false, length = 60)
	private String fullName;
	
	@Column(name = "ADDRESS", nullable = true, length = 100)
	private String address;
	
	@Column(name = "EMAIL", nullable = true, length = 100)
	private String email;
	
	@Column(name = "PHONE", nullable = true)
	private String phone;
	
	@Column(name = "SEX", nullable = true)
	private String sex;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ROLE", nullable = false)
	private Role role;
	
	//constructor
	public User() {}
	
	public User(String userName, String password, String passwordConfirm, String birthDate, String fullName,
			String address, String email, String phone, String sex, Role role) {
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.birthDate = birthDate;
		this.fullName = fullName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.role = role;
	}
	
	//getters and setters method
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
}