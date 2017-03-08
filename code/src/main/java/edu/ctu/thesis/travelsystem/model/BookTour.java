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

//@Entity
@Table(name = "BOOK_TOUR", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_TOUR" }) })
public class BookTour {
	private String customerName;
	private String customerSex;
	private String customerEmail;
	private String customerPhone;
	private String customerAddress;
	private Tour tour;

	//
	public BookTour() {
	}

	public BookTour(String customerName, String customerSex, String customerEmail, String customerPhone,
			String customerAddress) {
		this.customerName = customerName;
		this.customerSex = customerSex;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
	}
	
	public BookTour(String customerName, String customerSex, String customerEmail, String customerPhone,
			String customerAddress, Tour tour) {
		this.customerName = customerName;
		this.customerSex = customerSex;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.tour = tour;
	}

	// Getters and Setters method
	// Create column Customer name
	@Id
	@Column(name = "CUSTOMER_NAME", nullable = false, unique = true, length = 40)
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	// Create column Customer sex
	@Column(name = "CUSTOMER_SEX", nullable = true)
	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	// Create column Customer email
	@Column(name = "CUSTOMER_EMAIL", nullable = false, length = 50)
	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	// Create column Customer phone
	@Column(name = "CUSTOMER_PHONE", nullable = false)
	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	// Create column Customer address
	@Column(name = "CUSTOMER_ADDRESS", nullable = false, length = 10)
	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress= customerAddress;
	}
	/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TOUR", nullable = false, insertable=false, updatable=false)

	public Tour getTour() {
		return tour;
	}
	
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	*/
}