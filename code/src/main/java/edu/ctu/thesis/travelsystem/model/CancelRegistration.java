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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CANCEL_REGISTRATION")
public class CancelRegistration {
	private int idCancel;
	private String cName;
	private String cSex;
	private String cEmail;
	private String cPhone;
	private String cAddress;
	private int cNoOfTicket;
	private String cIdCard;
	private Date dateCancel;
	private BookTour bookTour;

	public CancelRegistration() {
	}

	public CancelRegistration(String cName, String cSex, String cEmail, String cPhone, String cAddress,
			int cNoOfTicket, String cIdCard, Date dateCancel) {
		this.cName = cName;
		this.cSex = cSex;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.cAddress = cAddress;
		this.cNoOfTicket = cNoOfTicket;
		this.cIdCard = cIdCard;
		this.dateCancel = dateCancel;
	}

	public CancelRegistration(String cName, String cSex, String cEmail, String cPhone, String cAddress, int cNoOfTicket, String cIdCard, Date dateCancel,
			BookTour bookTour) {
		this.cName = cName;
		this.cSex = cSex;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.cAddress = cAddress;
		this.cNoOfTicket = cNoOfTicket;
		this.cIdCard = cIdCard;
		this.dateCancel = dateCancel;
		this.bookTour = bookTour;
	}

	// Create column customer name
	@Column(name = "C_NAME", nullable = false, length = 40)
	public String getCName() {
		return this.cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	// Create column customer sex
	@Column(name = "C_SEX", nullable = false)
	public String getCSex() {
		return this.cSex;
	}

	public void setCSex(String cSex) {
		this.cSex = cSex;
	}

	// Create column customer email
	@Column(name = "C_EMAIL", nullable = false, length = 50)
	public String getCEmail() {
		return this.cEmail;
	}

	public void setCEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	// Create column customer phone
	@Column(name = "C_PHONE", nullable = false)
	public String getCPhone() {
		return this.cPhone;
	}

	public void setCPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	// Create column customer address
	@Column(name = "C_ADDRESS", nullable = false, length = 100)
	public String getCAddress() {
		return this.cAddress;
	}

	public void setCAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	// Create column Number of ticket
	@Column(name = "C_NOOFTICKET", nullable = false)
	public int getCNoOfTicket() {
		return this.cNoOfTicket;
	}

	public void setCNoOfTicket(int cNoOfTicket) {
		this.cNoOfTicket = cNoOfTicket;
	}
	
	// Create column customer id card
		@Column(name = "C_IDCARD", nullable = false)
		public String getCIdCard() {
			return this.cIdCard;
		}

		public void setCIdCard(String cIdCard) {
			this.cIdCard = cIdCard;
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

	@Override
	public int hashCode() {
		return idCancel;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "Id = " + idCancel;
	}

	/*@Override
	public boolean equals(Object cancelReg) {
		if (cancelReg == null || (cancelReg.getClass() != this.getClass())) {
			return false;
		} else {
			return this.idCancel == ((CancelRegistration) cancelReg).getIdCancel();
		}
	}*/
}
