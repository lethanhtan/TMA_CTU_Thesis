/***********************************************************************
 * Module:  Customer.java
 * Author:  rtrush
 * Purpose: Defines the Class Customer
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;


/** @pdOid 086e0489-5429-41ba-90a0-5accea049647 */
public class Customer {
   /** @pdOid 939165df-e515-42a5-bb48-2fd0d72faeaf */
   private String idCus;
   /** @pdOid 527a5254-228e-439a-980b-787e4c317b16 */
   private String nameCus;
   /** @pdOid 46a0a552-efee-48a1-b2d4-1125bacacc37 */
   private String addressCus;
   /** @pdOid 470d9339-a073-479b-bf84-79f9f4c34a2f */
   private String emailCus;
   /** @pdOid 09952520-18d9-4897-86ff-c11d2824ca7a */
   private Integer phoneCus;
   
   /** @pdRoleInfo migr=no name=Account assc=association10 coll=java.util.Collection impl=java.util.HashSet mult=1..* */
   public java.util.Collection<Account> account;
   
   /** @pdOid 3296755d-ad4a-4fa5-bb4a-aaffc444e8ca */
   public String getIdCus() {
      // TODO: implement
      return idCus;
   }
   
   /** @pdOid fb720b34-ccbf-4c91-ad0b-81fefde6102f */
   public void setIdCus(String idCus) {
      // TODO: implement
	   this.idCus = idCus;
   }
   
   /** @pdOid a25bc052-6ab3-4bad-af23-b9115c3b699b */
   public String getNameCus() {
      // TODO: implement
      return nameCus;
   }
   
   /** @pdOid 63d8d615-eb0e-4c2d-8b7a-956761f3b1cc */
   public void setNameCus(String nameCus) {
      // TODO: implement
	   this.nameCus = nameCus;
   }
   
   /** @pdOid a1f0af93-5af1-45f0-925c-40c763439787 */
   public String getAddresCus() {
      // TODO: implement
      return addressCus;
   }
   
   /** @pdOid 8a3df644-40e8-4b64-8d30-a7771f10346c */
   public void setAddressCus(String addressCus) {
      // TODO: implement
	   this.addressCus = addressCus;
   }
   
   /** @pdOid 86951dce-4e1b-4440-9675-6d61f0a6df3b */
   public Integer getPhoneCus() {
      // TODO: implement
      return phoneCus;
   }
   
   /** @pdOid cf680fea-625c-4c99-8cb9-a59731bd4104 */
   public void setPhoneCus(Integer phoneCus) {
      // TODO: implement
	   this.phoneCus = phoneCus;
   }
   
   /** @pdOid 86951dce-4e1b-4440-9675-6d61f0a6df3b */
   public String getEmailCus() {
      // TODO: implement
      return emailCus;
   }
   
   /** @pdOid cf680fea-625c-4c99-8cb9-a59731bd4104 */
   public void setEmailCus(String emailCus) {
      // TODO: implement
	   this.emailCus = emailCus;
   }
   
   /** @pdGenerated default getter */
   public java.util.Collection<Account> getAccount() {
      if (account == null)
         account = new java.util.HashSet<Account>();
      return account;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator<Account> getIteratorAccount() {
      if (account == null)
         account = new java.util.HashSet<Account>();
      return account.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newAccount */
   public void setAccount(java.util.Collection<Account> newAccount) {
      removeAllAccount();
      for (java.util.Iterator<Account> iter = newAccount.iterator(); iter.hasNext();)
         addAccount(iter.next());
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