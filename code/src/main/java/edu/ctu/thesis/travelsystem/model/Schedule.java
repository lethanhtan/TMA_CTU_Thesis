package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.CascadeType;

@Entity
@Table(name = "SCHEDULE")
public class Schedule implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String detailSchedule;
	
	private String sumary;
	
	private Tour tour;
	
	public Schedule() {
		this.detailSchedule = null;
		this.sumary = null;
	}
	
	@Column(name = "DETAIL", nullable = true, length = 5000)
	public String getDetailSchedule() {
		return this.detailSchedule;
	}
	
	public void setDetailSchedule(String detailSchedule) {
		this.detailSchedule = detailSchedule;
	}
	
	@Column(name = "SUMARY", nullable = true, length = 500)
	public String getSumary() {
		return this.sumary;
	}
	
	public void setSumary(String sumary) {
		this.sumary = sumary;
	}
	
	@Id
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TOUR", nullable = true)
	public Tour getTour() {
		return this.tour;
	}
	
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	
}
