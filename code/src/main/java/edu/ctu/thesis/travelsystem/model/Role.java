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

	private int id;

	private String description;

	// constructor
	public Role() {
	}

	public Role(String description) {
		this.description = description;
	}

	// Setters and Getter method
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_ROLE", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION", nullable = true, length = 40)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}