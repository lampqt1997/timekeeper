package com.isc.timekeeper.multipledb;

import static java.util.Collections.singletonMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "timekeeperEntityManagerFactory",
    transactionManagerRef = "timekeeperTransactionManager", basePackages = {"com.isc.timekeeper.multipledb.timekeeper.repository"})
public class TimeKeeperDbConfig {

  @Bean(name = "timekeeperDataSource")
  @ConfigurationProperties(prefix = "timekeeper.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "timekeeperEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("timekeeperDataSource") DataSource dataSource) {
    return builder
    		.dataSource(dataSource)
    		.packages("com.isc.timekeeper.multipledb.timekeeper.entity")
    		.persistenceUnit("timekeeper")  
//    		.properties(singletonMap("spring.jpa.database", "default"))
    		.properties(singletonMap("spring.jpa.generate-ddl", "true"))
    		.properties(singletonMap("spring.jpa.hibernate.ddl.auto", "create-drop"))
    		.properties(singletonMap("spring.jpa.show-sql", "true"))
    		.properties(singletonMap("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect"))
        .build();
  }
  


  @Bean(name = "timekeeperTransactionManager")
  public PlatformTransactionManager barTransactionManager(
      @Qualifier("timekeeperEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
    return new JpaTransactionManager(barEntityManagerFactory);
  }

}
