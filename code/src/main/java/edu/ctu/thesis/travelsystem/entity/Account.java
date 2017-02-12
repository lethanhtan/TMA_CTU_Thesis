/***********************************************************************
 * Module:  Account.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Account
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ACCOUNT", uniqueConstraints = { @UniqueConstraint(columnNames = {"ID_ACC"}) })
public class Account {
   private String idAcc;
   private String ownerAcc;
   private String emailAcc;
   private Date dateCreateAcc;
   private String passAcc;
   
   public java.util.Collection<TourCancel> tourCancel;
   public java.util.Collection<TourRegister> tourRegister;
   public java.util.Collection<Ticket> ticket;
   
   @Id
   @Column(name = "ID_ACC")
   public String getIdAcc() {
      return idAcc;
   }
   
   public void setIdAcc(String idAcc) {
	   this.idAcc = idAcc;
   }
   
   @Column(name = "OWNER_ACC")
   public String getOwner() {
      return ownerAcc;
   }
   
   public void setOwner(String ownerAcc) {
	   this.ownerAcc = ownerAcc;
   }
   
   @Column(name = "EMAIL_ACC")
   public String getEmailAcc() {
      return emailAcc;
   }
   
   public void setEmailAcc(String emailAcc) {
	   this.emailAcc = emailAcc;
   }
   
   @Column(name = "DATE_CREATE_ACC")
   public Date getDateCreateAcc() {
      return dateCreateAcc;
   }
   
   public void setDateCreateAcc(Date dateCreateAcc) {
	   this.dateCreateAcc = dateCreateAcc;
   }
   
   @Column(name = "PASS_ACC")
   public String getPassAcc() {
      return passAcc;
   }
   
   public void setPassAcc(String passAcc) {
	   this.passAcc = passAcc;
   }
   
}