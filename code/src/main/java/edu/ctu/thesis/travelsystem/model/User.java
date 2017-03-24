/***********************************************************************
 * Module:  Customer.java
 * Author:  LÃª NhÆ° Ã
 * Purpose: Defines the Class Customer
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", nullable = false)
	private Integer idUser;

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

	// contructor
	public User() {
	}

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

	// Getters and Setters method
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
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

	@Override
	public int hashCode() {
		return idUser;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "Id = " + idUser;
	}

	@Override
	public boolean equals(Object user) {
		if (user == null || (user.getClass() != this.getClass())) {
			return false;
		} else {
			return this.idUser == ((User) user).getIdUser();
		}
	}
}