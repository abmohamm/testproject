package com.app.samples.contactmanagementapi.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// TODO: Auto-generated Javadoc
/**
 * The Class DataSourceConfiguration.
 */
@Configuration
@PropertySources({@PropertySource("classpath:application-dev.properties"),
				  @PropertySource("classpath:importDb.properties")})
public class DataSourceConfiguration {
	
	/** The jdbc template. */
	JdbcTemplate jdbcTemplate = null;
	
	/** The logger. */
	Logger logger = Logger.getLogger(DataSourceConfiguration.class.getName());
	
	/** The class name. */
	private static String CLASS_NAME = "DataSourceConfiguration";
	
	/** The driver class name. */
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	/** The db url. */
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	/** The db user name. */
	@Value("${spring.datasource.username}")
	private String dbUserName;
	
	/** The db password. */
	@Value("${spring.datasource.password}")
	private String dbPassword;

	/**
	 * Creates the data source.
	 *
	 * @return the data source
	 */
	@Bean 
	public DataSource createDataSource() {
		logger.info("connecting to database : "+CLASS_NAME);
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		return dataSource;
	}
	
	/**
	 * Jdbc template.
	 *
	 * @param dataSource the data source
	 * @return the jdbc template
	 */
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		logger.info(" creating jdbcTemplate : "+CLASS_NAME);		
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}
}
