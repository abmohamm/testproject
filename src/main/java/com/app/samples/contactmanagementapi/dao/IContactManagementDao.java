package com.app.samples.contactmanagementapi.dao;

import java.math.BigDecimal;

import com.app.samples.contactmanagementapi.model.Address;
import com.app.samples.contactmanagementapi.model.Communication;
import com.app.samples.contactmanagementapi.model.Contact;
import com.app.samples.contactmanagementapi.model.ContactResponse;

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
		 * @return the ids
		 */
		public ContactResponse checkId(Contact contact);

}
