package edu.ctu.thesis.travelsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLE", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_ROLE"}) })
public class Role {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_ROLE", nullable = false)
	private Integer idRole;
	
	@Column(name = "NAME_ROLE", nullable = false, length = 40)
	private String nameRole;
	
	@OneToMany(mappedBy = "role")
	private Set<User> user = new HashSet<User>(0);
	
	//contructor
	public Role() {}
	
	public Role(String nameRole) {
		this.nameRole = nameRole;
	}
	
	public Role(String nameRole, Set<User> user) {
		this.nameRole = nameRole;
		this.user = user;
	}
	
	//Setters and Getter method
	
	public Integer getIdRole() {
		return idRole;
	}
	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}
	
	public String getNameRole() {
		return nameRole;
	}
	
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	
	public Set<User> getUser() {
		return this.user;
	}
	
	public void setUser(Set<User> user) {
		this.user = user;
	}
}
