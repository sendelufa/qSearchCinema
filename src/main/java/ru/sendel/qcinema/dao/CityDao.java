package ru.sendel.qcinema.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sendel.qcinema.model.City;

@Repository
@Transactional
public class CityDao extends AbstractDao {

   public City get(int id) {
      return getSession().get(City.class, id);
   }

   public List<City> searchByName(String request) {
      String queryWhere = "from City c where locate(:request, c.name, 1) > 0 ORDER BY c.name";
      TypedQuery<City> query = getSession().createQuery(queryWhere, City.class);
      query.setParameter("request", request);
      return query.getResultList();
   }

   public List<City> getAll() {
      String queryWhere = "from City c ORDER BY c.name";
      TypedQuery<City> query = getSession().createQuery(queryWhere, City.class);
      return query.getResultList();
   }

}
