package edu.ctu.thesis.travelsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "REGISTRATION_INFO")
public class RegistrationInfo {
	private int idTour;
	private boolean fieldName = true;
	private boolean fieldSex = true;
	private boolean fieldEmail = true;
	private boolean fieldPhone = true;
	private boolean fieldAddress = true;
	private boolean fieldIdCard = true;
	private boolean fieldNumOfTicket = true;
	private Tour tour;
	//private RegistrationInfo regInfo;

	public RegistrationInfo() {
	}

	public RegistrationInfo(boolean fieldName, boolean fieldSex, boolean fieldEmail, boolean fieldPhone,
			boolean fieldAddress, boolean fieldIdCard, boolean fieldNumOfTicket) {
		this.fieldName = fieldName;
		this.fieldSex = fieldSex;
		this.fieldEmail = fieldEmail;
		this.fieldPhone = fieldPhone;
		this.fieldAddress = fieldAddress;
		this.fieldIdCard = fieldIdCard;
		this.fieldNumOfTicket = fieldNumOfTicket;
	}

	public RegistrationInfo(boolean fieldName, boolean fieldSex, boolean fieldEmail, boolean fieldPhone,
			boolean fieldAddress, boolean fieldIdCard, boolean fieldNumOfTicket, Tour tour) {
		this.fieldName = fieldName;
		this.fieldSex = fieldSex;
		this.fieldEmail = fieldEmail;
		this.fieldPhone = fieldPhone;
		this.fieldAddress = fieldAddress;
		this.fieldIdCard = fieldIdCard;
		this.fieldNumOfTicket = fieldNumOfTicket;
		this.tour = tour;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "tour"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID_TOUR", unique = true, nullable = false)
	public int getIdTour() {
		return this.idTour;
	}

	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}

	// Create column Field name
	@Column(name = "FIELD_NAME", nullable = false)
	public boolean getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(boolean fieldName) {
		this.fieldName = fieldName;
	}

	// Create column Field sex
	@Column(name = "FIELD_SEX", nullable = false)
	public boolean getFieldSex() {
		return this.fieldSex;
	}

	public void setFieldSex(boolean fieldSex) {
		this.fieldSex = fieldSex;
	}

	// Create column Field email
	@Column(name = "FIELD_EMAIL", nullable = false)
	public boolean getFieldEmail() {
		return this.fieldEmail;
	}

	public void setFieldEmail(boolean fieldEmail) {
		this.fieldEmail = fieldEmail;
	}

	// Create column Field phone
	@Column(name = "FIELD_PHONE", nullable = false)
	public boolean getFieldPhone() {
		return this.fieldPhone;
	}

	public void setFieldPhone(boolean fieldPhone) {
		this.fieldPhone = fieldPhone;
	}

	// Create column Field address
	@Column(name = "FIELD_ADDRESS", nullable = false)
	public boolean getFieldAddress() {
		return this.fieldAddress;
	}

	public void setFieldAddress(boolean fieldAddress) {
		this.fieldAddress = fieldAddress;
	}

	// Create column Field id card
	@Column(name = "FIELD_IDCARD", nullable = false)
	public boolean getFieldIdCard() {
		return this.fieldIdCard;
	}

	public void setFieldIdCard(boolean fieldIdCard) {
		this.fieldIdCard = fieldIdCard;
	}

	// Create column Field number of ticket
	@Column(name = "FIELD_NUMOFTICKET", nullable = false)
	public boolean getFieldNumOfTicket() {
		return this.fieldNumOfTicket;
	}

	public void setFieldNumOfTicket(boolean fieldNumOfTicket) {
		this.fieldNumOfTicket = fieldNumOfTicket;
	}

	// Join table TOUR by column ID_TOUR
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TOUR", nullable = true)
	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}
}
