/***********************************************************************
 * Module:  Account.java
 * Author:  rtrush
 * Purpose: Defines the Class Account
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

/** @pdOid b5c1ffea-647e-45e5-9d92-03358b050cbc */
public class Account {
   /** @pdOid 13542858-b2ef-405c-8303-96d180380d9c */
   private String idAcc;
   /** @pdOid d1b0d5d0-1b89-4d85-960b-135f2bb63afa */
   private String ownerAcc;
   /** @pdOid 9220f2a5-1b30-455d-8862-9a95c06432af */
   private String emailAcc;
   /** @pdOid 51d30bb9-ec28-45dc-adff-22e2f83a7ae6 */
   private Date dateCreateAcc;
   /** @pdOid 527fe4fd-d7a2-48a9-a53e-aba753d2fc17 */
   private String passAcc;
   
   /** @pdRoleInfo migr=no name=TourCancel assc=association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TourCancel> tourCancel;
   /** @pdRoleInfo migr=no name=TourRegister assc=association16 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<TourRegister> tourRegister;
   /** @pdRoleInfo migr=no name=Ticket assc=association20 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Ticket> ticket;
   
   /** @pdOid b700c640-4d21-4080-a812-d103792174d4 */
   public String getIdAcc() {
      // TODO: implement
      return idAcc;
   }
   
   /** @pdOid a1789d40-fa65-47e8-964b-b337ec340a13 */
   public void setIdAcc(String idAcc) {
      // TODO: implement
	   this.idAcc = idAcc;
   }
   
   /** @pdOid 2eef4d6f-daab-42f1-8f20-c8a5fc51a05d */
   public String getOwner() {
      // TODO: implement
      return ownerAcc;
   }
   
   /** @pdOid b45b9450-ad2b-4504-bb58-4d1eac0e8116 */
   public void setOwner(String ownerAcc) {
      // TODO: implement
	   this.ownerAcc = ownerAcc;
   }
   
   /** @pdOid 05672aee-e789-46d4-9b11-bb1f140f6861 */
   public String getEmailAcc() {
      // TODO: implement
      return emailAcc;
   }
   
   /** @pdOid 35afe51d-46ff-4bdd-8bfe-7c804306c3a3 */
   public void setEmailAcc(String emailAcc) {
      // TODO: implement
	   this.emailAcc = emailAcc;
   }
   
   /** @pdOid f0f3dc60-46f6-4802-9ac8-2ce7e520ffeb */
   public Date getDateCreateAcc() {
      // TODO: implement
      return dateCreateAcc;
   }
   
   /** @pdOid 9415c694-bf5f-48f4-a736-344419e1dcb7 */
   public void setDateCreateAcc(Date dateCreateAcc) {
      // TODO: implement
	   this.dateCreateAcc = dateCreateAcc;
   }
   
   /** @pdOid 2483193a-a8c5-48cd-97d0-248bf022a483 */
   public String getPassAcc() {
      // TODO: implement
      return passAcc;
   }
   
   /** @pdOid 763f1e83-eb5c-4847-8f08-fc8194285b68 */
   public void setPassAcc(String passAcc) {
      // TODO: implement
	   this.passAcc = passAcc;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<TourCancel> getTourCancel() {
      if (tourCancel == null)
         tourCancel = new java.util.HashSet<TourCancel>();
      return tourCancel;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<TourCancel> getIteratorTourCancel() {
      if (tourCancel == null)
         tourCancel = new java.util.HashSet<TourCancel>();
      return tourCancel.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTourCancel */
   public void setTourCancel(java.util.Collection<TourCancel> newTourCancel) {
      removeAllTourCancel();
      for (java.util.Iterator<TourCancel> iter = newTourCancel.iterator(); iter.hasNext();)
         addTourCancel(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTourCancel */
   public void addTourCancel(TourCancel newTourCancel) {
      if (newTourCancel == null)
         return;
      if (this.tourCancel == null)
         this.tourCancel = new java.util.HashSet<TourCancel>();
      if (!this.tourCancel.contains(newTourCancel))
         this.tourCancel.add(newTourCancel);
   }
   
   /** @pdGenerated default remove
     * @param oldTourCancel */
   public void removeTourCancel(TourCancel oldTourCancel) {
      if (oldTourCancel == null)
         return;
      if (this.tourCancel != null)
         if (this.tourCancel.contains(oldTourCancel))
            this.tourCancel.remove(oldTourCancel);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTourCancel() {
      if (tourCancel != null)
         tourCancel.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<TourRegister> getTourRegister() {
      if (tourRegister == null)
         tourRegister = new java.util.HashSet<TourRegister>();
      return tourRegister;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<TourRegister> getIteratorTourRegister() {
      if (tourRegister == null)
         tourRegister = new java.util.HashSet<TourRegister>();
      return tourRegister.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTourRegister */
   public void setTourRegister(java.util.Collection<TourRegister> newTourRegister) {
      removeAllTourRegister();
      for (java.util.Iterator<TourRegister> iter = newTourRegister.iterator(); iter.hasNext();)
         addTourRegister(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTourRegister */
   public void addTourRegister(TourRegister newTourRegister) {
      if (newTourRegister == null)
         return;
      if (this.tourRegister == null)
         this.tourRegister = new java.util.HashSet<TourRegister>();
      if (!this.tourRegister.contains(newTourRegister))
         this.tourRegister.add(newTourRegister);
   }
   
   /** @pdGenerated default remove
     * @param oldTourRegister */
   public void removeTourRegister(TourRegister oldTourRegister) {
      if (oldTourRegister == null)
         return;
      if (this.tourRegister != null)
         if (this.tourRegister.contains(oldTourRegister))
            this.tourRegister.remove(oldTourRegister);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTourRegister() {
      if (tourRegister != null)
         tourRegister.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Ticket> getTicket() {
      if (ticket == null)
         ticket = new java.util.HashSet<Ticket>();
      return ticket;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Ticket> getIteratorTicket() {
      if (ticket == null)
         ticket = new java.util.HashSet<Ticket>();
      return ticket.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTicket */
   public void setTicket(java.util.Collection<Ticket> newTicket) {
      removeAllTicket();
      for (java.util.Iterator<Ticket> iter = newTicket.iterator(); iter.hasNext();)
         addTicket(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newTicket */
   public void addTicket(Ticket newTicket) {
      if (newTicket == null)
         return;
      if (this.ticket == null)
         this.ticket = new java.util.HashSet<Ticket>();
      if (!this.ticket.contains(newTicket))
         this.ticket.add(newTicket);
   }
   
   /** @pdGenerated default remove
     * @param oldTicket */
   public void removeTicket(Ticket oldTicket) {
      if (oldTicket == null)
         return;
      if (this.ticket != null)
         if (this.ticket.contains(oldTicket))
            this.ticket.remove(oldTicket);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllTicket() {
      if (ticket != null)
         ticket.clear();
   }

}