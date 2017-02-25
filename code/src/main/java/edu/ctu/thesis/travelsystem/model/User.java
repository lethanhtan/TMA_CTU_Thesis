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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

@Entity
@Table(name = "USER", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_USER" }) })
public class User {

	private Integer idUser;
	private String userName;
	private String password;
	private String passwordConfirm;
	private Date dateofbirth;
	private String nameUser;
	private String addressUser;
	private String emailUser;
	private Integer phoneUser;
	private String sex;
	
	//Getters and Setters method
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", nullable = false, unique = true, length = 10)
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	@Column(name = "USER_NAME", nullable = false, length = 40)
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "PASSWORD", nullable = false, length = 20)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "PASSWORD_CONFIRM", nullable = true, length = 20)
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	@Column(name = "BIRTH_DATE_USER", nullable = true)
	public Date getBirthDateUser() {
		return dateofbirth;
	}
	
	public void setBirthDateUser(Date birthdateUser) {
		this.dateofbirth = birthdateUser;
	}

	@Column(name = "NAME_USER", nullable = false, length = 60)
	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	@Column(name = "ADDRESS_USER", nullable = true, length = 100)
	public String getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	@Column(name = "PHONE_USER", nullable = true)
	public Integer getPhoneUser() {
		return phoneUser;
	}

	public void setPhoneUser(Integer phoneUser) {
		this.phoneUser = phoneUser;
	}

	@Column(name = "EMAIL_USER", nullable = true, length = 100)
	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	
	@Column(name = "SEX", nullable = true)
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}

}