/***********************************************************************
 * Module:  Khuyen_mai.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Khuyen_mai
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "KHUYEN_MAI", uniqueConstraints = { @UniqueConstraint(columnNames = { "MA_KM" }) })
public class Khuyen_mai {
   public char ma_km;
   public String ten_khuyen_mai;
   public byte muc_giam;
   
   /* Contructor for Khuyen_mai */
   public Khuyen_mai(char ma_km, String ten_khuyen_mai, byte muc_giam) {
	   this.ma_km = ma_km;
	   this.ten_khuyen_mai = ten_khuyen_mai;
	   this.muc_giam = muc_giam;
   }
   
   /* Setter and Getter method */
   @Id
   @Column
   public char getMaKM() {
      return ma_km;
   }
   public void setMaKM(char ma_km) {
	   this.ma_km = ma_km;
   }
   
   @Column
   public String getTenKM() {
      return ten_khuyen_mai;
   }
   public void setTenKM(String ten_khuyen_mai) {
	   this.ten_khuyen_mai = ten_khuyen_mai;
   }
   
   @Column
   public byte getMucGiam() {
      return muc_giam;
   }
   public void setMucGiam(byte muc_giam) {
	   this.muc_giam = muc_giam;
   }

}