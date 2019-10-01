package ru.sendel.qcinema.dto;

import java.time.LocalDateTime;

public class SessionParseRaw {

   private String name;
   private LocalDateTime datetime;
   private String cinema;
   private Long cost;
   private String hall;
   private String cinemaId;
   private String movieId;

   public SessionParseRaw(String name, LocalDateTime datetime, String cinema, Long cost,
       String hall, String cinemaId, String movieId) {
      this.name = name;
      this.datetime = datetime;
      this.cinema = cinema;
      this.cost = cost;
      this.hall = hall;
      this.cinemaId = cinemaId;
      this.movieId = movieId;
   }

   @Override
   public String toString() {
      return String.format("[name: %s, datetime: %s, cinema: %s, cost: %d, hall: %s, cId: %s, "
              + "mId:%s]", name,
          datetime,
          cinema, cost, hall, cinemaId, movieId);
   }

   public String getName() {
      return name;
   }

   public LocalDateTime getDatetime() {
      return datetime;
   }

   public String getCinema() {
      return cinema;
   }

   public Long getCost() {
      return cost;
   }

   public String getHall() {
      return hall;
   }

   public String getCinemaId() {
      return cinemaId;
   }

   public String getMovieId() {
      return movieId;
   }
}
