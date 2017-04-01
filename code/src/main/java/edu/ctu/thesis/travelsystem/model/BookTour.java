package edu.ctu.thesis.travelsystem.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "BOOK_TOUR")
public class BookTour {
	private int idBT;
	private String cusName;
	private String cusSex;
	private String cusEmail;
	private String cusPhone;
	private String cusAddress;
	private int cusNumOfTicket = 1;
	private String cusIdCard;
	private Date dateBook;
	private boolean cusCancel = false;
	private int ticketCancel = 0;
	private int idUser = 0;
	private boolean goneOrNot = false;
	private String cusName1;
	private String cusYearOfBirth1;
	private String cusName2;
	private String cusYearOfBirth2;
	private String cusName3;
	private String cusYearOfBirth3;
	private String confirmCode;

	private Tour tour;

	public BookTour() {
	}

	public BookTour(String cusName, String cusSex, String cusEmail, String cusPhone, String cusAddress,
			int cusNumOfTicket, String cusIdCard, Date dateBook, boolean cusCancel, int idUser, boolean goneOrNot) {
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.cusEmail = cusEmail;
		this.cusPhone = cusPhone;
		this.cusAddress = cusAddress;
		this.cusNumOfTicket = cusNumOfTicket;
		this.cusIdCard = cusIdCard;
		this.dateBook = dateBook;
		this.cusCancel = cusCancel;
		this.idUser = idUser;
		this.goneOrNot = goneOrNot;

	}

	public BookTour(String cusName, String cusSex, String cusEmail, String cusPhone, String cusAddress,
			int cusNumOfTicket, String cusIdCard, Date dateBook, boolean cusCancel, int idUser, boolean goneOrNot,
			Tour tour) {
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.cusEmail = cusEmail;
		this.cusPhone = cusPhone;
		this.cusAddress = cusAddress;
		this.cusNumOfTicket = cusNumOfTicket;
		this.cusIdCard = cusIdCard;
		this.dateBook = dateBook;
		this.cusCancel = cusCancel;
		this.idUser = idUser;
		this.goneOrNot = goneOrNot;
		this.tour = tour;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_BT", nullable = false)
	public int getIdBT() {
		return this.idBT;
	}

	public void setIdBT(int idBT) {
		this.idBT = idBT;
	}

	// Create column customer name
	@Column(name = "CUS_NAME", nullable = true, length = 40)
	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	// Create column customer sex
	@Column(name = "CUS_SEX", nullable = true)
	public String getCusSex() {
		return this.cusSex;
	}

	public void setCusSex(String cusSex) {
		this.cusSex = cusSex;
	}

	// Create column customer email
	@Column(name = "CUS_EMAIL", nullable = true, length = 50)
	public String getCusEmail() {
		return this.cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	// Create column customer phone
	@Column(name = "CUS_PHONE", nullable = true)
	public String getCusPhone() {
		return this.cusPhone;
	}

	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}

	// Create column customer address
	@Column(name = "CUS_ADDRESS", nullable = true, length = 100)
	public String getCusAddress() {
		return this.cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	// Create column Number of ticket
	@Column(name = "CUS_NUMOFTICKET", nullable = true)
	public int getCusNumOfTicket() {
		return this.cusNumOfTicket;
	}

	public void setCusNumOfTicket(int cusNumOfTicket) {
		this.cusNumOfTicket = cusNumOfTicket;
	}

	// Create column customer id card
	@Column(name = "CUS_IDCARD", nullable = true)
	public String getCusIdCard() {
		return this.cusIdCard;
	}

	public void setCusIdCard(String cusIdCard) {
		this.cusIdCard = cusIdCard;
	}

	// Create column Date book
	@Column(name = "DATE_BOOK", nullable = true)
	@Temporal(TemporalType.DATE)
	public Date getDateBook() {
		return this.dateBook;
	}

	public void setDateBook(Date dateBook) {
		this.dateBook = dateBook;
	}

	// Create column customer cancel book tour
	@Column(name = "CUS_CANCEL", nullable = true, length = 40)
	public boolean getCusCancel() {
		return this.cusCancel;
	}

	public void setCusCancel(boolean cusCancel) {
		this.cusCancel = cusCancel;
	}

	// Create column Number of ticket
	@Column(name = "TICKET_CANCEL")
	public int getTicketCancel() {
		return this.ticketCancel;
	}

	public void setTicketCancel(int ticketCancel) {
		this.ticketCancel = ticketCancel;
	}

	// Create column Id user
	@Column(name = "ID_USER", nullable = true)
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	// Create column tour gone

	@Column(name = "GONE_OR_NOT", nullable = true, length = 40)
	public boolean getGoneOrNot() {
		return this.goneOrNot;
	}

	public void setGoneOrNot(boolean goneOrNot) {
		this.goneOrNot = goneOrNot;
	}

	// Create column customer name
	@Column(name = "CUS_NAME1", nullable = true, length = 40)
	public String getCusName1() {
		return this.cusName1;
	}

	public void setCusName1(String cusName1) {
		this.cusName1 = cusName1;
	}

	// Create column customer name
	@Column(name = "CUS_NAME2", nullable = true, length = 40)
	public String getCusName2() {
		return this.cusName2;
	}

	public void setCusName2(String cusName2) {
		this.cusName2 = cusName2;
	}

	// Create column customer name
	@Column(name = "CUS_NAME3", nullable = true, length = 40)
	public String getCusName3() {
		return this.cusName3;
	}

	public void setCusName3(String cusName3) {
		this.cusName3 = cusName3;
	}

	// Create column customer year of birth
	@Column(name = "CUS_YEAROFBIRTH1", nullable = true, length = 40)
	public String getCusYearOfBirth1() {
		return this.cusYearOfBirth1;
	}

	public void setCusYearOfBirth1(String cusYearOfBirth1) {
		this.cusYearOfBirth1 = cusYearOfBirth1;
	}

	// Create column customer year of birth
	@Column(name = "CUS_YEAROFBIRTH2", nullable = true, length = 40)
	public String getCusYearOfBirth2() {
		return this.cusYearOfBirth2;
	}

	public void setCusYearOfBirth2(String cusYearOfBirth2) {
		this.cusYearOfBirth2 = cusYearOfBirth2;
	}

	// Create column customer year of birth
	@Column(name = "CUS_YEAROFBIRTH3", nullable = true, length = 40)
	public String getCusYearOfBirth3() {
		return this.cusYearOfBirth3;
	}

	public void setCusYearOfBirth3(String cusYearOfBirth3) {
		this.cusYearOfBirth3 = cusYearOfBirth3;
	}

	// CONFIRM_CODE column
	@Column(name = "CONFIRM_CODE", nullable = false, length = 40)
	public String getConfirmCode() {
		return this.confirmCode;
	}

	public void setConfirmCode(String confirmCode) {
		this.confirmCode = confirmCode;
	}

	// Join table Tour by column ID tour
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TOUR", nullable = true)
	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	@Override
	public int hashCode() {
		return idBT;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "Id = " + idBT;
	}

	@Override
	public boolean equals(Object bookTour) {
		if (bookTour == null || (bookTour.getClass() != this.getClass())) {
			return false;
		} else {
			return this.idBT == ((BookTour) bookTour).getIdBT();
		}
	}
}