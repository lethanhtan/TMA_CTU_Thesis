/***********************************************************************
 * Module:  Export.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Export
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "EXPORT", uniqueConstraints = { @UniqueConstraint(columnNames = { "MA_EXPORT" }) })
public class Export {
   public char ma_export;
   public String ten_export;
   public Date ngay_export;
   
   /* Contructor for Export */
   public Export(char ma_export, String ten_export, Date ngay_export) {
	   this.ma_export = ma_export;
	   this.ten_export = ten_export;
	   this.ngay_export = ngay_export;
   }
   
   /* Setter and Getter medthod */
   @Id
   @Column
   public char getMaExport() {
      return ma_export;
   }
   public void setMaExport(char ma_export) {
	   this.ma_export = ma_export;
   }
   
   @Column
   public Date getNgayExport() {
      return ngay_export;
   }
   public void setNgayExport(Date ngay_export) {
	   this.ngay_export = ngay_export;
   }
   
   @Column
   public String getTenExport() {
	   return ten_export;
   }
   public void setTenExport(String ten_export) {
      this.ten_export = ten_export;
   }

}