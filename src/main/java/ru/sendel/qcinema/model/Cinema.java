package ru.sendel.qcinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cinema")
public class Cinema {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @NotNull
   private int id;

   @ManyToOne
   @JoinColumn(name = "city")
   @NotNull
   private City city;

   @NotNull
   @Length(max = 100)
   private String name;


   private String description;

   @Length(max = 100)
   private String geo;

   @Length(max = 100)
   private String address;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public City getCity() {
      return city;
   }

   public void setCity(City city) {
      this.city = city;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getGeo() {
      return geo;
   }

   public void setGeo(String geo) {
      this.geo = geo;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }
}
