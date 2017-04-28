package edu.ctu.thesis.travelsystem.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PROMOTION")
public class Promotion implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int percent;
	private Date fromDate;
	private Date toDate;
	private Date createDate;
	private Date createTime;
	private Tour tour;
	
	public Promotion() {
		this.percent = 0;
		this.createDate = null;
		this.createTime = null;
		this.toDate = null;
		this.fromDate = null;
	}
	
	@Column(name = "PERCENT", nullable = false)
	public int getPercent() {
		return this.percent;
	}
	
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	@Column(name = "FROM_DATE")
	@Temporal(TemporalType.DATE)
	public Date getFromDate() {
		return this.fromDate;
	}
	
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	
	@Column(name = "TO_DATE")
	@Temporal(TemporalType.DATE)
	public Date getToDate() {
		return this.toDate;
	}
	
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.DATE)
	public Date getCreateDate() {
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "CRATE_TIME")
	@Temporal(TemporalType.TIME)
	public Date getCreateTime() {
		return this.createTime;
		
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TOUR", nullable = false)
	public Tour getTour() {
		return this.tour;
	}
	
	public void setTour(Tour tour) {
		this.tour = tour;
	}
}
