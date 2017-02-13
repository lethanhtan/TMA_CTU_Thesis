/***********************************************************************
 * Module:  Import.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Import
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "IMPORT", uniqueConstraints = { @UniqueConstraint(columnNames = { "MA_IMPORT" }) })
public class Import {
   private char ma_import;
   private String ten_import;
   private Date ngay_import;
   
   /* Contructor for Gia_tour */
   public Import(char ma_import, String ten_import, Date ngay_import) {
	   this.ma_import = ma_import;
	   this.ten_import = ten_import;
	   this.ngay_import = ngay_import;
   }
   
   /* Setter and Getter method */
   @Id
   @Column
   public char getMaImport() {
      return ma_import;
   }
   public void setMaImport(char ma_import) {
	   this.ma_import = ma_import;
   }
   
   @Column
   public Date getNgayImport() {
      return ngay_import;
   }
   public void setNgayImport(Date ngay_import) {
	   this.ngay_import = ngay_import;
   }
   
   @Column
   public String getTenImport() {
      return ten_import;
   }
   public void setTenImport(String ten_import) {
	   this.ten_import = ten_import;
   }

}