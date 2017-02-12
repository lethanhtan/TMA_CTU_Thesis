/***********************************************************************
 * Module:  Export.java
 * Author:  rtrush
 * Purpose: Defines the Class Export
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

/** @pdOid 38954275-317f-401e-bc0a-7d7ca26444fc */
public class Export {
   /** @pdOid 43d4c036-4702-4fe4-a06d-89f7aad0ff0b */
   private String idExp;
   /** @pdOid 755ce87c-3428-4f65-bcc3-5642d6ba16c3 */
   private String nameExp;
   /** @pdOid 94b9fe04-4e44-4a57-8e36-cfdd9cc0b110 */
   private Date timeCreateExp;
   
   /** @pdOid 62965338-d466-4de6-85f6-f47f449bbe67 */
   public String getIdExp() {
      // TODO: implement
      return idExp;
   }
   
   /** @pdOid ecef2444-32f2-414e-bc56-08c167343a44 */
   public void setIdExp(String idExp) {
      // TODO: implement
	   this.idExp = idExp;
   }
   
   /** @pdOid 029b6dcc-9204-4f61-becf-fe5de5060ffb */
   public String getNameExp() {
      // TODO: implement
      return nameExp;
   }
   
   /** @pdOid 585522d7-4bc9-4a83-808f-5fb19dfeba93 */
   public void setNameExp(String nameExp) {
      // TODO: implement
	   this.nameExp = nameExp;
   }
   
   /** @pdOid 3ddbdcf0-78c8-4374-a324-2fc174697f24 */
   public Date getTimeExp() {
      // TODO: implement
      return timeCreateExp;
   }
   
   /** @pdOid 5656d545-2084-4494-9646-9483bd7b279f */
   public void setTimeExp(Date timeCreateDate) {
      // TODO: implement
	   this.timeCreateExp = timeCreateDate;
   }

}