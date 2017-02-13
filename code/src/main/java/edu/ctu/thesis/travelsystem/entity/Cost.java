/***********************************************************************
 * Module:  Cost.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Cost
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "COST", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_COST"}) })
public class Cost {
   private String idCost;
   private Double costTour;
   
   @Id
   @Column(name = "ID_COST")
   public String getIdCost() {
      return idCost;
   }
   
   public void setIdCost(String idCost) {
	   this.idCost = idCost;
   }
   
   @Column(name = "COST_TOUR")
   public Double getCostTour() {
      return costTour;
   }
   
   public void setCostTour(Double costTour) {
	   this.costTour = costTour;
   }
}