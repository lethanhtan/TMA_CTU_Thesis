/***********************************************************************
 * Module:  Customer.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Customer
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_CUS" }) })
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCus;
	private String nameCus;
	private String addressCus;
	private String emailCus;
	private Integer phoneCus;

	private Set<Account> account = new HashSet<Account>(0);

	public Customer() {
	};

	public Customer(Integer idCus) {
		this.idCus = idCus;
	}

	public Customer(Integer idCus, Set<Account> account) {
		this.idCus = idCus;
		this.account = account;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_CUS", nullable = false, unique = true, length = 10)
	public Integer getIdCus() {
		return idCus;
	}

	public void setIdCus(Integer idCus) {
		this.idCus = idCus;
	}

	@Column(name = "NAME_CUS", nullable = false, length = 60)
	public String getNameCus() {
		return nameCus;
	}

	public void setNameCus(String nameCus) {
		this.nameCus = nameCus;
	}

	@Column(name = "ADDRESS_CUS", nullable = true, length = 100)
	public String getAddressCus() {
		return addressCus;
	}

	public void setAddressCus(String addressCus) {
		this.addressCus = addressCus;
	}

	@Column(name = "PHONE_CUS", nullable = false)
	public Integer getPhoneCus() {
		return phoneCus;
	}

	public void setPhoneCus(Integer phoneCus) {
		this.phoneCus = phoneCus;
	}

	@Column(name = "EMAIL_CUS", nullable = true, length = 100)
	public String getEmailCus() {
		return emailCus;
	}

	public void setEmailCus(String emailCus) {
		this.emailCus = emailCus;
	}

	/*
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer" )
	public Set<Account> getAccount() {
		return this.account;
	}
	
	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	*/
}