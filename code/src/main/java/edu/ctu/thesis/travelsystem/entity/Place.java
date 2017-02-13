/***********************************************************************
 * Module:  Place.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Place
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PLACE", uniqueConstraints= { @UniqueConstraint(columnNames = {"ID_PLACE"}) })
public class Place {
   private String idPlace;
   private String namePlace;
   private String provincePlace;
   
   @Id
   @Column(name = "ID_PLACE", nullable = false)
   public String getIdPlace() {
      return idPlace;
   }
   
   public void setIdPlace(String idPlace) {
	   this.idPlace = idPlace;
   }
   
   @Column(name = "NAME_PLACE", nullable = false)
   public String getNamePlace() {
      return namePlace;
   }
   
   public void setNamePalce(String namePlace) {
	   this.namePlace = namePlace;
   }
   
   @Column(name = "PROVINCE_PLACE", nullable = false)
   public String getProvince() {
      return provincePlace;
   }
   
   public void setProvince(String provincePlace) {
	   this.provincePlace = provincePlace;
   }

}