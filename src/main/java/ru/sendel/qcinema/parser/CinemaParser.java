package ru.sendel.qcinema.parser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.sendel.qcinema.dto.SessionParseRaw;

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
         //TODO: log error
      }

      Elements movieSessions = document.select("table.afisha-schedule tbody tr");
      List<Elements> elements = movieSessions.stream()
          .map(s -> s.select("td")).collect(Collectors.toList());
      elements.forEach(this::mapToCity);

      //movieSessions.stream().map(Element::html).forEach(System.out::println);

   }

   private List<SessionParseRaw> mapToCity(Elements htmlSessions) {
      List<String> elements =
          htmlSessions.select("td")
              .stream()
              .map(Element::text)
              .map(String::trim)
              .collect(Collectors.toList());

      try {
         LocalDateTime datetime = LocalDateTime.now();

         Long cost = Long.parseLong(elements.get(3).replaceAll("[^0-9]", ""));
         SessionParseRaw sessionParseRaw = new SessionParseRaw(elements.get(1), datetime,
             elements.get(2),
             cost);
         System.out.println(sessionParseRaw);
      } catch (IndexOutOfBoundsException ex){
         ex.printStackTrace();
      }
      return null;
   }

   private LocalDateTime convertDate(String sessionTime){
return null;
   }


}
