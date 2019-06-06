package com.den.springsecurity.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Optional;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.den.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

	@Autowired
	private Environment env; // will hold data read from properties files

	private Logger logger = Logger.getLogger(getClass().getName());

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			logger.info(">>>>> jdbc.url=" + env.getProperty("jdbc.url"));
			logger.info(">>>>> jdbc.user=" + env.getProperty("jdbc.user"));

			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
			securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			securityDataSource.setUser(env.getProperty("jdbc.user"));
			securityDataSource.setPassword(env.getProperty("jdbc.password"));

			securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize", "5"));
			securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize", "5"));
			securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize", "20"));
			securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime", "3000"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		return securityDataSource;
	}

	private int getIntProperty(String propertyName, String defaultValue) {
		return Integer.parseInt(Optional.ofNullable(env.getProperty(propertyName)).orElse(defaultValue));
	}

}
