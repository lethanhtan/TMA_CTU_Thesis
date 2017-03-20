package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_ROLE", nullable = false)
	private int id;

	@Column(name = "DESCRIPTION", nullable = false, length = 40)
	private String description;

	// constructor
	public Role() {
	}

	public Role(String description) {
		this.description = description;
	}

	// Setters and Getter method
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}