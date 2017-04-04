/***********************************************************************
 * Module:  Customer.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Customer
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER")
public class User {

	private Integer idUser;
	private String userName;
	private String password;
	private Date timeRes;
	private Date dateRes;
	private Date birthday;
	private String fullName;
	private String address;
	private String email;
	private String phone;
	private String sex;
	private Role role;
	private String descRole = "Khách hàng";
	
	//contructor
	public User() {}
	
	public User(String userName, String password, Date birthday, String fullName,
			String address, String email, String phone, String sex, Date dateRes, Date timeRes) {

		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
		this.fullName = fullName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.dateRes = dateRes;
		this.timeRes = timeRes;
	}

	public User(String userName, String password, String passwordConfirm, Date birthday, String fullName,
			String address, String email, String phone, String sex, Role role) {
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
		this.fullName = fullName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.sex = sex;
		this.role = role;
	}
	
	//Getters and Setters method
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_USER", nullable = false)
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

	@Column(name = "BIRTHDAY", nullable = true)
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {

		this.birthday = birthday;
	}
	
	@Column(name = "FULL_NAME", nullable = false, length = 60)
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name = "ADDRESS", nullable = true, length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "PHONE", nullable = true)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name = "EMAIL", nullable = true, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "SEX", nullable = true)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "TIME_RES", nullable = true)
	@Temporal(TemporalType.TIME)
	public Date getTime() {
		return timeRes;
	}
	
	public void setTime(Date timeRes) {
		this.timeRes = timeRes;
	}
	
	@Column(name = "DATE_RES", nullable = true)
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return dateRes;
	}
	
	public void setDate(Date dateRes) {
		this.dateRes = dateRes;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ROLE", nullable = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Column(name = "ROLE", nullable = true)
	public String getDescRole() {
		return descRole;
	}

	public void setDescRole(String descRole) {
		this.descRole = descRole;
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