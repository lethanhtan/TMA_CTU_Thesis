/***********************************************************************
 * Module:  Cost.java
 * Author:  rtrush
 * Purpose: Defines the Class Cost
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

/** @pdOid 701666c6-207a-48e7-b4f5-812f9d2f8d9c */
public class Cost {
   /** @pdOid 6fefbe51-6c75-48c6-b6a1-06acf857eb1c */
   private String idCost;
   /** @pdOid 6e197e06-55c9-400d-beeb-765175c11a6a */
   private Double costTour;
   
   /** @pdOid 9528e925-98f7-4fa0-8273-71ad6dfd9a92 */
   public String getIdCost() {
      // TODO: implement
      return idCost;
   }
   
   /** @pdOid 707947dd-05df-4a01-aed2-73f4d3a89359 */
   public void setIdCost(String idCost) {
      // TODO: implement
	   this.idCost = idCost;
   }
   
   /** @pdOid 8ca77c59-e91b-4492-8701-429e4795ce9f */
   public Double getCostTour() {
      // TODO: implement
      return costTour;
   }
   
   /** @pdOid 3c385d4f-78de-4409-80e9-50bf1d2acdba */
   public void setCostTour(Double costTour) {
      // TODO: implement
	   this.costTour = costTour;
   }

}