/***********************************************************************
 * Module:  Dia_diem.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Dia_diem
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "DIA_DIEM", uniqueConstraints = { @UniqueConstraint(columnNames = { "MA_DD" }) })
public class Dia_diem {
   public char ma_dd;
   public String ten_dd;
   public String tinh_thanh;
   
   /* Contructor for Dia_diem */
   public Dia_diem(char ma_dd, String ten_dd, String tinh_thanh) {
	   this.ma_dd = ma_dd;
	   this.ten_dd = ten_dd;
	   this.tinh_thanh = tinh_thanh;
   }
   
   /* Setter and Getter medthod */
   @Id
   @Column(name = "MA_DD")
   public char getMaDD() {
      return ma_dd;
   }
   
   public void setMaDD(char ma_dd) {
	   this.ma_dd = ma_dd;
   }
   
   @Column(name ="TEN_DD")
   public String getTenDD() {
      return ten_dd;
   }
   
   public void setTenDD(String ten_dd) {
	   this.ten_dd = ten_dd;
   }
   
   @Column(name = "TINH_THANH")
   public String getTinhThanh() {
      return tinh_thanh;
   }
   
   public void setTinhThanh(String tinh_thanh) {
	   this.tinh_thanh = tinh_thanh;
   }

}