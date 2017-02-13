/***********************************************************************
 * Module:  Tour.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Tour
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TOUR", uniqueConstraints = { @UniqueConstraint(columnNames = {"ID_TOUR"}) })
public class Tour {
   private String idTour;
   private String nameTour;
   private String describeTour;
   private String schedule;
   
   public java.util.Collection<Promotion> promotion;
   public java.util.Collection<Feedback> feedback;
   public java.util.Collection<Place> place;
   public java.util.Collection<Cost> cost;
   public java.util.Collection<Ticket> ticket;
   public java.util.Collection<TourCancel> tourCancel;
   public java.util.Collection<TourRegister> tourRegister;
   
   @Id
   @Column(name = "ID_TOUR", nullable = false)
   public String getIdTour() {
      return idTour;
   }
   
   public void setIdTour(String idTour) {
	   this.idTour = idTour;
   }
   
   @Column(name = "NAME_TOUR", nullable = false)
   public String getNameTour() {
      return nameTour;
   }
   
   public void setNameTour(String nameTour) {
	   this.nameTour = nameTour;
   }
   
   @Column(name = "DESCRIBE_TOUR", nullable = false)
   public String getDescribeTour() {
      return describeTour;
   }
   
   public void setDescribeTour(String describeTour) {
	   this.describeTour = describeTour;
   }
   
   @Column(name = "SCHEDULE", nullable = false)
   public String getSchedule() {
      return schedule;
   }
   
   public void setSchedule(String schedule) {
	   this.schedule = schedule;
   }
}