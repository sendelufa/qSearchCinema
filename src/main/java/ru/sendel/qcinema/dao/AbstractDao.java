package ru.sendel.qcinema.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
abstract class AbstractDao {

   @Autowired
   private SessionFactory sessionFactory;

   Session getSession() {
      return sessionFactory.getCurrentSession();
   }

}


