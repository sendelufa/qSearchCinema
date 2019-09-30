package ru.sendel.qcinema.parser;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//@Configuration
@EnableScheduling
public class CinemaParser {

   @Scheduled(fixedDelay = 100)
   private void parse(){
    //TODO parse HTML
   }
}
