/***********************************************************************
 * Module:  TourCancel.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class TourCancel
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TOUR_CANCEL", uniqueConstraints = { @UniqueConstraint(columnNames = {"ID_CAN"}) })
public class TourCancel {
   private String idTourCan;
   private Date timeCan;
   public Visitor owner;

   @Id
   @Column(name = "ID_TOUR_CAN", nullable = false)
   public String getIdCan() {
      return idTourCan;
   }
   
   public void setIdCan(String idTourCan) {
	   this.idTourCan = idTourCan;
   }
   
   @Column(name = "TIME_CAN", nullable = false)
   public Date getTimeCan() {
      return timeCan;
   }
   
   public void setTimeCan(Date timeCan) {
	   this.timeCan = timeCan;
   }
   
   public Visitor getOwnerTourCan() {
	   return owner;
   }

}