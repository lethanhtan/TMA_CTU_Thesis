/***********************************************************************
 * Module:  Promotion.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Promotion
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PROMOTION", uniqueConstraints = { @UniqueConstraint(columnNames = {"ID_PRO"}) })
public class Promotion {
   private String idPro;
   private String namePro;
   private Integer costLev;
   
   @Id
   @Column(name = "ID_PRO", nullable = false)
   public String getIdPro() {
      return idPro;
   }
   
   public void setIdPro(String idPro) {
	   this.idPro = idPro;
   }
   
   @Column(name = "NAME_PRO", nullable = true)
   public String getNamePro() {
      return namePro;
   }
   
   public void setNamePro(String namePro) {
	   this.namePro = namePro;
   }
   
   @Column(name = "COST_LEV", nullable = true)
   public Integer getCostLev() {
      return costLev;
   }
   
   public void setCostLev(Integer costLev) {
	   this.costLev = costLev;
   }

}