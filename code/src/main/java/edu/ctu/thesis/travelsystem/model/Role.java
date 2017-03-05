package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ROLE", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"}) })
public class Role {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", nullable = false)
	private Integer id;
	
	@Column(name = "DESCRIPTION", nullable = false, length = 40)
	private String description;
	
	//constructor
	public Role() {}
	
	public Role(String description) {
		this.description = description;
	}
	//Setters and Getter method
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id= id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}