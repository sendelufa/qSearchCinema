package ru.sendel.qcinema.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@DependsOn("flyway")
@EnableTransactionManagement
public class HibernateConf {

   @Autowired
   private Environment environment;
   @Value("${spring.datasource.url}")
   private String jdbcURl;
   @Value("${spring.datasource.username}")
   private String dbUsername;
   @Value("${spring.datasource.password}")
   private String dbPassword;
   @Value("${spring.jpa.properties.hibernate.dialect}")
   private String dbDialect;
   @Value("${spring.jpa.hibernate.ddl-auto}")
   private String ddlAuto;

   @Bean
   public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource());
      sessionFactory.setHibernateProperties(hibernateProperties());
      sessionFactory.setPackagesToScan("ru.sendel.qcinema.model");
      return sessionFactory;
   }

   @Bean
   public DataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setUrl(jdbcURl);
      dataSource.setUsername(dbUsername);
      dataSource.setPassword(dbPassword);
      return dataSource;
   }

   private Properties hibernateProperties() {
      Properties hibernateProperties = new Properties();
      hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
      hibernateProperties.setProperty(
          "hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
      hibernateProperties.setProperty(
          "hibernate.temp.use_jdbc_metadata_defaults", environment
              .getProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults"));
      return hibernateProperties;
   }
}
