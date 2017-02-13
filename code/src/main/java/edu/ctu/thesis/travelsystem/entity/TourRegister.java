/***********************************************************************
 * Module:  TourRegister.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class TourRegister
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TOUR_REGISTER", uniqueConstraints = { @UniqueConstraint(columnNames = {"ID_TOUR_RES"}) })
public class TourRegister {
   private String idTourRes;
   private Date timeRes;
   
   public TourCancel tourCancel;
   public Visitor owner;
   
   @Id
   @Column(name = "ID_TOUR_RES", nullable = false)
   public String getIdRes() {
      return idTourRes;
   }
   
   public void setIdRes(String idTourRes) {
	   this.idTourRes = idTourRes;
   }
   
   @Column(name = "TIME_RES", nullable = false)
   public Date getTimeRes() {
      return timeRes;
   }
   
   public void setTimRes(Date timeRes) {
	   this.timeRes = timeRes;
   }

}