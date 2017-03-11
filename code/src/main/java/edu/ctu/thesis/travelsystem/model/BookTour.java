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
@Table(name = "BOOK_TOUR", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_BT" }) })
public class BookTour {
	private String idBT;
	private String cusName;
	private String cusSex;
	private String cusEmail;
	private String cusPhone;
	private String cusAddress;
	private Tour tour;

	public BookTour() {
	}

	public BookTour(String cusName, String cusSex, String cusEmail, String cusPhone, String cusAddress) {
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.cusEmail = cusEmail;
		this.cusPhone = cusPhone;
		this.cusAddress = cusAddress;
	}

	public BookTour(String cusName, String cusSex, String cusEmail, String cusPhone, String cusAddress, Tour tour) {
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.cusEmail = cusEmail;
		this.cusPhone = cusPhone;
		this.cusAddress = cusAddress;
		this.tour = tour;
	}

	// Create column ID customer book tour
	@Id
	@Column(name = "ID_BT", unique = true, nullable = false)
	public String getIdBT() {
		return this.idBT;
	}

	public void setIdBT(String idBT) {
		this.idBT = idBT;
	}

	// Create column customer name
	@Column(name = "CUS_NAME", nullable = false, length = 40)
	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	// Create column customer sex
	@Column(name = "CUS_SEX", nullable = true)
	public String getCusSex() {
		return this.cusSex;
	}

	public void setCusSex(String cusSex) {
		this.cusSex = cusSex;
	}

	// Create column customer email
	@Column(name = "CUS_EMAIL", nullable = false, length = 50)
	public String getCusEmail() {
		return this.cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	// Create column customer phone
	@Column(name = "CUS_PHONE", nullable = false)
	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	// Create column customer address
	@Column(name = "CUS_ADDRESS", nullable = false, length = 100)

	public String getCusAddress() {
		return this.cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	// Join table Tour by column ID tour
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TOUR", nullable = true)
	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}
}
