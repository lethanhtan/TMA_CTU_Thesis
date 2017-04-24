package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RELATIONSHIP")
public class Relationship {
	private int id;
	private String name;

	public Relationship() {
	}

	public Relationship(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Create column relationship name
	@Column(name = "NAME", nullable = true, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "Id = " + id;
	}

	@Override
	public boolean equals(Object relationship) {
		if (relationship == null || (relationship.getClass() != this.getClass())) {
			return false;
		} else {
			return this.id == ((Relationship) relationship).getId();
		}
	}
}