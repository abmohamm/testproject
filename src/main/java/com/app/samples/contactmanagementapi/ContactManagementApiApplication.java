package com.app.samples.contactmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactManagementApiApplication.
 */
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.app.samples.contactmanagementapi")
@EnableConfigurationProperties
public class ContactManagementApiApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ContactManagementApiApplication.class, args);
	}

}
