/***********************************************************************
 * Module:  Tour_dang_ky.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Tour_dang_ky
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import java.util.*;

/** @pdOid a1baddf7-6ba3-4e6e-89f5-8508f501e6da */
public class Tour_dang_ky {
   /** @pdOid 531b20e4-6005-4751-87ab-a76375bbe2ad */
   private java.util.Date ngay_dang_ky;
   
   /** @pdRoleInfo migr=no name=Tour_bi_huy assc=Association_22 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<Tour_bi_huy> tour_bi_huy;
   
   /** @param ma_tour
    * @pdOid e7bd0016-4cc9-442b-b31a-16f5152ad0c9 */
   public java.util.Date layNgayDangKy(int ma_tour) {
      // TODO: implement
      return null;
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

}