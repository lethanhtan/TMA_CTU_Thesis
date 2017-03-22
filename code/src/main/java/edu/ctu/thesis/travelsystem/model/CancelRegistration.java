package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CANCEL_REGISTRATION")
public class CancelRegistration {
	private int idBT;
	private String cName;
	private String cSex;
	private String cEmail;
	private String cPhone;
	private String cAddress;
	private int cNumOfTicket;
	private Date dateCancel;
	private BookTour bookTour;

	public CancelRegistration() {
	}

	public CancelRegistration(String cName, String cSex, String cEmail, String cPhone, String cAddress,
			int cNumOfTicket, Date dateCancel) {
		this.cName = cName;
		this.cSex = cSex;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.cAddress = cAddress;
		this.cNumOfTicket = cNumOfTicket;
		this.dateCancel = dateCancel;
	}

	public CancelRegistration(String cName, String cSex, String cEmail, String cPhone, String cAddress,
			int cNumOfTicket, Date dateCancel, BookTour bookTour) {
		this.cName = cName;
		this.cSex = cSex;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.cAddress = cAddress;
		this.cNumOfTicket = cNumOfTicket;
		this.dateCancel = dateCancel;
		this.bookTour = bookTour;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "book_tour"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID_BT", unique = true, nullable = false)
	public int getIdBT() {
		return this.idBT;
	}

	public void setIdBT(int idBT) {
		this.idBT = idBT;
	}

	// Create column customer name
	@Column(name = "C_NAME", nullable = false, length = 40)
	public String getcName() {
		return this.cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	// Create column customer sex
	@Column(name = "C_SEX", nullable = false)
	public String getcSex() {
		return this.cSex;
	}

	public void setcSex(String cSex) {
		this.cSex = cSex;
	}

	// Create column customer email
	@Column(name = "C_EMAIL", nullable = false, length = 50)
	public String getcEmail() {
		return this.cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	// Create column customer phone
	@Column(name = "C_PHONE", nullable = false)
	public String getcPhone() {
		return this.cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	// Create column customer address
	@Column(name = "C_ADDRESS", nullable = false, length = 100)
	public String getcAddress() {
		return this.cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	// Create column Number of ticket
	@Column(name = "C_NUMOFTICKET", nullable = false)
	public int getcNumOfTicket() {
		return this.cNumOfTicket;
	}

	public void setcNumOfTicket(int cNumOfTicket) {
		this.cNumOfTicket = cNumOfTicket;
	}

	// Create column Date book
	@Column(name = "DATE_CANCEL", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDateCancel() {
		return this.dateCancel;
	}

	public void setDateCancel(LocalDate dateCancel) {
		this.dateCancel = Date.from(dateCancel.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	// Join table BOOKTOUR by column ID_BT
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_BT", nullable = true)
	public BookTour getBookTour() {
		return bookTour;
	}

	public void setBookTour(BookTour bookTour) {
		this.bookTour = bookTour;
	}
}
