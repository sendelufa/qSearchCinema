package ru.sendel.qcinema.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "movie_session")
public class MovieSession {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "film_id")
   @NotNull
   private Movie movie;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "cinema_id")
   @NotNull
   private Cinema cinema;

   @NotNull
   private LocalDateTime timestamp;

   @NotNull
   private Integer cost;

   @NotNull
   private String hall;

   @Length(max = 32)
   private String hashcode;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public Movie getMovie() {
      return movie;
   }

   public void setMovie(Movie movie) {
      this.movie = movie;
   }

   public Cinema getCinema() {
      return cinema;
   }

   public void setCinema(Cinema cinema) {
      this.cinema = cinema;
   }

   public LocalDateTime getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(LocalDateTime timestamp) {
      this.timestamp = timestamp;
   }

   public Integer getCost() {
      return cost;
   }

   public void setCost(Integer cost) {
      this.cost = cost;
   }

   public String getHashcode() {
      return hashcode;
   }

   public void setHashcode(String hashcode) {
      this.hashcode = hashcode;
   }

   public String getHall() {
      return hall;
   }

   public void setHall(String hall) {
      this.hall = hall;
   }
}
