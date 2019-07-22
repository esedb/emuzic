package com.emuzic.muzic;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


import org.hibernate.dialect.MySQL57Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	@Autowired
	DataSource datasource;
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		 LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		 emf.setDataSource(datasource);
		 emf.setJpaVendorAdapter(jpaVendorAdapter());
		 emf.setPackagesToScan("com.emuzic.muzic");
		 
		 return emf;
	}
	
	private JpaVendorAdapter jpaVendorAdapter() {
		 HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		 jpaVendorAdapter.setShowSql(true);
		 jpaVendorAdapter.setGenerateDdl(true);
		 jpaVendorAdapter.setDatabasePlatform(MySQL57Dialect.class.getName());
		 return jpaVendorAdapter;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
