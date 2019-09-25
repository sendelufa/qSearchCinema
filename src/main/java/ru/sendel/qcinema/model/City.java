package ru.sendel.qcinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "city")
public class City {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @NotNull
   private int id;

   @NotNull
   private String name;
   private String country;
   @NotNull
   private String geo;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getGeo() {
      return geo;
   }

   public void setGeo(String geo) {
      this.geo = geo;
   }
}
