/***********************************************************************
 * Module:  Place.java
 * Author:  rtrush
 * Purpose: Defines the Class Place
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

/** @pdOid 12cb2f59-fbe8-4edb-90c7-b2e022885b79 */
public class Place {
   /** @pdOid 3b6bfe12-a470-497f-8c77-19c31ebae907 */
   private String idPlace;
   /** @pdOid 0441fe7d-c4ae-4b4a-af42-ad91f3c1965d */
   private String namePlace;
   /** @pdOid 9ea85471-e1fc-477c-bcec-95b0780a500b */
   private String provincePlace;
   
   /** @pdOid b7f09717-e93d-4484-b1ad-5114be1f30c3 */
   public String getIdPlace() {
      // TODO: implement
      return idPlace;
   }
   
   /** @pdOid 43c6e189-ac81-492b-b1a5-c1f305893223 */
   public void setIdPlace(String idPlace) {
      // TODO: implement
	   this.idPlace = idPlace;
   }
   
   /** @pdOid cf90101d-5a0f-4238-ac98-284603714da7 */
   public String getNamePlace() {
      // TODO: implement
      return namePlace;
   }
   
   /** @pdOid b6a5259a-a6b4-4537-93c2-8001f24278f0 */
   public void setNamePalce(String namePlace) {
      // TODO: implement
	   this.namePlace = namePlace;
   }
   
   /** @pdOid c31ca24e-d48f-4618-989b-c2143cf35c37 */
   public String getProvince() {
      // TODO: implement
      return provincePlace;
   }
   
   /** @pdOid 734a922b-463c-434f-b362-0c375ad126f9 */
   public void setProvince(String provincePlace) {
      // TODO: implement
	   this.provincePlace = provincePlace;
   }

}