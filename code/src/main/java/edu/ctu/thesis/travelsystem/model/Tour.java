package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TOUR")
public class Tour {
	private int idTour;
	private String name;
	private Date departureDate;
	private String departureTime;
	private Date returnDate;
	private String returnTime;
	private String price;
	private int quantum;
	private String detail;
	private String image;
	private Integer ticketAvailability;
	private Date dateAllowReg;
	private Date dateAllowCancel;
	private boolean fullOrNot;
	private boolean regOrNot = true;
	private boolean cancelOrNot = true;
	private boolean fieldName = true;
	private boolean fieldSex = true;
	private boolean fieldEmail = true;
	private boolean fieldPhone = true;
	private boolean fieldAddress = true;
	private boolean fieldIdCard = false;
	private boolean fieldNumOfTicket = true;
	private boolean fieldYearOfBirth = true;
	private int view;
	private Schedule schedule;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_TOUR", nullable = false)
	public int getIdTour() {
		return idTour;
	}

	public void setIdTour(int idTour) {
		this.idTour = idTour;
	}

	// Create column Tour name
	@Column(name = "NAME", nullable = false, length = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Create column Departure date
	@Column(name = "DEPARTURE_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	// Create column Departure time
	@Column(name = "DEPARTURE_TIME", nullable = false, length = 10)
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	// Create column Return date
	@Column(name = "RETURN_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	// Create column Return time
	@Column(name = "RETURN_TIME", nullable = false, length = 10)
	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	// Create column Price
	@Column(name = "PRICE", nullable = false)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	// Create column Quantum
	@Column(name = "QUANTUM", nullable = false)
	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}

	// Create column Tour detail
	@Column(name = "DETAIL", nullable = false, length = 2000)
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "IMAGE", nullable = true, length = 200)
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	// Create column Number ticket availability
	@Column(name = "TICKET_AVAILABILITY", nullable = false)
	public Integer getTicketAvailability() {
		return ticketAvailability;
	}

	public void setTicketAvailability(Integer ticketAvailability) {
		this.ticketAvailability = ticketAvailability;
	}

	// Create column Date allow register
	@Column(name = "DATE_ALLOW_REG", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateAllowReg() {
		return dateAllowReg;
	}

	public void setDateAllowReg(Date dateAllowReg) {
		this.dateAllowReg = dateAllowReg;
	}

	// Create column Date allow cancel
	@Column(name = "DATE_ALLOW_CANCEL", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateAllowCancel() {
		return dateAllowCancel;
	}

	public void setDateAllowCancel(Date dateAllowCancel) {
		this.dateAllowCancel = dateAllowCancel;
	}

	@Column(name = "FULL_OR_NOT", nullable = false)
	public boolean getFullOrNot() {
		return fullOrNot;
	}

	public void setFullOrNot(boolean fullOrNot) {
		this.fullOrNot = fullOrNot;
	}

	@Column(name = "REG_OR_NOT", nullable = false)
	public boolean getRegOrNot() {
		return regOrNot;
	}

	public void setRegOrNot(boolean regOrNot) {
		this.regOrNot = regOrNot;
	}

	@Column(name = "CANCEL_OR_NOT", nullable = false)
	public boolean getCancelOrNot() {
		return cancelOrNot;
	}

	public void setCancelOrNot(boolean cancelOrNot) {
		this.cancelOrNot = cancelOrNot;
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

	// Create column Field year of birth
	@Column(name = "FIELD_YEAROFBIRTH", nullable = false)
	public boolean getFieldYearOfBirth() {
		return fieldYearOfBirth;
	}

	public void setFieldYearOfBirth(boolean fieldYearOfBirth) {
		this.fieldYearOfBirth = fieldYearOfBirth;
	}

	@Column(name = "VIEW", nullable = false)
	public int getView() {
		return this.view;
	}

	public void setView(int view) {
		this.view = view;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "tour", cascade = CascadeType.ALL)
	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public int hashCode() {
		return idTour;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "Id = " + idTour;
	}

	@Override
	public boolean equals(Object tour) {
		if (tour == null || (tour.getClass() != this.getClass())) {
			return false;
		} else {
			return this.idTour == ((Tour) tour).getIdTour();
		}
	}
}