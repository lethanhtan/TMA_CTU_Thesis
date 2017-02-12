/***********************************************************************
 * Module:  Manager.java
 * Author:  rtrush
 * Purpose: Defines the Class Manager
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

/** @pdOid 52e0d20c-9638-4406-ad8f-b80af8fb0815 */
public class Manager {
   /** @pdOid 0b70c5ef-ecc3-451e-8448-74156fe4e2ac */
   private String idMan;
   /** @pdOid c503fda6-0f33-40c0-b3cd-5063436db30e */
   private String nameMan;
   /** @pdOid d0cd0204-2b65-406b-8e3b-fcdb80e959b0 */
   private String addressMan;
   /** @pdOid 47ba6235-01eb-4776-93c1-7bf5fcb5d7ca */
   private String emailMan;
   /** @pdOid c29d63a8-0c4c-402c-83fc-4b5d0513be5d */
   private Integer phoneMan;
   /** @pdOid c9013712-46f9-4975-85a0-fabb2d014447 */
   private String passAccMan;
   
   /** @pdRoleInfo migr=no name=Tour assc=association1 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Tour> tour;
   /** @pdRoleInfo migr=no name=Export assc=association8 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Export> export;
   /** @pdRoleInfo migr=no name=Import assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Import> import_ob;
   /** @pdRoleInfo migr=no name=Account assc=association11 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Account> account;
   
   /** @pdOid dbe1fb54-b9a5-4e03-a363-b884d5580895 */
   public String getIdMan() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid c0e281be-02c9-4c96-bc68-5c92b20961d1 */
   public void setIdMan() {
      // TODO: implement
   }
   
   /** @pdOid 1291d524-347c-4a29-a3db-baf885e87a9a */
   public String getNameMan() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid fc0b86a1-a730-4bd3-bf55-372cc2c855ea */
   public void setNameMan() {
      // TODO: implement
   }
   
   /** @pdOid 46e97441-e725-49ef-9569-53fa401241e5 */
   public String getAddressMan() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid f1ff3ee3-528c-42db-ba20-4d738490b7c0 */
   public void setAddressMan() {
      // TODO: implement
   }
   
   /** @pdOid 3fb3425b-b1b7-41cf-bd63-1f3c6a39ea85 */
   public String getEmailMan() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid e3431e08-aa28-4025-8b00-9a15ff137f38 */
   public void setEmailMan() {
      // TODO: implement
   }
   
   /** @pdOid 3a8503d4-8610-4388-bb5f-49bd41fe4c30 */
   public Integer getPhoneMan() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid a66cd947-60dc-4a8e-a553-a0ca742138aa */
   public void setPhoneMan() {
      // TODO: implement
   }
   
   /** @pdOid 1519185f-7e69-444f-bd2b-1b7fff9a8f6c */
   public String getPassAccMan() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 02063025-b9a7-46f1-9ecb-d6049e4ef96d */
   public void setPassAccMan() {
      // TODO: implement
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
   public java.util.Collection<Export> getExport() {
      if (export == null)
         export = new java.util.HashSet<Export>();
      return export;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorExport() {
      if (export == null)
         export = new java.util.HashSet<Export>();
      return export.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newExport */
   public void setExport(java.util.Collection<Export> newExport) {
      removeAllExport();
      for (java.util.Iterator iter = newExport.iterator(); iter.hasNext();)
         addExport((Export)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newExport */
   public void addExport(Export newExport) {
      if (newExport == null)
         return;
      if (this.export == null)
         this.export = new java.util.HashSet<Export>();
      if (!this.export.contains(newExport))
         this.export.add(newExport);
   }
   
   /** @pdGenerated default remove
     * @param oldExport */
   public void removeExport(Export oldExport) {
      if (oldExport == null)
         return;
      if (this.export != null)
         if (this.export.contains(oldExport))
            this.export.remove(oldExport);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllExport() {
      if (export != null)
         export.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Import> getImport() {
      if (import_ob == null)
         import_ob = new java.util.HashSet<Import>();
      return import_ob;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorImport() {
      if (import_ob == null)
         import_ob = new java.util.HashSet<Import>();
      return import_ob.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newImport */
   public void setImport(java.util.Collection<Import> newImport) {
      removeAllImport();
      for (java.util.Iterator iter = newImport.iterator(); iter.hasNext();)
         addImport((Import)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newImport */
   public void addImport(Import newImport) {
      if (newImport == null)
         return;
      if (this.import_ob == null)
         this.import_ob = new java.util.HashSet<Import>();
      if (!this.import_ob.contains(newImport))
         this.import_ob.add(newImport);
   }
   
   /** @pdGenerated default remove
     * @param oldImport */
   public void removeImport(Import oldImport) {
      if (oldImport == null)
         return;
      if (this.import_ob != null)
         if (this.import_ob.contains(oldImport))
            this.import_ob.remove(oldImport);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllImport() {
      if (import_ob != null)
         import_ob.clear();
   }
   /** @pdGenerated default getter */
   public java.util.Collection<Account> getAccount() {
      if (account == null)
         account = new java.util.HashSet<Account>();
      return account;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorAccount() {
      if (account == null)
         account = new java.util.HashSet<Account>();
      return account.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAccount */
   public void setAccount(java.util.Collection<Account> newAccount) {
      removeAllAccount();
      for (java.util.Iterator iter = newAccount.iterator(); iter.hasNext();)
         addAccount((Account)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAccount */
   public void addAccount(Account newAccount) {
      if (newAccount == null)
         return;
      if (this.account == null)
         this.account = new java.util.HashSet<Account>();
      if (!this.account.contains(newAccount))
         this.account.add(newAccount);
   }
   
   /** @pdGenerated default remove
     * @param oldAccount */
   public void removeAccount(Account oldAccount) {
      if (oldAccount == null)
         return;
      if (this.account != null)
         if (this.account.contains(oldAccount))
            this.account.remove(oldAccount);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllAccount() {
      if (account != null)
         account.clear();
   }

}