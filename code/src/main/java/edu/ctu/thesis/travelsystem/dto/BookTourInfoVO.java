package edu.ctu.thesis.travelsystem.dto;

public class BookTourInfoVO {
	private int idNext;
	private String cusName;
	private String cusSex;
	private String cusYearOfBirth;
	private String relationship;

	public int getIdNext() {
		return idNext;
	}

	public void setIdNext(int idNext) {
		this.idNext = idNext;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusSex() {
		return cusSex;
	}

	public void setCusSex(String cusSex) {
		this.cusSex = cusSex;
	}

	public String getCusYearOfBirth() {
		return cusYearOfBirth;
	}

	public void setCusYearOfBirth(String cusYearOfBirth) {
		this.cusYearOfBirth = cusYearOfBirth;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
}
