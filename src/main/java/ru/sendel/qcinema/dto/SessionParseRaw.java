package ru.sendel.qcinema.dto;

import java.time.LocalDateTime;

public class SessionParseRaw {

   private String name;
   private LocalDateTime datetime;
   private String cinema;
   private Long cost;

   public SessionParseRaw(String name, LocalDateTime datetime, String cinema, Long cost) {
      this.name = name;
      this.datetime = datetime;
      this.cinema = cinema;
      this.cost = cost;
   }

   @Override
   public String toString() {
      return String.format("[name: %s, datetime: %s, cinema: %s, cost: %d]", name, datetime,
          cinema, cost);
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public LocalDateTime getDatetime() {
      return datetime;
   }

   public void setDatetime(LocalDateTime datetime) {
      this.datetime = datetime;
   }

   public String getCinema() {
      return cinema;
   }

   public void setCinema(String cinema) {
      this.cinema = cinema;
   }

   public Long getCost() {
      return cost;
   }

   public void setCost(Long cost) {
      this.cost = cost;
   }
}
