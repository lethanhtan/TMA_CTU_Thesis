package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "EMAIL")
public class Email {

	private int id;
	
	private String email;
	
	private String password;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_EMAIL", nullable = false)
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "EMAIL", nullable = false, length = 200)
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "PASSWORD", nullable = false, length = 40)
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
