/***********************************************************************
 * Module:  Customer.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Customer
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = { @UniqueConstraint(columnNames = {"ID_CUS"}) })
public class Customer {
   private String idCus;
   private String nameCus;
   private String addressCus;
   private String emailCus;
   private Integer phoneCus;
   
   public java.util.Collection<Account> account;
   
   @Id
   @Column(name = "ID_CUS", nullable = false)
   public String getIdCus() {
      return idCus;
   }
   
   public void setIdCus(String idCus) {
	   this.idCus = idCus;
   }
   
   @Column(name = "NAME_CUS", nullable = false)
   public String getNameCus() {
      return nameCus;
   }
   
   public void setNameCus(String nameCus) {
	   this.nameCus = nameCus;
   }
   
   @Column(name = "ADDRESS_CUS", nullable = false)
   public String getAddressCus() {
      return addressCus;
   }
   
   public void setAddressCus(String addressCus) {
	   this.addressCus = addressCus;
   }
   
   @Column(name = "PHONE_CUS", nullable = false)
   public Integer getPhoneCus() {
      return phoneCus;
   }
   
   public void setPhoneCus(Integer phoneCus) {
	   this.phoneCus = phoneCus;
   }
   
   @Column(name = "EMAIL_CUS", nullable = true)
   public String getEmailCus() {
      return emailCus;
   }
   
   public void setEmailCus(String emailCus) {
	   this.emailCus = emailCus;
   }
}