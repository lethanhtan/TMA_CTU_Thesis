/***********************************************************************
 * Module:  Manager.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Manager
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "MANAGER", uniqueConstraints = { @UniqueConstraint(columnNames = {"ID_MAN"}) })
public class Manager {
   private String idMan;
   private String nameMan;
   private String addressMan;
   private String emailMan;
   private Integer phoneMan;
   private String passAccMan;
   
   public java.util.Collection<Tour> tour;
   public java.util.Collection<Export> export;
   public java.util.Collection<Import> import_ob;
   public java.util.Collection<Account> account;
   
   @Id
   @Column(name = "ID_MAN", nullable = false)
   public String getIdMan() {
      return idMan;
   }
   
   public void setIdMan(String idMan) {
	   this.idMan = idMan;
   }
   
   @Column(name = "NAME_MAN", nullable = false)
   public String getNameMan() {
      return nameMan;
   }
   
   public void setNameMan(String nameMan) {
	   this.nameMan = nameMan;
   }
   
   @Column(name = "ADDRESS_MAN", nullable = true)
   public String getAddressMan() {
      return addressMan;
   }
   
   public void setAddressMan(String addressMan) {
	   this.addressMan = addressMan;
   }
   
   @Column(name = "EMAIL_MAN", nullable = true)
   public String getEmailMan() {
      return emailMan;
   }
   
   public void setEmailMan(String emailMan) {
	   this.emailMan = emailMan;
   }
   
   @Column(name = "PHONE_MAN", nullable = true)
   public Integer getPhoneMan() {
      return phoneMan;
   }
   
   public void setPhoneMan(Integer phoneMan) {
	   this.phoneMan = phoneMan;
   }
   
   @Column(name = "PASS_MAN", nullable = false)
   public String getPassAccMan() {
      return passAccMan;
   }
   
   public void setPassAccMan(String passAccMan) {
	   this.passAccMan = passAccMan;
   }
}