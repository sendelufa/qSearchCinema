package ru.sendel.qcinema.parser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

   private static int TIME_INDEX = 0;
   private static int MOVIE_INDEX = 1;
   private static int CINEMA_INDEX = 2;
   private static int COST_INDEX = 3;
   private static int HALL_INDEX = 4;
   private LocalDateTime today = null;

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
      String currentDateText = document.select(".date_navigation :first-child").first().text();

      today = getTodayFromHtml(currentDateText);

      List<SessionParseRaw> movieSessionRaws =
          movieSessions.stream()
              .map(s -> s.select("td"))
              .map(this::mapToSession)
              .filter(Optional::isPresent)
              .map(Optional::get)
              .collect(Collectors.toList());

      movieSessionRaws.forEach(System.out::println);
   }

   private Optional<SessionParseRaw> mapToSession(Elements htmlSessions) {
      List<String> elements =
          htmlSessions.stream()
              .map(Element::text)
              .map(String::trim)
              .collect(Collectors.toList());

      String moveId = htmlSessions.select("td.film a[href]").attr("abs:href").replaceAll(
          ".*?\\/(\\d+)", "$1");
      String cinemaId = htmlSessions.select("td.theatre a[href]").attr("abs:href").replaceAll(
          ".*?\\/(\\d+)", "$1");


      try {
         LocalDateTime currentSessionTime = getSessionDateTime(elements.get(TIME_INDEX), ":");

         Long cost = Long.parseLong(elements.get(COST_INDEX).replaceAll("[^0-9]", ""));
         return Optional.of(new SessionParseRaw(elements.get(MOVIE_INDEX),
             currentSessionTime, elements.get(CINEMA_INDEX), cost, elements.get(HALL_INDEX), cinemaId,
             moveId));
      } catch (IndexOutOfBoundsException ex) {
         ex.printStackTrace();
      }
      return Optional.empty();
   }

   private LocalDateTime getTodayFromHtml(String sessionTime) {
      return LocalDateTime.parse(sessionTime
              .replaceAll("[^0-9.]", "") + " 00:00",
          DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
   }

   private LocalDateTime getSessionDateTime(String timeText, String separator) {
      int[] time = Arrays.stream(timeText.split(separator))
          .mapToInt(Integer::valueOf)
          .toArray();
      return today.plusHours(time[0]).plusMinutes(time[1]);
   }
}
