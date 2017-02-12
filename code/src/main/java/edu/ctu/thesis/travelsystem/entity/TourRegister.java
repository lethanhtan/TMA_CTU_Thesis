/***********************************************************************
 * Module:  TourRegister.java
 * Author:  rtrush
 * Purpose: Defines the Class TourRegister
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import java.util.*;

/** @pdOid c5765b9f-dbee-47d2-ae4a-238715471154 */
public class TourRegister {
   /** @pdOid 3f17ca2e-0b82-47d9-993c-e52e3d2a0eca */
   private String idTourRes;
   /** @pdOid 20bbe180-ce95-494c-89fd-e6e4325293a7 */
   private Date timeRes;
   
   /** @pdRoleInfo migr=no name=TourCancel assc=association17 mult=1..1 type=Composition */
   public TourCancel tourCancel;
   /** @pdRoleInfo migr=no name=Vistor assc=association19 mult=1..1 type=Composition */
   public Visitor owner;
   
   /** @pdOid e7ef14eb-7ca0-418e-97d1-4a771fe243ea */
   public String getIdRes() {
      // TODO: implement
      return idTourRes;
   }
   
   /** @pdOid f226d0d7-5aec-4fcc-8f43-bc997dbce0a5 */
   public void setIdRes(String idTourRes) {
      // TODO: implement
	   this.idTourRes = idTourRes;
   }
   
   /** @pdOid 4b89b303-0d52-43ce-8eeb-b7ecff787c6f */
   public Date getTimeRes() {
      // TODO: implement
      return timeRes;
   }
   
   /** @pdOid 64475e00-ec02-4780-95a7-041091be73d9 */
   public void setTimRes(Date timeRes) {
      // TODO: implement
	   this.timeRes = timeRes;
   }

}