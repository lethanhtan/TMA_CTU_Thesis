/***********************************************************************
 * Module:  Import.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Import
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "IMPORT", uniqueConstraints = { @UniqueConstraint(columnNames={"ID_IMP"}) })
public class Import {
   private String idImp;
   private String nameImp;
   private Date timeImp;
   
   @Id
   @Column(name = "ID_IMP", nullable = false)
   public String getIdImp() {
      return idImp;
   }
   
   public void setIdImp(String idImp) {
	   this.idImp = idImp;
   }
   
   @Column(name = "NAME_IMP", nullable = false)
   public String getNameImp() {
      return nameImp;
   }
   
   public void setNameImp(String nameImp) {
	   this.nameImp = nameImp;
   }
   
   @Column(name = "TIME_IMP", nullable = false)
   public Date getTimeImp() {
      return timeImp;
   }
   
   public void setTimeImp(Date timeImp) {
	   this.timeImp = timeImp;
   }
}