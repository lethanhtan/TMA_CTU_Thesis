/***********************************************************************
 * Module:  Ticket.java
 * Author:  rtrush
 * Purpose: Defines the Class Ticket
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

/** @pdOid 695a5b8a-7dce-4233-b30d-a9ec7f6d5f50 */
public class Ticket {
   /** @pdOid b88e895f-11c9-47c5-a69c-f7c603e618ea */
   private String idTic;
   /** @pdOid 65df6ed0-9650-41e1-8a94-472b8cb5dc75 */
   private String nameTic;
   /** @pdOid 4f4027d6-a314-4ec8-80e6-f53cb850088c */
   private String ownerTic;
   
   /** @pdOid cdf02f40-c9f6-4145-8d4f-5c4860917140 */
   public String getIdTic() {
      // TODO: implement
      return idTic;
   }
   
   /** @pdOid 65eb3aad-d2e3-4d7e-bc35-791d085f93c1 */
   public void setIdTic(String idTic) {
      // TODO: implement
	   this.idTic = idTic;
   }
   
   /** @pdOid 7a21a9be-8d5b-4337-882e-0c1ddab35cd8 */
   public String getNameTic() {
      // TODO: implement
      return nameTic;
   }
   
   /** @pdOid 30adf523-94a0-4a2f-a2c6-7c3e3c71d4f5 */
   public void setNameTic(String nameTic) {
      // TODO: implement
	   this.nameTic = nameTic;
   }
   
   /** @pdOid e3d36191-ac95-45f8-ac45-0cd65d14c774 */
   public String getOwnerTic() {
      // TODO: implement
      return ownerTic;
   }
   
   /** @pdOid db6cbd32-a7f5-4481-8844-f1cf44a74b4b */
   public void setOwnerTic(String ownerTic) {
      // TODO: implement
	   this.ownerTic = ownerTic;
   }

}