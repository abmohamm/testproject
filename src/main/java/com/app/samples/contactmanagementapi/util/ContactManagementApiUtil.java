package com.app.samples.contactmanagementapi.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import com.app.samples.contactmanagementapi.dao.ContactManagementDao;
import com.app.samples.contactmanagementapi.model.Address;
import com.app.samples.contactmanagementapi.model.Communication;
import com.app.samples.contactmanagementapi.model.Contact;
import com.app.samples.contactmanagementapi.model.Identification;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContactManagementApiUtil {

	private static Logger logger = Logger.getLogger(ContactManagementApiUtil.class.getName());
	
	{
		/*
		 * "Identification": { "FirstName": "Bob", "LastName": "Frederick", "DOB":
		 * "06/21/1980", "Gender": "M", "Title": "Manager" }, "Address": [{ "type ":
		 * "home", "number": 1234, "street": "blah blah St", "Unit": "1 a", "City":
		 * "Somewhere", "State": "WV", "zipcode": "12345" }], "Communication": [{
		 * "type": "email", "value": "bfe@sample.com", "preferred" : "true" }, { "type":
		 * "cell", "value": "304-555-8282" } ]
		 */}
	
	public static Contact createContact(Contact contact) {
		Identification identification = null;
		List<Address> addressList = null;
		List<Communication> communicationsList = null;
		Address address = new Address();
		Address address1 = new Address();
		Communication communication = new Communication();
		Communication communication1 = new Communication();
		if(contact != null) {
			//construct identification object
			identification = contact.getIdentification();
			identification.setFirstName("Bob");
			identification.setLastName("Frederick");
			identification.setDOB("06/21/1980");
			identification.setGender("M");
			identification.setTitle("Manager");
			
			//construct address object			
			addressList = contact.getAddress();
			address.setType("home");
			address.setNumber(new BigDecimal(1234));
			address.setStreet("blah blah St");
			address.setUnit("1 a");
			address.setCity("Somewhere");
			address.setState("WV");
			address.setZipcode("12345");
			addressList.add(address);
			
			address1.setType("office");
			address1.setNumber(new BigDecimal(4321));
			address1.setStreet("utanpalli chourasta");
			address1.setUnit("2 a");
			address1.setCity("hyd");
			address1.setState("TS");
			address1.setZipcode("54321");
			addressList.add(address1);
			
			//construct communication object
			communicationsList = contact.getCommunication();
			communication.setPreferred("true");
			communication.setType("email");
			communication.setValue("bfe@sample.com");
			communicationsList.add(communication);
			
			communication1.setType("cell");
			communication1.setValue("304-555-8282");
			communicationsList.add(communication1);
			
			contact.setIdentification(identification);
			contact.setAddress(addressList);
			contact.setCommunication(communicationsList);
			
			logger.info("Contact Details : "+contact.toString());
			
		}
		return contact;		
	}
	
	public static void createJson(Contact contact) {
		//Contact contact1 = createContact(contact);
		//Convert it into Json String and store it into the file
		File file = null;
		ObjectMapper objectMapper = new ObjectMapper();
		StringBuffer stringBuffer = null;
		FileWriter fileWriter = null;
		try {
			file = new File("testcontact.json");
			fileWriter = new FileWriter(file);
			//objectMapper.writeValue(file, contact);
			String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(contact);
			stringBuffer = new StringBuffer(json);
			fileWriter.write(json);
			logger.info("file location : "+file.getAbsolutePath());	
			logger.info("json object : "+stringBuffer.toString());
			fileWriter.flush();
			fileWriter.close();
		}
		catch(IOException exception) {
			exception.printStackTrace();
		}
	}
}
