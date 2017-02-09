/***********************************************************************
 * Module:  Tai_khoan.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Tai_khoan
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TAI_KHOAN", uniqueConstraints = { @UniqueConstraint(columnNames = {"MA_TK"}) })
public class Tai_khoan {
   private char ma_tk;
   private String loai_tk;

   /* Contructor for Tai_khoan */
   public Tai_khoan(char ma_tk, String loai_tk) {
	   this.ma_tk = ma_tk;
	   this.loai_tk = loai_tk;
   }
   @Id
   @Column
   public char getMaTk() {
      return ma_tk;
   }
   public void setMaTk(char ma_tk) {
	   this.ma_tk = ma_tk;
   }
   
   @Column
   public String getLoaiTk() {
      return loai_tk;
   }
   public void setLoaiTk(String loai_tk) {
	   this.loai_tk = loai_tk;
   }

}