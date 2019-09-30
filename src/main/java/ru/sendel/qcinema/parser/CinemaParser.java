package ru.sendel.qcinema.parser;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//@Configuration
@EnableScheduling
public class CinemaParser {

   @Scheduled(fixedDelay = 100)
   public void parse(String url) {
      Document document;
      try {
         document =
             Jsoup.connect(url)
                 .userAgent("IE")
                 .timeout(50000)
                 .maxBodySize(0)
                 .execute()
                 .parse();
      } catch (IOException e) {
         e.printStackTrace();
         return;
         //TODO: log ex
      }

      Elements links = document.select("table.afisha-schedule tbody tr");

      links.stream().map(Element::html).forEach(System.out::println);

   }
}
