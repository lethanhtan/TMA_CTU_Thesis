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
@Table(name = "BOOK_TOUR_NEXT")
public class BookTourNext {
	private int idNext;
	private String cusName;
	private String cusSex;
	private String cusYearOfBirth;
	private String relationship;

	private BookTour bookTour;

	public BookTourNext() {
	}

	public BookTourNext(String cusName, String cusSex, String cusYearOfBirth, String relationship) {
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.cusYearOfBirth = cusYearOfBirth;
		this.relationship = relationship;
	}

	public BookTourNext(String cusName, String cusSex, String cusYearOfBirth, String relationship, BookTour bookTour) {
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.cusYearOfBirth = cusYearOfBirth;
		this.relationship = relationship;
		this.bookTour = bookTour;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_NEXT", unique = true, nullable = false)
	public int getIdNext() {
		return this.idNext;
	}

	public void setIdNext(int idNext) {
		this.idNext = idNext;
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
	@Column(name = "CUS_SEX", nullable = true, length = 3)
	public String getCusSex() {
		return this.cusSex;
	}

	public void setCusSex(String cusSex) {
		this.cusSex = cusSex;
	}

	// Create column Number of ticket
	@Column(name = "CUS_YEAROFBIRTH", length = 4)
	public String getCusYearOfBirth() {
		return this.cusYearOfBirth;
	}

	public void setCusYearOfBirth(String cusYearOfBirth) {
		this.cusYearOfBirth = cusYearOfBirth;
	}

	@Column(name = "RELATIONSHIP", length = 6)
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
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
}