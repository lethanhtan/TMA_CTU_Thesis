package edu.ctu.thesis.travelsystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IMPORT")
public class Import {
	private Integer id;
	private String owner;
	private Date date;
	private Date time;
	private String fileType;
	private String importType;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", nullable = false)
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "OWNER", nullable = false, length = 100)
	public String getOwner() {
		return this.owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	@Column(name = "DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "TIME", nullable = false)
	@Temporal(TemporalType.TIME)
	public Date getTime() {
		return this.time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	@Column(name = "FILE_TYPE", nullable = false, length = 40)
	public String getFileType() {
		return this.fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	@Column(name = "IMPORT_TYPE", nullable = false, length = 80)
	public String getImportType() {
		return this.importType;
	}
	public void setImportType(String importType) {
		this.importType = importType;
	}
}
