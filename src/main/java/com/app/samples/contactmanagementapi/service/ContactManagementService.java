package com.app.samples.contactmanagementapi.service;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.app.samples.contactmanagementapi.dao.ContactManagementDao;
import com.app.samples.contactmanagementapi.model.Contact;
import com.app.samples.contactmanagementapi.model.ContactResponse;
import static com.app.samples.contactmanagementapi.constants.DBConstans.*;


// TODO: Auto-generated Javadoc
/**
 * The Class ContactManagementService.
 */
@Service
public class ContactManagementService implements IContactManagementService{

	/** The logger. */
	Logger logger = Logger.getLogger(ContactManagementService.class.getName());

	/** The contact management dao. */
	@Autowired
	ContactManagementDao contactManagementDao;

	/**
	 * Adds the contact.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	/* (non-Javadoc)
	 * @see com.app.samples.contactmanagementapi.service.IContactManagementService#addContact(com.app.samples.contactmanagementapi.model.Contact)
	 */
	@Override
	public ContactResponse addContactDetails(Contact contact) {
		//ContactResponse contactResponse = new ContactResponse();
		logger.info("Contact Details : "+contact.toString());
		logger.info("Address size : "+contact.getAddress().size());
		logger.info("Communication size : "+contact.getCommunication().size());
		ContactResponse contactResponse = null;
		try {
			if(contact != null) {
				contactResponse = contactManagementDao.addContactDetails(contact);
			}
		}
		catch (DataAccessException dataAccessException) {
			contactResponse = new ContactResponse();
			contactResponse.setResponseCode(RESPONSE_FAILED);
			contactResponse.setResponseMsg(RESPONSE_INTERNAL_SERVER_ERROR);
		}

		return contactResponse;
	}

	/**
	 * Update contact based on id.
	 *
	 * @param id the id
	 * @return the contact response
	 */
	/* (non-Javadoc)
	 * @see com.app.samples.contactmanagementapi.service.IContactManagementService#updateContactBasedOnId(int)
	 */
	@Override
	public ContactResponse updateContactBasedOnId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gets the contact details based on id.
	 *
	 * @param id the id
	 * @return the contact details based on id
	 */
	/* (non-Javadoc)
	 * @see com.app.samples.contactmanagementapi.service.IContactManagementService#getContactDetailsBasedOnId(int)
	 */
	@Override
	public ContactResponse getContactDetailsBasedOnId(BigDecimal id) {
		ContactResponse contactResponse = null;
		try {
			contactResponse = contactManagementDao.getContactDetailsBasedOnId(id);
			if(contactResponse.getContact().getIdentification() == null) {
				contactResponse.setResponseMsg(RESPONSE_NO_RECORDS);
				contactResponse.setResponseCode(RESPONSE_NOT_FOUND);
			}
			logger.info("Contact Response : "+contactResponse.toString());
		}
		catch(DataAccessException dataAccessException) {
			contactResponse = new ContactResponse();
			contactResponse.setResponseMsg(RESPONSE_INTERNAL_SERVER_ERROR);
			contactResponse.setResponseCode(RESPONSE_FAILED);

		}
		return contactResponse;
	}

	/**
	 * Update contact details.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	@Override
	public ContactResponse updateContactDetails(Contact contact) {
		//ContactResponse contactResponse = new ContactResponse();
		logger.info("Contact Details to be updated : "+contact.toString());
		logger.info("Address size : "+contact.getAddress().size());
		logger.info("Communication size : "+contact.getCommunication().size());
		ContactResponse contactResponse = null;
		try {
			if(contact != null) {
				contactResponse = contactManagementDao.updateContactDetails(contact);
			}
		}
		catch (DataAccessException dataAccessException) {
			contactResponse = new ContactResponse();
			contactResponse.setResponseCode(RESPONSE_FAILED);
			contactResponse.setResponseMsg(RESPONSE_INTERNAL_SERVER_ERROR);
		}

		return contactResponse;
	}

	/**
	 * Delete contact details based on id.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	@Override
	public ContactResponse deleteContactDetailsBasedOnId(Contact contact) {
		ContactResponse contactResponse = null;
		if(contact != null) {
			logger.info("Contact Request : "+contact.toString());
			contactResponse = contactManagementDao.deleteContactDetailsBasedOnId(contact);
		}
		logger.info("contact Response after deleting Contact Details : "+contactResponse.toString());
		return contactResponse;
	}

	/**
	 * Check id.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	@Override
	public ContactResponse checkId(Contact contact) {
		ContactResponse contactResponse = null;
		if(contact!= null) {
			contactResponse = contactManagementDao.checkId(contact);
			logger.info("Contact Response check for a given id : "+contactResponse.isCheckId());
		}
		return contactResponse;
	}
}
