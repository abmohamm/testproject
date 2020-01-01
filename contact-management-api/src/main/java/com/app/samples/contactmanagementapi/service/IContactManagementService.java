/*
 * 
 */
package com.app.samples.contactmanagementapi.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.app.samples.contactmanagementapi.model.ConferenceStudent;
import com.app.samples.contactmanagementapi.model.Contact;
import com.app.samples.contactmanagementapi.model.ContactResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface IContactManagementService.
 */
public interface IContactManagementService {
	
	//This service interface contains methods to make CRUD operations.
	
	/**
	 * Adds the contact.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	//add operation
	public ContactResponse addContactDetails(Contact contact);
	
	/**
	 * Update contact based on id.
	 *
	 * @param id the id
	 * @return the contact response
	 */
	//update operation
	public ContactResponse updateContactBasedOnId(int id);
	
	/**
	 * Gets the contact details based on id.
	 *
	 * @param id the id
	 * @return the contact details based on id
	 */
	//get operation
	public ContactResponse getContactDetailsBasedOnId(BigDecimal id);
	
	/**
	 * Update contact details.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	public ContactResponse updateContactDetails(Contact contact);
	
	/**
	 * Delete contact details based on id.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	public ContactResponse deleteContactDetailsBasedOnId(Contact contact);
	
	
	/**
	 * Check id.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	public ContactResponse checkId(Contact contact);
	
	/**
	 * Read excel and save it.
	 *
	 * @param inputStream the input stream
	 */
	public void readExcelAndSaveIt(InputStream inputStream);
	
	/**
	 * Adds the conference student.
	 *
	 * @param inputStream the input stream
	 * @return the list
	 */
	public ContactResponse readConferenceStudentExcel(InputStream inputStream) throws IOException, DataAccessException;
	
	/**
	 * Adds the conference students information.
	 *
	 * @param conferenceStudentsList the conference students list
	 * @throws Exception the exception
	 */
	public ContactResponse addConferenceStudentsInformation(List<ConferenceStudent> conferenceStudentsList) throws Exception;
	
	
	}
