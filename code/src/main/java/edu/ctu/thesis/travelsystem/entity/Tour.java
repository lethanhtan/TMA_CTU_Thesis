/***********************************************************************
 * Module:  Tour.java
 * Author:  rtrush
 * Purpose: Defines the Class Tour
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

/** @pdOid f2a4a155-1b52-48c7-90a5-fd16eaf57dc1 */
public class Tour {
   /** @pdOid f30a861d-8847-4069-a67d-419bc05ca289 */
   private String idTour;
   /** @pdOid 61d21732-3394-48db-8e69-9058c1809283 */
   private String nameTour;
   /** @pdOid 1253c4c7-cbb6-47c6-b23b-dfbe1bfe134a */
   private String describeTour;
   /** @pdOid 1b95aa99-39e3-4849-b6a8-725532c9bd73 */
   private String schedule;
   
   /** @pdRoleInfo migr=no name=Promotion assc=association3 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Promotion> promotion;
   /** @pdRoleInfo migr=no name=Feedback assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Feedback> feedback;
   /** @pdRoleInfo migr=no name=Place assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Place> place;
   /** @pdRoleInfo migr=no name=Cost assc=association6 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Cost> cost;
   /** @pdRoleInfo migr=no name=Ticket assc=association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Ticket> ticket;
   /** @pdRoleInfo migr=no name=TourCancel assc=association13 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<TourCancel> tourCancel;
   /** @pdRoleInfo migr=no name=TourRegister assc=association14 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<TourRegister> tourRegister;
   
   /** @pdOid b22778bd-9229-4e4c-bebc-33ac23635442 */
   public String getIdTour() {
      // TODO: implement
      return idTour;
   }
   
   /** @pdOid 0bcd3b2e-af4b-4ecd-a378-aab262c7510c */
   public void setIdTour(String idTour) {
      // TODO: implement
	   this.idTour = idTour;
   }
   
   /** @pdOid 8af611e4-7eef-41f2-9f20-47514d846987 */
   public String getNameTour() {
      // TODO: implement
      return nameTour;
   }
   
   /** @pdOid d99a34ec-a1ce-453e-9fb8-845458f45c7d */
   public void setNameTour(String nameTour) {
      // TODO: implement
	   this.nameTour = nameTour;
   }
   
   /** @pdOid 2cc6f67d-e5bf-4841-a9bd-9b04d94b802d */
   public String getDescribeTour() {
      // TODO: implement
      return describeTour;
   }
   
   /** @pdOid 8bbdacb3-5a8d-4007-b2b6-52e4e7825f28 */
   public void setDescribeTour(String describeTour) {
      // TODO: implement
	   this.describeTour = describeTour;
   }
   
   /** @pdOid 8d9fc6a7-479e-4e4b-9240-38fe3d771ab2 */
   public String getSchedule() {
      // TODO: implement
      return schedule;
   }
   
   /** @pdOid 8b52170a-2a94-4b96-a528-86e8962e74cc */
   public void setSchedule(String schedule) {
      // TODO: implement
	   this.schedule = schedule;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Promotion> getPromotion() {
      if (promotion == null)
         promotion = new java.util.HashSet<Promotion>();
      return promotion;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Promotion> getIteratorPromotion() {
      if (promotion == null)
         promotion = new java.util.HashSet<Promotion>();
      return promotion.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPromotion */
   public void setPromotion(java.util.Collection<Promotion> newPromotion) {
      removeAllPromotion();
      for (java.util.Iterator<Promotion> iter = newPromotion.iterator(); iter.hasNext();)
         addPromotion(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPromotion */
   public void addPromotion(Promotion newPromotion) {
      if (newPromotion == null)
         return;
      if (this.promotion == null)
         this.promotion = new java.util.HashSet<Promotion>();
      if (!this.promotion.contains(newPromotion))
         this.promotion.add(newPromotion);
   }
   
   /** @pdGenerated default remove
     * @param oldPromotion */
   public void removePromotion(Promotion oldPromotion) {
      if (oldPromotion == null)
         return;
      if (this.promotion != null)
         if (this.promotion.contains(oldPromotion))
            this.promotion.remove(oldPromotion);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPromotion() {
      if (promotion != null)
         promotion.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Feedback> getFeedback() {
      if (feedback == null)
         feedback = new java.util.HashSet<Feedback>();
      return feedback;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Feedback> getIteratorFeedback() {
      if (feedback == null)
         feedback = new java.util.HashSet<Feedback>();
      return feedback.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newFeedback */
   public void setFeedback(java.util.Collection<Feedback> newFeedback) {
      removeAllFeedback();
      for (java.util.Iterator<Feedback> iter = newFeedback.iterator(); iter.hasNext();)
         addFeedback(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newFeedback */
   public void addFeedback(Feedback newFeedback) {
      if (newFeedback == null)
         return;
      if (this.feedback == null)
         this.feedback = new java.util.HashSet<Feedback>();
      if (!this.feedback.contains(newFeedback))
         this.feedback.add(newFeedback);
   }
   
   /** @pdGenerated default remove
     * @param oldFeedback */
   public void removeFeedback(Feedback oldFeedback) {
      if (oldFeedback == null)
         return;
      if (this.feedback != null)
         if (this.feedback.contains(oldFeedback))
            this.feedback.remove(oldFeedback);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllFeedback() {
      if (feedback != null)
         feedback.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Place> getPlace() {
      if (place == null)
         place = new java.util.HashSet<Place>();
      return place;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Place> getIteratorPlace() {
      if (place == null)
         place = new java.util.HashSet<Place>();
      return place.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPlace */
   public void setPlace(java.util.Collection<Place> newPlace) {
      removeAllPlace();
      for (java.util.Iterator<Place> iter = newPlace.iterator(); iter.hasNext();)
         addPlace(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newPlace */
   public void addPlace(Place newPlace) {
      if (newPlace == null)
         return;
      if (this.place == null)
         this.place = new java.util.HashSet<Place>();
      if (!this.place.contains(newPlace))
         this.place.add(newPlace);
   }
   
   /** @pdGenerated default remove
     * @param oldPlace */
   public void removePlace(Place oldPlace) {
      if (oldPlace == null)
         return;
      if (this.place != null)
         if (this.place.contains(oldPlace))
            this.place.remove(oldPlace);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPlace() {
      if (place != null)
         place.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Cost> getCost() {
      if (cost == null)
         cost = new java.util.HashSet<Cost>();
      return cost;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Cost> getIteratorCost() {
      if (cost == null)
         cost = new java.util.HashSet<Cost>();
      return cost.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newCost */
   public void setCost(java.util.Collection<Cost> newCost) {
      removeAllCost();
      for (java.util.Iterator<Cost> iter = newCost.iterator(); iter.hasNext();)
         addCost(iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCost */
   public void addCost(Cost newCost) {
      if (newCost == null)
         return;
      if (this.cost == null)
         this.cost = new java.util.HashSet<Cost>();
      if (!this.cost.contains(newCost))
         this.cost.add(newCost);
   }
   
   /** @pdGenerated default remove
     * @param oldCost */
   public void removeCost(Cost oldCost) {
      if (oldCost == null)
         return;
      if (this.cost != null)
         if (this.cost.contains(oldCost))
            this.cost.remove(oldCost);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllCost() {
      if (cost != null)
         cost.clear();
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

}