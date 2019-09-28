package ru.sendel.qcinema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sendel.qcinema.dao.CityDao;
import ru.sendel.qcinema.model.City;

@RestController
@RequestMapping("city/")
public class CityController {

   @Autowired
   private CityDao cityDao;

   @GetMapping(value = "{id:\\d+}")
   public ResponseEntity getCity(@PathVariable int id) {
      City city = cityDao.get(id);
      return new ResponseEntity<>(city.getCountry(), HttpStatus.OK);
   }

   @GetMapping
   public ResponseEntity getCity(
       @RequestParam(value = "search")
           String search) {
      List<City> city = cityDao.searchByName(search);
      return new ResponseEntity<>(city, HttpStatus.OK);
   }

   @GetMapping(value = "all")
   public ResponseEntity getCityList() {
      List<City> city = cityDao.getAll();
      return new ResponseEntity<>(city, HttpStatus.OK);
   }


}
