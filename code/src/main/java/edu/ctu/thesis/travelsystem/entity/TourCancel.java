/***********************************************************************
 * Module:  TourCancel.java
 * Author:  rtrush
 * Purpose: Defines the Class TourCancel
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

/** @pdOid d8202691-7b3c-4942-9fae-45fe77b4d784 */
public class TourCancel {
   /** @pdOid e860a4cc-f2c5-4923-94bc-c78100706b48 */
   private String idTourCan;
   /** @pdOid 8a25c43b-081c-4fd6-9b45-d0a4c6b6e0d3 */
   private Date timeCan;
   
   /** @pdRoleInfo migr=no name=Vistor assc=association18 mult=1..1 type=Composition */
   public Visitor owner;
   
   /** @pdOid a64d005f-0f5a-4729-b9ad-0b9ec3c36618 */
   public String getIdCan() {
      // TODO: implement
      return idTourCan;
   }
   
   /** @pdOid c736697b-11e3-4c78-8458-a0a0ea594609 */
   public void setIdCan(String idTourCan) {
      // TODO: implement
	   this.idTourCan = idTourCan;
   }
   
   /** @pdOid 57ca8b8e-69f8-457c-bde2-340b4290791f */
   public Date getTimeCan() {
      // TODO: implement
      return timeCan;
   }
   
   /** @pdOid 2d8844e6-0649-4d24-ab8d-25195417c8fe */
   public void setTimeCan(Date timeCan) {
      // TODO: implement
	   this.timeCan = timeCan;
   }

}