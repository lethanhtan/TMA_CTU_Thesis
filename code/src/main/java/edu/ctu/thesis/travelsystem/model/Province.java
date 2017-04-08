package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROVINCE")
public class Province {
	
	private int id;
	private String name;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", nullable = false, length = 3)
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "NAME", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
