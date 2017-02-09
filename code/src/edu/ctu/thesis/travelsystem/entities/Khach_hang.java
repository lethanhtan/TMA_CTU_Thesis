/***********************************************************************
 * Module:  Khach_hang.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Khach_hang
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "KHACH_HANG", uniqueConstraints = { @UniqueConstraint(columnNames = { "MA_KH" }) })
public class Khach_hang extends Nguoi_dung {
   private char ma_kh;
   protected String dia_chi_kh;
   public String ten_kh;
   public String email_kh;
   
   public java.util.Collection<Tai_khoan> tai_khoan;

   /* Contructor for Khach_hang */
   public Khach_hang(char ma_kh, String dia_chi_kh, String ten_kh, String email_kh) {
	   this.ma_kh = ma_kh;
	   this.dia_chi_kh = dia_chi_kh;
	   this.ten_kh = ten_kh;
	   this.email_kh = email_kh;
   }
   
   /* Setter and Getter method */
   @Id
   @Column
   public char getMaKh() {
	   return ma_kh;
   }
   public void setMaKh(char ma_kh) {
	   this.ma_kh = ma_kh;
   }
   
   @Column
   public String getTenKh() {
	   return ten_kh;
   }
   public void setTenKh(String ten_kh) {
	   this.ten_kh = ten_kh;
   }
   
   @Column
   public String getDiaChiKh() {
	   return dia_chi_kh;
   }
   public void setDiaChiKh(String dia_chi_kh) {
	   this.dia_chi_kh = dia_chi_kh;
   }
   
   @Column
   public String getEmailKh() {
	   return email_kh;
   }
   public void setEmailKh(String email_kh) {
	   this.dia_chi_kh = email_kh;
   }
   
   public void taoPhanHoi() {
   }
   
   public void xemTour(char ma_tour) {
   }
   
   public void dkTour(char ma_tour) {
   }
   
   public void capNhatTk(char ma_tk) {
   }
   
   public void timKiemTour() {
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Tai_khoan> getTai_khoan() {
      if (tai_khoan == null)
         tai_khoan = new java.util.HashSet<Tai_khoan>();
      return tai_khoan;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTai_khoan() {
      if (tai_khoan == null)
         tai_khoan = new java.util.HashSet<Tai_khoan>();
      return tai_khoan.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTai_khoan */
   public void setTai_khoan(java.util.Collection<Tai_khoan> newTai_khoan) {
      removeAllTai_khoan();
      for (java.util.Iterator iter = newTai_khoan.iterator(); iter.hasNext();)
         addTai_khoan((Tai_khoan)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTai_khoan */
   public void addTai_khoan(Tai_khoan newTai_khoan) {
      if (newTai_khoan == null)
         return;
      if (this.tai_khoan == null)
         this.tai_khoan = new java.util.HashSet<Tai_khoan>();
      if (!this.tai_khoan.contains(newTai_khoan))
         this.tai_khoan.add(newTai_khoan);
   }
   
   /** @pdGenerated default remove
     * @param oldTai_khoan */
   public void removeTai_khoan(Tai_khoan oldTai_khoan) {
      if (oldTai_khoan == null)
         return;
      if (this.tai_khoan != null)
         if (this.tai_khoan.contains(oldTai_khoan))
            this.tai_khoan.remove(oldTai_khoan);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTai_khoan() {
      if (tai_khoan != null)
         tai_khoan.clear();
   }

}