/***********************************************************************
 * Module:  Ticket.java
 * Author:  Lê Như Ý
 * Purpose: Defines the Class Ticket
 ***********************************************************************/
package edu.ctu.thesis.travelsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "TICKET", uniqueConstraints = { @UniqueConstraint(columnNames={"ID_TIC"}) })
public class Ticket {
   private String idTic;
   private String nameTic;
   private String ownerTic;
   
   @Id
   @Column(name = "ID_TIC", nullable = false)
   public String getIdTic() {
      return idTic;
   }
   
   public void setIdTic(String idTic) {
	   this.idTic = idTic;
   }
   
   @Column(name = "NAME_TIC", nullable = false)
   public String getNameTic() {
      return nameTic;
   }
   
   public void setNameTic(String nameTic) {
	   this.nameTic = nameTic;
   }
   
   @Column(name = "OWNER_TIC", nullable = false)
   public String getOwnerTic() {
      return ownerTic;
   }
   
   public void setOwnerTic(String ownerTic) {
	   this.ownerTic = ownerTic;
   }

}