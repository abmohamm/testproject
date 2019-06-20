package com.app.samples.contactmanagementapi.controller;

import java.math.BigDecimal;
import java.util.logging.Logger;

import javax.validation.metadata.MethodType;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.samples.contactmanagementapi.model.Contact;
import com.app.samples.contactmanagementapi.model.ContactResponse;
import com.app.samples.contactmanagementapi.service.IContactManagementService;
import static com.app.samples.contactmanagementapi.constants.DBConstans.*;


// TODO: Auto-generated Javadoc
/**
 * The Class ContactManagementController.
 */
@RestController
@RequestMapping("/contact")
public class ContactManagementController {

	/** The class name. */
	private static String CLASS_NAME = "ContactManagementController";

	/** The logger. */
	Logger logger = Logger.getLogger(ContactManagementController.class.getName());

	/** The contact management service. */
	@Autowired
	IContactManagementService contactManagementService;

	/**
	 * Creates the contact.
	 *
	 * @param contact the contact
	 * @return the response entity
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ContactResponse> addContact(@RequestBody Contact contact) {
		ResponseEntity<ContactResponse> responseEntity = null;
		ContactResponse contactResponse = null;
		logger.info("request sent is : "+contact.toString());
		logger.info("request for given id : "+contact.getIdentification().getId());
		try {
			contactResponse = contactManagementService.addContactDetails(contact);
			responseEntity = new ResponseEntity<ContactResponse>(contactResponse,HttpStatus.OK);
		}
		catch(DataAccessException accessException) {
			contactResponse = new ContactResponse();
			contactResponse.setResponseCode(RESPONSE_FAILED);
			responseEntity = new ResponseEntity<ContactResponse>(contactResponse,HttpStatus.NOT_IMPLEMENTED);

		}
		return responseEntity;
	}
	
	/**
	 * Gets the contact details based on id.
	 *
	 * @param contact the contact
	 * @return the contact details based on id
	 */
	@RequestMapping(value="/getcontactdetails", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ContactResponse> getContactDetailsBasedOnId(@RequestBody Contact contact){
		ContactResponse contactResponse = null;
		ResponseEntity<ContactResponse> responseEntity = null;
		BigDecimal id = null;
		try {
			if(contact != null) {
				id = contact.getIdentification().getId();
				logger.info("request for given id : "+id);
				contactResponse = contactManagementService.getContactDetailsBasedOnId(id);
				responseEntity = new ResponseEntity<ContactResponse>(contactResponse,HttpStatus.OK);
			}
		}
		catch(DataAccessException dataAccessException) {
			contactResponse = new ContactResponse();
			contactResponse.setResponseMsg(RESPONSE_INTERNAL_SERVER_ERROR);
			contactResponse.setResponseCode(RESPONSE_FAILED);
			responseEntity = new ResponseEntity<ContactResponse>(contactResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	/**
	 * Update contact.
	 *
	 * @param contact the contact
	 * @return the response entity
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ContactResponse> updateContact(@RequestBody Contact contact) {
		ResponseEntity<ContactResponse> responseEntity = null;
		ContactResponse contactResponse = null;
		logger.info("request sent is : "+contact.toString());
		logger.info("request for given id : "+contact.getIdentification().getId());
		try {
			contactResponse = contactManagementService.updateContactDetails(contact);
			responseEntity = new ResponseEntity<ContactResponse>(contactResponse,HttpStatus.OK);
		}
		catch(DataAccessException accessException) {
			contactResponse = new ContactResponse();
			contactResponse.setResponseCode(RESPONSE_FAILED);
			responseEntity = new ResponseEntity<ContactResponse>(contactResponse,HttpStatus.NOT_IMPLEMENTED);

		}
		return responseEntity;
	}
}
