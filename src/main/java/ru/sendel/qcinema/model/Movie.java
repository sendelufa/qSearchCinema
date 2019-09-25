package ru.sendel.qcinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "movie")
public class Movie {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Length(max = 150)
   @Column(name = "name_native")
   @NotNull
   private String name;

   @Length(max = 4)
   private String year;

   private String description;
   private String poster_img;

   @Column(name = "name_original")
   private String nameOriginalLanguage;


   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getYear() {
      return year;
   }

   public void setYear(String year) {
      this.year = year;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getPoster_img() {
      return poster_img;
   }

   public void setPoster_img(String poster_img) {
      this.poster_img = poster_img;
   }

   public String getNameOriginalLanguage() {
      return nameOriginalLanguage;
   }

   public void setNameOriginalLanguage(String nameOriginalLanguage) {
      this.nameOriginalLanguage = nameOriginalLanguage;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }
}
