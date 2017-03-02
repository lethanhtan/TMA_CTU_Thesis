/***********************************************************************
 * Module:  Customer.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Customer
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_USER" }) })
public class User {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", nullable = false, unique = true, length = 10)
	private Integer idUser;
	
	@Column(name = "USER_NAME", nullable = false, length = 40)
	private String userName;
	
	@Column(name = "PASSWORD", nullable = false, length = 20)
	private String password;
	
	@Column(name = "PASSWORD_CONFIRM", nullable = true, length = 20)
	private String passwordConfirm;
	
	@Column(name = "BIRTH_DATE_USER", nullable = true)
	private String dateUser;
	
	@Column(name = "NAME_USER", nullable = false, length = 60)
	private String nameUser;
	
	@Column(name = "ADDRESS_USER", nullable = true, length = 100)
	private String addressUser;
	
	@Column(name = "EMAIL_USER", nullable = true, length = 100)
	private String emailUser;
	
	@Column(name = "PHONE_USER", nullable = true)
	private String phoneUser;
	
	@Column(name = "SEX", nullable = true)
	private String sex;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ROLE", nullable = false)
	private Role role;
	
	//contructor
	public User() {}
	
	public User(String userName, String password, String passwordConfirm, String dateofbirth, String nameUser,
			String addressUser, String emailUser, String phoneUser, String sex) {
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.dateUser = dateofbirth;
		this.nameUser = nameUser;
		this.addressUser = addressUser;
		this.emailUser = emailUser;
		this.phoneUser = phoneUser;
		this.sex = sex;
	}
	
	public User(String userName, String password, String passwordConfirm, String dateofbirth, String nameUser,
			String addressUser, String emailUser, String phoneUser, String sex, Role role) {
		this.userName = userName;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.dateUser = dateofbirth;
		this.nameUser = nameUser;
		this.addressUser = addressUser;
		this.emailUser = emailUser;
		this.phoneUser = phoneUser;
		this.sex = sex;
		this.role = role;
	}
	
	//Getters and Setters method
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
	
	public String getDateUser() {
		return dateUser;
	}
	
	public void setDateUser(String birthdateUser) {
		this.dateUser = birthdateUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public String getPhoneUser() {
		return phoneUser;
	}

	public void setPhoneUser(String phoneUser) {
		this.phoneUser = phoneUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
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