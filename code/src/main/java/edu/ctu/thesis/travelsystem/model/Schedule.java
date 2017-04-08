package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "SCHEDULE")
public class Schedule {
	
	private int id;
	
	private String detail;
	
	private String sumary;
	
	private int idTour;
	
	private Tour tour;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_SCHEDULE", nullable = false)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "DETAIL", nullable = true, length = 5000)
	public String getDetail() {
		return this.detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Column(name = "SUMARY", nullable = true, length = 500)
	public String getSumary() {
		return this.sumary;
	}
	
	public void setSumary(String sumary) {
		this.sumary = sumary;
	}
	
	@Column(name = "ID_TOUR", nullable = false)
	public int getIdTour() {
		return this.idTour;
	}
	
	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Tour getTour() {
		return this.tour;
	}
	
	public void setTour(Tour tour) {
		this.tour = tour;
	}
}
