/***********************************************************************
 * Module:  Tour.java
 * Author:  Le Nhu Y
 * Purpose: Defines the Class Tour
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entities;

import java.util.*;

/** @pdOid 1e6750b2-db9f-463c-a72b-4b7568a7d49b */
public class Tour {
   /** @pdOid 7da5e01e-678e-46df-9aaa-a1097f41f12f */
   public char ma_tour;
   /** @pdOid 83eb4344-4089-404d-bb68-c77fec749b1b */
   public String loai_tour;
   /** @pdOid ead44260-ed57-42a7-aeae-47ee542b12f8 */
   public String ten_tour;
   
   /** @pdRoleInfo migr=no name=Gia_tour assc=Association_11 coll=java.util.Collection impl=java.util.HashSet mult=1..* type=Aggregation */
   public java.util.Collection<Gia_tour> gia_tour;
   /** @pdRoleInfo migr=no name=Dia_diem assc=Association_9 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Dia_diem> dia_diem;
   /** @pdRoleInfo migr=no name=Tour_bi_huy assc=Association_2 coll=java.util.Collection impl=java.util.HashSet mult=1..1 type=Composition */
   public Tour_bi_huy tour_bi_huy;
   /** @pdRoleInfo migr=no name=Ve_tour assc=Association_12 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Ve_tour> ve_tour;
   /** @pdRoleInfo migr=no name=Khuyen_mai assc=Association_17 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Khuyen_mai> khuyen_mai;
   /** @pdRoleInfo migr=no name=Tour_dang_ky assc=Association_21 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<Tour_dang_ky> tour_dang_ky;
   
   /** @pdOid 4f39ff65-d218-4db8-8528-c4c83817d599 */
   public char layMaTour() {
      // TODO: implement
      return 0;
   }
   
   /** @param ma_tour
    * @pdOid 8fb40841-fdac-41a1-82f9-6af3ea4ee7bd */
   public String layTenTour(char ma_tour) {
      // TODO: implement
      return null;
   }
   
   /** @param ma_tour
    * @pdOid 07b4919f-d5cd-4d79-947b-e73255e3414f */
   public String layLoaiTour(char ma_tour) {
      // TODO: implement
      return null;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Gia_tour> getGia_tour() {
      if (gia_tour == null)
         gia_tour = new java.util.HashSet<Gia_tour>();
      return gia_tour;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorGia_tour() {
      if (gia_tour == null)
         gia_tour = new java.util.HashSet<Gia_tour>();
      return gia_tour.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newGia_tour */
   public void setGia_tour(java.util.Collection<Gia_tour> newGia_tour) {
      removeAllGia_tour();
      for (java.util.Iterator iter = newGia_tour.iterator(); iter.hasNext();)
         addGia_tour((Gia_tour)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGia_tour */
   public void addGia_tour(Gia_tour newGia_tour) {
      if (newGia_tour == null)
         return;
      if (this.gia_tour == null)
         this.gia_tour = new java.util.HashSet<Gia_tour>();
      if (!this.gia_tour.contains(newGia_tour))
         this.gia_tour.add(newGia_tour);
   }
   
   /** @pdGenerated default remove
     * @param oldGia_tour */
   public void removeGia_tour(Gia_tour oldGia_tour) {
      if (oldGia_tour == null)
         return;
      if (this.gia_tour != null)
         if (this.gia_tour.contains(oldGia_tour))
            this.gia_tour.remove(oldGia_tour);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllGia_tour() {
      if (gia_tour != null)
         gia_tour.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Dia_diem> getDia_diem() {
      if (dia_diem == null)
         dia_diem = new java.util.HashSet<Dia_diem>();
      return dia_diem;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDia_diem() {
      if (dia_diem == null)
         dia_diem = new java.util.HashSet<Dia_diem>();
      return dia_diem.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDia_diem */
   public void setDia_diem(java.util.Collection<Dia_diem> newDia_diem) {
      removeAllDia_diem();
      for (java.util.Iterator iter = newDia_diem.iterator(); iter.hasNext();)
         addDia_diem((Dia_diem)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDia_diem */
   public void addDia_diem(Dia_diem newDia_diem) {
      if (newDia_diem == null)
         return;
      if (this.dia_diem == null)
         this.dia_diem = new java.util.HashSet<Dia_diem>();
      if (!this.dia_diem.contains(newDia_diem))
         this.dia_diem.add(newDia_diem);
   }
   
   /** @pdGenerated default remove
     * @param oldDia_diem */
   public void removeDia_diem(Dia_diem oldDia_diem) {
      if (oldDia_diem == null)
         return;
      if (this.dia_diem != null)
         if (this.dia_diem.contains(oldDia_diem))
            this.dia_diem.remove(oldDia_diem);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDia_diem() {
      if (dia_diem != null)
         dia_diem.clear();
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
   public java.util.Collection<Khuyen_mai> getKhuyen_mai() {
      if (khuyen_mai == null)
         khuyen_mai = new java.util.HashSet<Khuyen_mai>();
      return khuyen_mai;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorKhuyen_mai() {
      if (khuyen_mai == null)
         khuyen_mai = new java.util.HashSet<Khuyen_mai>();
      return khuyen_mai.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKhuyen_mai */
   public void setKhuyen_mai(java.util.Collection<Khuyen_mai> newKhuyen_mai) {
      removeAllKhuyen_mai();
      for (java.util.Iterator iter = newKhuyen_mai.iterator(); iter.hasNext();)
         addKhuyen_mai((Khuyen_mai)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newKhuyen_mai */
   public void addKhuyen_mai(Khuyen_mai newKhuyen_mai) {
      if (newKhuyen_mai == null)
         return;
      if (this.khuyen_mai == null)
         this.khuyen_mai = new java.util.HashSet<Khuyen_mai>();
      if (!this.khuyen_mai.contains(newKhuyen_mai))
         this.khuyen_mai.add(newKhuyen_mai);
   }
   
   /** @pdGenerated default remove
     * @param oldKhuyen_mai */
   public void removeKhuyen_mai(Khuyen_mai oldKhuyen_mai) {
      if (oldKhuyen_mai == null)
         return;
      if (this.khuyen_mai != null)
         if (this.khuyen_mai.contains(oldKhuyen_mai))
            this.khuyen_mai.remove(oldKhuyen_mai);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllKhuyen_mai() {
      if (khuyen_mai != null)
         khuyen_mai.clear();
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