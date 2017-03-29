/*package edu.ctu.thesis.travelsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OTHER_BOOKTOURS")
public class OtherBookTours {
	private String cusName;
	private String cusSex;
	private String cusRelationship;
	private String cusYearOfBirth;
	private BookTour bookTour;

	public OtherBookTours() {
	}

	public OtherBookTours(String cusName, String cusSex, String cusRelationship, String cusYearOfBirth) {
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.cusRelationship = cusRelationship;
		this.cusYearOfBirth = cusYearOfBirth;
	}

	public OtherBookTours(String cusName, String cusSex, String cusRelationship, String cusYearOfBirth,
			BookTour bookTour) {
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.cusRelationship = cusRelationship;
		this.cusYearOfBirth = cusYearOfBirth;
		this.bookTour = bookTour;
	}

	// Create column customer name
	@Column(name = "CUS_NAME", nullable = true, length = 40)
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

	// Create column customer sex
	@Column(name = "CUS_RELATIONSHIP", nullable = true)
	public String getCusRelationship() {
		return this.cusRelationship;
	}

	public void setCusRelationship(String cusRelationship) {
		this.cusRelationship = cusRelationship;
	}

	// Create column customer sex
	@Column(name = "CUS_YEAROFBIRTH", nullable = true)
	public String getCusYearOfBirth() {
		return this.cusYearOfBirth;
	}

	public void setCusYearOfBirth(String cusYearOfBirth) {
		this.cusYearOfBirth = cusYearOfBirth;
	}

	// Join table Tour by column ID tour
		@ManyToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "ID_BT", nullable = true)
		public BookTour getBookTour() {
			return bookTour;
		}

		public void setBookTour(BookTour bookTour) {
			this.bookTour = bookTour;
		}

}*/