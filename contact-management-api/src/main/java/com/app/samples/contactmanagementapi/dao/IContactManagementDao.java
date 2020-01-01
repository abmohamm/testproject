package com.app.samples.contactmanagementapi.dao;

import java.math.BigDecimal;
import java.util.List;

import com.app.samples.contactmanagementapi.model.Address;
import com.app.samples.contactmanagementapi.model.Communication;
import com.app.samples.contactmanagementapi.model.ConferenceStudent;
import com.app.samples.contactmanagementapi.model.Contact;
import com.app.samples.contactmanagementapi.model.ContactResponse;
import com.app.samples.contactmanagementapi.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface IContactManagementDao.
 */
public interface IContactManagementDao {
	
	//This dao interface contains methods to make CRUD operations.
	
		/**
	 * Adds the contact details.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	//add operation
		public ContactResponse addContactDetails(Contact contact);
		
		/**
		 * Gets the contact details based on id.
		 *
		 * @param id the id
		 * @return the contact details based on id
		 */
		//get operation
		public ContactResponse getContactDetailsBasedOnId(BigDecimal id);
		
		
		/**
		 * Adds the identification.
		 *
		 * @param contact the contact
		 * @return the contact response
		 */
		//method to add Identification Details		
		public ContactResponse addIdentification(Contact contact);
		
		/**
		 * Adds the address.
		 *
		 * @param contact the contact
		 * @return the contact response
		 */
		//method to add Address Details		
		public ContactResponse addAddress(Contact contact);
		
		/**
		 * Adds the communication.
		 *
		 * @param contact the contact
		 * @return the contact response
		 */
		//method to Communication Details		
		public ContactResponse addCommunication(Contact contact);
		
		/**
		 * Update identification.
		 *
		 * @param contact the contact
		 * @return the contact response
		 */
		public ContactResponse updateIdentification(Contact contact);
		
		/**
		 * Update address.
		 *
		 * @param contact the contact
		 * @return the contact response
		 */
		public ContactResponse updateAddress(Contact contact);
		
		/**
		 * Update communication.
		 *
		 * @param contact the contact
		 * @return the contact response
		 */
		public ContactResponse updateCommunication(Contact contact);
		
		
		/**
		 * Delete contact details based on id.
		 *
		 * @param contact the contact
		 * @return the contact response
		 */
		public ContactResponse deleteContactDetailsBasedOnId(Contact contact);
		
		
		/**
		 * Gets the ids.
		 *
		 * @param contact the contact
		 * @return the ids
		 */
		public ContactResponse checkId(Contact contact);
		
		
		/**
		 * Gets the row ids.
		 *
		 * @param contact the contact
		 * @return the row ids
		 */
		public ContactResponse getAddressRowIds(Contact contact);
		
		
		/**
		 * Gets the communication row ids.
		 *
		 * @param contact the contact
		 * @return the communication row ids
		 */
		public ContactResponse getCommunicationRowIds(Contact contact);
		
		/**
		 * Adds the employee.
		 *
		 * @param employee the employee
		 * @throws Exception the exception
		 */
		public void addEmployee(Employee employee) throws Exception;
		
		/**
		 * Adds the conference students information.
		 *
		 * @param conferenceStudentsList the conference students list
		 * @throws Exception the exception
		 */
		public ContactResponse addConferenceStudentsInformation(List<ConferenceStudent> conferenceStudentsList) throws Exception;
		
		
	

}
