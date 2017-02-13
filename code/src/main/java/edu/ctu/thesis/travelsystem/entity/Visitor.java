/***********************************************************************
 * Module:  Vistor.java
 * Author:  rtrush
 * Purpose: Defines the Class Vistor
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "VISITOR", uniqueConstraints = { @UniqueConstraint(columnNames = {"NAME_VIS"}) })
public class Visitor {
   private String nameVis;
   private String addressVis;
   private Integer phoneVis;
   
   public java.util.Collection<Ticket> ticket;
   
   @Id
   @Column(name = "NAME_VIS", nullable = false)
   public String getNameVis() {
      return nameVis;
   }
   
   public void setNameVis(String nameVis) {
	   this.nameVis = nameVis;
   }
   
   @Column(name = "ADDRESS_VIS", nullable = true)
   public String getAddressVis() {
      return addressVis;
   }
   
   public void setAddressVis(String addressVis) {
	   this.addressVis = addressVis;
   }
   
   @Column(name = "PHONE_VIS", nullable = false)
   public Integer getPhoneVis() {
      return phoneVis;
   }
   
   public void setPhoneVis(Integer phoneVis) {
	   this.phoneVis = phoneVis;
   }
   
}