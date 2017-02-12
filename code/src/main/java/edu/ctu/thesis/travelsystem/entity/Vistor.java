/***********************************************************************
 * Module:  Vistor.java
 * Author:  rtrush
 * Purpose: Defines the Class Vistor
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

/** @pdOid 62f71e5f-c1a7-4abb-be67-bb837f859d43 */
public class Vistor {
   /** @pdOid cf65a761-5044-4c64-a0b6-525b402ce75e */
   private String nameVis;
   /** @pdOid f2c39396-b5b3-485e-a01e-f61e30a27311 */
   private String addressVis;
   /** @pdOid 973f8990-6a7b-42d6-9510-96c415b4e713 */
   private Integer phoneVis;
   
   /** @pdRoleInfo migr=no name=Ticket assc=association21 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Ticket> ticket;
   
   /** @pdOid 0ccc207e-054d-4d56-95ea-94cecd1c9ceb */
   public String getNameVis() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 5352df1d-e486-4d59-afee-cc18329184ce */
   public void setNameVis() {
      // TODO: implement
   }
   
   /** @pdOid 3a139fb3-c11c-4c0f-b989-e28e5903a75d */
   public String getAddressVis() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 6ac9148a-a43c-416b-8a7d-63e59619ca4d */
   public void setAddressVis() {
      // TODO: implement
   }
   
   /** @pdOid 750d6e4e-4110-4715-82bb-bc0e1d2e2a47 */
   public String getPhoneVis() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 12564f66-6b68-4b0f-a585-ebb41e020daa */
   public void setPhoneVis() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Ticket> getTicket() {
      if (ticket == null)
         ticket = new java.util.HashSet<Ticket>();
      return ticket;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorTicket() {
      if (ticket == null)
         ticket = new java.util.HashSet<Ticket>();
      return ticket.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newTicket */
   public void setTicket(java.util.Collection<Ticket> newTicket) {
      removeAllTicket();
      for (java.util.Iterator iter = newTicket.iterator(); iter.hasNext();)
         addTicket((Ticket)iter.next());
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