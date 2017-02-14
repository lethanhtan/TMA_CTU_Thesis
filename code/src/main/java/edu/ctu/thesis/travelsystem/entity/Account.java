/***********************************************************************
 * Module:  Account.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Account
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.SEQUENCE;;

@Entity
@Table(name = "ACCOUNT", uniqueConstraints = { @UniqueConstraint(columnNames = {"ID_ACC"}) })
public class Account {
   private Integer idAcc;
   private String emailAcc;
   private Date dateCreateAcc;
   private String passAcc;
   private Customer customer;
   
   public java.util.Collection<TourCancel> tourCancel;
   public java.util.Collection<TourRegister> tourRegister;
   public java.util.Collection<Ticket> ticket;
   
   public Account() {};
   
   public Account(Integer idAcc, Customer customer) {
	   this.idAcc = idAcc;
	   this.customer = customer;
   }
   
   public Account(String emailAcc, Date dateCreateAcc, String passAcc, Customer customer) {
	   this.emailAcc = emailAcc;
	   this.dateCreateAcc = dateCreateAcc;
	   this.passAcc = passAcc;
	   this.customer = customer;
   }
   
   @Id
   @Column(name = "ID_ACC", unique = true, nullable = false, length = 10)
   public Integer getIdAcc() {
      return idAcc;
   }
   
   public void setIdAcc(Integer idAcc) {
	   this.idAcc = idAcc;
   }
   
   @Column(name = "EMAIL_ACC", nullable = true, length = 100)
   public String getEmailAcc() {
      return emailAcc;
   }
   
   public void setEmailAcc(String emailAcc) {
	   this.emailAcc = emailAcc;
   }
   
   @Column(name = "DATE_CREATE_ACC", nullable = true)
   public Date getDateCreateAcc() {
      return dateCreateAcc;
   }
   
   public void setDateCreateAcc(Date dateCreateAcc) {
	   this.dateCreateAcc = dateCreateAcc;
   }
   
   @Column(name = "PASS_ACC", unique = true, nullable = false, length = 20)
   public String getPassAcc() {
      return passAcc;
   }
   
   public void setPassAcc(String passAcc) {
	   this.passAcc = passAcc;
   }
   /*
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "ID_CUS")
   public Customer getCustomer() {
	   return this.customer;
   }
   
   public void setCustomer(Customer customer) {
	   this.customer = customer;
   }
   */
}