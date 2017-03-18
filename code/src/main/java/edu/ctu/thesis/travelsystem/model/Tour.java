package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TOUR")
public class Tour {
	private Integer idTour;
	private String name;
	private Date departureDate;
	private String departureTime;
	private Date returnDate;
	private String returnTime;
	private String price;
	private Integer quantum;
	private String detail;
	private String image;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_TOUR", nullable = false)
	public Integer getIdTour() {
		return idTour;
	}

	public void setIdTour(Integer idTour) {
		this.idTour = idTour;
	}

	// Create column Tour name
	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Create column Departure date
	@Column(name = "DEPARTURE_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	// Create column Departure time
	@Column(name = "DEPARTURE_TIME", nullable = false, length = 10)
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	// Create column Return date
	@Column(name = "RETURN_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	// Create column Return time
	@Column(name = "RETURN_TIME", nullable = false, length = 10)
	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	// Create column Price
	@Column(name = "PRICE", nullable = false)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	// Create column Quantum
	@Column(name = "QUANTUM", nullable = false)
	public Integer getQuantum() {
		return quantum;
	}

	public void setQuantum(Integer quantum) {
		this.quantum = quantum;
	}

	// Create column Tour detail
	@Column(name = "DETAIL", nullable = false, length = 2000)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Column(name = "IMAGE", nullable = true, length = 200)
	public String getImage() {
		return this.image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "Id = " + idTour;
	}

	@Override
	public boolean equals(Object tour) {
		if (tour == null || (tour.getClass() != this.getClass())) {
			return false;
		} else {
			return true;
		}
	}
}