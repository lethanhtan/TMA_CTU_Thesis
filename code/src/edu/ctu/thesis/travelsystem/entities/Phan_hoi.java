/***********************************************************************
 * Module:  Phan_hoi.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Phan_hoi
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "PHAN_HOI", uniqueConstraints = { @UniqueConstraint(columnNames = {"MA_PH"}) })
public class Phan_hoi {
   public char ma_ph;
   public String ten_ph;
   public Date ngay_ph;
   
   /* Contructor for Phan_hoi */
   public Phan_hoi(char ma_ph, String ten_ph, Date ngay_ph) {
	   this.ma_ph = ma_ph;
	   this.ten_ph = ten_ph;
	   this.ngay_ph = ngay_ph;
   }
   
   @Id
   @Column
   public char getyMaPh() {
      return 0;
   }
   public void setMaPh(char ma_ph) {
	   this.ma_ph = ma_ph;
   }
   
   @Column
   public String getTenPh() {
	   return ten_ph;
   }
   public void setTenPh(String ten_ph) {
	   this.ten_ph = ten_ph;
   }
   
   @Column
   public Date getNgayPh() {
	   return ngay_ph;
   }
   public void setNgayPh(Date ngay_ph) {
	   this.ngay_ph = ngay_ph;
   }
}