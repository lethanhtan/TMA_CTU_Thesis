/***********************************************************************
 * Module:  Nguoi_dung.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Nguoi_dung
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "NGUOI_DUNG", uniqueConstraints = { @UniqueConstraint(columnNames = {"LOAI_ND"}) })
public class Nguoi_dung {
   private String loai_nd;
   
   public java.util.Collection<Phan_hoi> phan_hoi;
   public java.util.Collection<Tour> tour;
   public java.util.Collection<Tour_bi_huy> tour_bi_huy;
   public java.util.Collection<Ve_tour> ve_tour;
   public java.util.Collection<Tour_dang_ky> tour_dang_ky;
   
   /* Setter and Getter method */
   @Column
   public String getLoaiNd() {
      return loai_nd;
   }
   public void setLoaiNd(String loai_nd) {
	   this.loai_nd = loai_nd;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Phan_hoi> getPhan_hoi() {
      if (phan_hoi == null)
         phan_hoi = new java.util.HashSet<Phan_hoi>();
      return phan_hoi;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPhan_hoi() {
      if (phan_hoi == null)
         phan_hoi = new java.util.HashSet<Phan_hoi>();
      return phan_hoi.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPhan_hoi */
   public void setPhan_hoi(java.util.Collection<Phan_hoi> newPhan_hoi) {
      removeAllPhan_hoi();
      for (java.util.Iterator iter = newPhan_hoi.iterator(); iter.hasNext();)
         addPhan_hoi((Phan_hoi)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPhan_hoi */
   public void addPhan_hoi(Phan_hoi newPhan_hoi) {
      if (newPhan_hoi == null)
         return;
      if (this.phan_hoi == null)
         this.phan_hoi = new java.util.HashSet<Phan_hoi>();
      if (!this.phan_hoi.contains(newPhan_hoi))
         this.phan_hoi.add(newPhan_hoi);
   }
   
   /** @pdGenerated default remove
     * @param oldPhan_hoi */
   public void removePhan_hoi(Phan_hoi oldPhan_hoi) {
      if (oldPhan_hoi == null)
         return;
      if (this.phan_hoi != null)
         if (this.phan_hoi.contains(oldPhan_hoi))
            this.phan_hoi.remove(oldPhan_hoi);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPhan_hoi() {
      if (phan_hoi != null)
         phan_hoi.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Tour> getTour() {
      if (tour == null)
         tour = new java.util.HashSet<Tour>();
      return tour;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTour() {
      if (tour == null)
         tour = new java.util.HashSet<Tour>();
      return tour.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTour */
   public void setTour(java.util.Collection<Tour> newTour) {
      removeAllTour();
      for (java.util.Iterator iter = newTour.iterator(); iter.hasNext();)
         addTour((Tour)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTour */
   public void addTour(Tour newTour) {
      if (newTour == null)
         return;
      if (this.tour == null)
         this.tour = new java.util.HashSet<Tour>();
      if (!this.tour.contains(newTour))
         this.tour.add(newTour);
   }
   
   /** @pdGenerated default remove
     * @param oldTour */
   public void removeTour(Tour oldTour) {
      if (oldTour == null)
         return;
      if (this.tour != null)
         if (this.tour.contains(oldTour))
            this.tour.remove(oldTour);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTour() {
      if (tour != null)
         tour.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Tour_bi_huy> getTour_bi_huy() {
      if (tour_bi_huy == null)
         tour_bi_huy = new java.util.HashSet<Tour_bi_huy>();
      return tour_bi_huy;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTour_bi_huy() {
      if (tour_bi_huy == null)
         tour_bi_huy = new java.util.HashSet<Tour_bi_huy>();
      return tour_bi_huy.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTour_bi_huy */
   public void setTour_bi_huy(java.util.Collection<Tour_bi_huy> newTour_bi_huy) {
      removeAllTour_bi_huy();
      for (java.util.Iterator iter = newTour_bi_huy.iterator(); iter.hasNext();)
         addTour_bi_huy((Tour_bi_huy)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTour_bi_huy */
   public void addTour_bi_huy(Tour_bi_huy newTour_bi_huy) {
      if (newTour_bi_huy == null)
         return;
      if (this.tour_bi_huy == null)
         this.tour_bi_huy = new java.util.HashSet<Tour_bi_huy>();
      if (!this.tour_bi_huy.contains(newTour_bi_huy))
         this.tour_bi_huy.add(newTour_bi_huy);
   }
   
   /** @pdGenerated default remove
     * @param oldTour_bi_huy */
   public void removeTour_bi_huy(Tour_bi_huy oldTour_bi_huy) {
      if (oldTour_bi_huy == null)
         return;
      if (this.tour_bi_huy != null)
         if (this.tour_bi_huy.contains(oldTour_bi_huy))
            this.tour_bi_huy.remove(oldTour_bi_huy);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTour_bi_huy() {
      if (tour_bi_huy != null)
         tour_bi_huy.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Ve_tour> getVe_tour() {
      if (ve_tour == null)
         ve_tour = new java.util.HashSet<Ve_tour>();
      return ve_tour;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorVe_tour() {
      if (ve_tour == null)
         ve_tour = new java.util.HashSet<Ve_tour>();
      return ve_tour.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newVe_tour */
   public void setVe_tour(java.util.Collection<Ve_tour> newVe_tour) {
      removeAllVe_tour();
      for (java.util.Iterator iter = newVe_tour.iterator(); iter.hasNext();)
         addVe_tour((Ve_tour)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newVe_tour */
   public void addVe_tour(Ve_tour newVe_tour) {
      if (newVe_tour == null)
         return;
      if (this.ve_tour == null)
         this.ve_tour = new java.util.HashSet<Ve_tour>();
      if (!this.ve_tour.contains(newVe_tour))
         this.ve_tour.add(newVe_tour);
   }
   
   /** @pdGenerated default remove
     * @param oldVe_tour */
   public void removeVe_tour(Ve_tour oldVe_tour) {
      if (oldVe_tour == null)
         return;
      if (this.ve_tour != null)
         if (this.ve_tour.contains(oldVe_tour))
            this.ve_tour.remove(oldVe_tour);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllVe_tour() {
      if (ve_tour != null)
         ve_tour.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Tour_dang_ky> getTour_dang_ky() {
      if (tour_dang_ky == null)
         tour_dang_ky = new java.util.HashSet<Tour_dang_ky>();
      return tour_dang_ky;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTour_dang_ky() {
      if (tour_dang_ky == null)
         tour_dang_ky = new java.util.HashSet<Tour_dang_ky>();
      return tour_dang_ky.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTour_dang_ky */
   public void setTour_dang_ky(java.util.Collection<Tour_dang_ky> newTour_dang_ky) {
      removeAllTour_dang_ky();
      for (java.util.Iterator iter = newTour_dang_ky.iterator(); iter.hasNext();)
         addTour_dang_ky((Tour_dang_ky)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTour_dang_ky */
   public void addTour_dang_ky(Tour_dang_ky newTour_dang_ky) {
      if (newTour_dang_ky == null)
         return;
      if (this.tour_dang_ky == null)
         this.tour_dang_ky = new java.util.HashSet<Tour_dang_ky>();
      if (!this.tour_dang_ky.contains(newTour_dang_ky))
         this.tour_dang_ky.add(newTour_dang_ky);
   }
   
   /** @pdGenerated default remove
     * @param oldTour_dang_ky */
   public void removeTour_dang_ky(Tour_dang_ky oldTour_dang_ky) {
      if (oldTour_dang_ky == null)
         return;
      if (this.tour_dang_ky != null)
         if (this.tour_dang_ky.contains(oldTour_dang_ky))
            this.tour_dang_ky.remove(oldTour_dang_ky);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTour_dang_ky() {
      if (tour_dang_ky != null)
         tour_dang_ky.clear();
   }

}