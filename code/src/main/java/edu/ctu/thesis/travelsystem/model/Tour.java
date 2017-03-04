package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TOUR", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_TOUR" }) })
public class Tour {
	private String idTour;
	private String tourName;
	private String departureDate;
	private String departureTime;
	private String returnDate;
	private String returnTime;
	private Integer price;
	private Integer quantum;
	private String tourDetail;
	
	//Getters and Setters method
	
	//@GeneratedValue(strategy = IDENTITY)
	@Id
	@Column(name = "ID_TOUR", nullable = false, unique = true, length = 10)
	public String getIdTour() {
		return idTour;
	}

	public void setIdTour(String idTour) {
		this.idTour = idTour;
	}
	
	//Create column Tour name
	@Column(name = "TOUR_NAME", nullable = false, length = 50)
	public String getTourName() {
		return tourName;
	}
	
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	
	//Create column Departure date
	@Column(name = "DEPARTURE_DATE", nullable = false, length = 10)
	public String getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
	//Create column Departure time
	@Column(name = "DEPARTURE_TIME", nullable = false, length = 10)
	public String getDepartureTime() {
		return departureTime;
	}
	
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	//Create column Return date
	@Column(name = "RETURN_DATE", nullable = false, length = 10)
	public String getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	//Create column Return time
	@Column(name = "RETURN_TIME", nullable = false, length = 10)
	public String getReturnTime() {
		return returnTime;
	}
	
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	
	//Create column Price
	@Column(name = "PRICE", nullable = false)
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	//Create column Quantum
	@Column(name = "QUANTUM", nullable = false)
	public Integer getQuantum() {
		return quantum;
	}

	public void setQuantum(Integer quantum) {
		this.quantum = quantum;
	}
	
	//Create column Tour detail 
	@Column(name = "TOUR_DETAIL", nullable = false, length = 2000)
	public String getTourDetail() {
		return tourDetail;
	}
	
	public void setTourDetail(String tourDetail) {
		this.tourDetail = tourDetail;
	}
}