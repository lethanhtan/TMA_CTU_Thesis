/***********************************************************************
 * Module:  Customer.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Customer
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
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_USER" }) })
public class User {

	@Id
	@Column(name = "ID_USER", nullable = false, unique = true, length = 10)
	private String idUser;
	
	@Column(name = "USER_NAME", nullable = false, length = 40)
	private String userName;
	
	@Column(name = "PASSWORD", nullable = false, length = 20)
	private String password;
	
	@Column(name = "PASSWORD_CONFIRM", nullable = true, length = 20)
	private String passwordConfirm;
	
	@Column(name = "BIRTHDAY", nullable = true)
	private String birthday;
	
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
	
	//contructor
	public User() {}
	
	public User(String userName, String password, String passwordConfirm, String birthday, String fullName,
			String address, String email, String phone, String sex) {
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.birthday = birthday;
		this.fullName = fullName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
	}
	
	public User(String userName, String password, String passwordConfirm, String birthday, String fullName,
			String address, String email, String phone, String sex, Role role) {
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.birthday = birthday;
		this.fullName = fullName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.role = role;
	}
	
	//Getters and Setters method
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
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
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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