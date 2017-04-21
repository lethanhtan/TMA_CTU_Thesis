package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;

@Entity
@Table(name = "SCHEDULE")
public class Schedule {
	
	private int id;
	
	private String detail;
	
	private String sumary;
	
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
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TOUR", nullable = true)
	public Tour getTour() {
		return this.tour;
	}
	
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	
}
