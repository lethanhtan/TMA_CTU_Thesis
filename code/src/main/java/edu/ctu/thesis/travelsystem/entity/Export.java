/***********************************************************************
 * Module:  Export.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Export
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EXPORT", uniqueConstraints = { @UniqueConstraint(columnNames={"ID_EXP"}) })
public class Export {
   private String idExp;
   private String nameExp;
   private Date timeCreateExp;
   
   @Id
   @Column(name = "ID_EXP", nullable = false)
   public String getIdExp() {
      return idExp;
   }
   
   public void setIdExp(String idExp) {
	   this.idExp = idExp;
   }
   
   @Column(name = "NAME_EXP", nullable = false)
   public String getNameExp() {
      return nameExp;
   }
   
   public void setNameExp(String nameExp) {
	   this.nameExp = nameExp;
   }
   
   @Column(name = "TIME_EXP", nullable = false)
   public Date getTimeExp() {
      return timeCreateExp;
   }
   
   public void setTimeExp(Date timeCreateDate) {
	   this.timeCreateExp = timeCreateDate;
   }
}