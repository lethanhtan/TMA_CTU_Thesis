package edu.ctu.thesis.travelsystem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "PROMOTION")
public class Promotion {
	
	private int id;
	
	private int percent;
	
	private Date fromDate;
	
	private Date toDate;
	
	private Date createDate;
	
	private Date createTime;
	
	private Tour tour;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PRO_ID", nullable = false, length = 3)
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Tour getTour() {
		return this.tour;
	}
	
	public void setTour(Tour tour) {
		this.tour = tour;
	}
}
