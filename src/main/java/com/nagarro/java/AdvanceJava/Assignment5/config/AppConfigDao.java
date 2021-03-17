package com.nagarro.java.AdvanceJava.Assignment5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nagarro.java.AdvanceJava.Assignment5.dao.HrDao;
import com.nagarro.java.AdvanceJava.Assignment5.daoImpl.HrDaoImpl;

@Configuration
@EnableScheduling
public class AppConfigDao {

	@Bean
	public HrDao getHrDao() {
		return new HrDaoImpl();
	}
}
