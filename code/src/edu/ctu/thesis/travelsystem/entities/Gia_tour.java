/***********************************************************************
 * Module:  Gia_tour.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Gia_tour
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "GIA_TOUR", uniqueConstraints = { @UniqueConstraint(columnNames = { "GIA" }) })
public class Gia_tour {
   protected Date ngay_tao;
   protected Date ngay_chinh_sua;
   
   public double gia;
   
   /* Contructor for Gia_tour */
   public Gia_tour(double gia, Date ngay_tao, Date ngay_chinh_sua) {
	   this.gia = gia;
	   this.ngay_tao = ngay_tao;
	   this.ngay_chinh_sua = ngay_chinh_sua;
   }
   
   public double layGiaTour(char ma_tour) {
      return 0;
   }
   
   public java.util.Date layNgayTao(char ma_tour) {
      return null;
   }
   
   public java.util.Date layNgayCapNhat(char ma_tour) {
      return null;
   }

}