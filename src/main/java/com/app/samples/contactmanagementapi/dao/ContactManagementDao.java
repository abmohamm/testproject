package com.app.samples.contactmanagementapi.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.app.samples.contactmanagementapi.model.Address;
import com.app.samples.contactmanagementapi.model.Communication;
import com.app.samples.contactmanagementapi.model.Contact;
import com.app.samples.contactmanagementapi.model.ContactResponse;
import com.app.samples.contactmanagementapi.model.Identification;
import com.app.samples.contactmanagementapi.rowmapper.IdentificationRowMapper;

import static com.app.samples.contactmanagementapi.constants.DBConstans.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactManagementDao.
 */
@Repository
public class ContactManagementDao implements IContactManagementDao {

	/** The logger. */
	Logger logger = Logger.getLogger(ContactManagementDao.class.getName());

	/** The get sql. */
	@Value("${get.sql}")
	private String GET_SQL;

	/** The get sql identification. */
	@Value("${get.sql.identification}")
	private String GET_SQL_IDENTIFICATION;

	/** The get sql address. */
	@Value("${get.sql.address}")
	private String GET_SQL_ADDRESS;

	/** The get sql communication. */
	@Value("${get.sql.communication}")
	private String GET_SQL_COMMUNICATION;
		
	/** The delete sql identification. */
	@Value("${delete.sql.identification}")
	private String DELETE_SQL_IDENTIFICATION;
	
	/** The delete sql address. */
	@Value("${delete.sql.address}")
	private String DELETE_SQL_ADDRESS;
	
	
	/** The delete sql communication. */
	@Value("${delete.sql.communication}")
	private String DELETE_SQL_COMMUNICATION;
//1005';

	/** The jdbc template. */
	@Autowired
	JdbcTemplate jdbcTemplate; 

	/* (non-Javadoc)
	 * @see com.app.samples.contactmanagementapi.dao.IContactManagementDao#addContactDetails(com.app.samples.contactmanagementapi.model.Contact)
	 */
	/**
	 * Adds the contact details.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	//Contact contains Identification, Address and Communication details and should be inserted into respective tables
	public ContactResponse addContactDetails(Contact contact) {
		ContactResponse contactResponse = new ContactResponse();;
		try {
			//method to store Identification details
			ContactResponse addIdResponse = addIdentification(contact);
			logger.info("Identification : "+addIdResponse.getResponseMsg());
			//method to store Address details
			ContactResponse addAddressResponse = addAddress(contact);
			logger.info("Address : "+addAddressResponse.getResponseMsg());
			//method to store Communication details
			ContactResponse addCommResponse = addCommunication(contact);
			logger.info("Communication : "+addCommResponse.getResponseMsg());
			contactResponse.setResponseMsg(CONTACT_SAVED);
		}
		catch(DataAccessException dataAccessException) {
			contactResponse.setResponseMsg(CONTACT_NOT_SAVED);
			contactResponse.setResponseCode(RESPONSE_INTERNAL_SERVER_ERROR);
			contactResponse.setResponseCode(RESPONSE_FAILED);			
		}
		return contactResponse;
	}

	/* (non-Javadoc)
	 * @see com.app.samples.contactmanagementapi.dao.IContactManagementDao#addIdentification(com.app.samples.contactmanagementapi.model.Contact)
	 */
	/**
	 * Adds the identification.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	//This method will store the contact details inside Identification
	@Override
	public ContactResponse addIdentification(Contact contact) {
		logger.info("Identification Details : "+contact.getIdentification().toString());
		SimpleJdbcCall simpleJdbcCall = null;
		ContactResponse contactResponse = new ContactResponse();
		Identification identification = contact.getIdentification();
		try {
			Map<String,Object> inParams = new HashMap<String,Object>();
			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(ADD_ID_DETAILS);
			inParams.put(IN_CONTACT_ID, identification.getId());
			inParams.put(IN_FIRST_NAME, identification.getFirstName());
			inParams.put(IN_LAST_NAME, identification.getLastName());
			inParams.put(IN_DATE_OF_BIRTH,identification.getDOB());
			inParams.put(IN_GENDER,identification.getGender());
			inParams.put(IN_TITLE, identification.getTitle());
			SqlParameterSource parameterSource = new MapSqlParameterSource(inParams);
			Map<String,Object> simpleJdbcCallResult = simpleJdbcCall.execute(parameterSource);
			String responseMsg = (String)simpleJdbcCallResult.get(RESPONSE_MSG);
			contactResponse.setResponseMsg("Identification : "+responseMsg);
			contactResponse.setResponseCode(RESPONSE_SUCCESS);
			contactResponse.setResponseStatus(RESPONSE_SUCCESS_STATUS);
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while storing records : "+dataAccessException.toString());
			contactResponse.setResponseMsg("Identification : "+REC_NOT_INSERTED);
			contactResponse.setResponseCode(RESPONSE_INTERNAL_SERVER_ERROR);
		}
		return contactResponse;
	}

	/**
	 * Adds the address.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	/* (non-Javadoc)
	 * @see com.app.samples.contactmanagementapi.dao.IContactManagementDao#addAddress(com.app.samples.contactmanagementapi.model.Contact)
	 */
	@Override
	public ContactResponse addAddress(Contact contact) {
		SimpleJdbcCall simpleJdbcCall = null;
		Identification identification = null;
		Map<String,Object> simpleJdbcCallResult = null;
		ContactResponse contactResponse = new ContactResponse();
		List<Address> addressList = contact.getAddress();

		//Insert every Address record into Address table
		try {
			for(Address address : addressList) {
				logger.info("Address Details : "+address.toString());
				identification = contact.getIdentification();
				Map<String,Object> inParams = new HashMap<String,Object>();
				simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(ADD_ADDRESS_DETAILS);
				inParams.put(IN_ADDRESS_TYPE, address.getType());
				inParams.put(IN_AD_NUMBER, address.getNumber());
				inParams.put(IN_STREET, address.getStreet());
				inParams.put(IN_UNIT,address.getUnit());
				inParams.put(IN_CITY,address.getCity());
				inParams.put(IN_STATE, address.getState());
				inParams.put(IN_ZIPCODE, address.getZipcode());
				inParams.put(IN_ADDRESS_ID, identification.getId());
				SqlParameterSource parameterSource = new MapSqlParameterSource(inParams);
				simpleJdbcCallResult = simpleJdbcCall.execute(parameterSource);
				String responseMsg = (String)simpleJdbcCallResult.get(RESPONSE_MSG);
				contactResponse.setResponseMsg("Address : "+responseMsg);
				contactResponse.setResponseCode(RESPONSE_SUCCESS);
				contactResponse.setResponseStatus(RESPONSE_SUCCESS_STATUS);	
				logger.info("Response Message for Address Details : "+contactResponse.toString());
			}
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while storing records : "+dataAccessException.toString());
			contactResponse.setResponseCode(RESPONSE_INTERNAL_SERVER_ERROR);
			contactResponse.setResponseMsg("Address : "+REC_NOT_INSERTED);			
		}
		return contactResponse;
	}

	/**
	 * Adds the communication.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	/* (non-Javadoc)
	 * @see com.app.samples.contactmanagementapi.dao.IContactManagementDao#addCommunication(com.app.samples.contactmanagementapi.model.Contact)
	 */
	@Override
	public ContactResponse addCommunication(Contact contact) {
		SimpleJdbcCall simpleJdbcCall = null;
		Identification identification = null;
		Map<String,Object> simpleJdbcCallResult = null;
		ContactResponse contactResponse = new ContactResponse();
		List<Communication> communicationList = contact.getCommunication();

		//Insert every Address record into Communication table
		try {
			for(Communication communication : communicationList) {
				logger.info("Communication Details : "+communication.toString());
				identification = contact.getIdentification();
				Map<String,Object> inParams = new HashMap<String,Object>();
				simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(ADD_COMMUNICATION_DETAILS);
				inParams.put(IN_COM_TYPE, communication.getType());
				inParams.put(IN_VALUE, communication.getValue());
				inParams.put(IN_PREFERRED, communication.getPreferred());
				inParams.put(IN_COM_ID,identification.getId());
				SqlParameterSource parameterSource = new MapSqlParameterSource(inParams);
				simpleJdbcCallResult = simpleJdbcCall.execute(parameterSource);
				String responseMsg = (String)simpleJdbcCallResult.get(RESPONSE_MSG);
				contactResponse.setResponseMsg("Communication : "+responseMsg);
				contactResponse.setResponseCode(RESPONSE_SUCCESS);
				contactResponse.setResponseStatus(RESPONSE_SUCCESS_STATUS);
				
				logger.info("Response Message for Communication Details : "+contactResponse.toString());
			}
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while storing records : "+dataAccessException.toString());
			contactResponse.setResponseCode(RESPONSE_INTERNAL_SERVER_ERROR);
			contactResponse.setResponseMsg("Communication : "+REC_NOT_INSERTED);			
		}
		return contactResponse;
	}

	/**
	 * Gets the contact details based on id.
	 *
	 * @param id the id
	 * @return the contact details based on id
	 */
	/* (non-Javadoc)
	 * @see com.app.samples.contactmanagementapi.dao.IContactManagementDao#getContactDetailsBasedOnId(int)
	 */
	@Override
	public ContactResponse getContactDetailsBasedOnId(BigDecimal id) {
		ContactResponse contactResponse = new ContactResponse();
		Identification identification = null;
		List<Communication> communicationList = new ArrayList<>();
		List<Address> addressList = new ArrayList<>();
		Contact contact = new Contact();

		try {
			String sql = GET_SQL+id+"'";
			logger.info("sql query to pull info : "+sql);
			Map<String,Object> map = jdbcTemplate.queryForMap(sql);
			if(map.size() == 0) {
				contactResponse.setResponseMsg(RESPONSE_NOT_FOUND);
				contactResponse.setActualResponse(RESPONSE_NO_RECORDS);
			}
			else {
				String idSql = GET_SQL_IDENTIFICATION+id+"'";
				logger.info("sql query to pull identification info : "+idSql);				
				identification = jdbcTemplate.queryForObject(idSql, new IdentificationRowMapper());
				logger.info("Identification info : "+identification.toString());
				contact.setIdentification(identification);

				//Get Address for a given id
				String addressSql = GET_SQL_ADDRESS+id+"'";
				logger.info("sql query to pull address info : "+addressSql);
				List<Map<String,Object>> addrList = jdbcTemplate.queryForList(addressSql);
				for(Map<String,Object> addr : addrList) {
					Address address = new Address();
					address.setType((String)addr.get(ADDRESS_TYPE));
					address.setNumber((BigDecimal)addr.get(AD_NUMBER));
					address.setStreet((String)addr.get(STREET));
					address.setUnit((String)addr.get(UNIT));
					address.setCity((String)addr.get(CITY));
					address.setState((String)addr.get(STATES));
					address.setZipcode((String)addr.get(ZIPCODE));
					addressList.add(address);
				}
				contact.setAddress(addressList);

				logger.info("Address info : "+addressList.toString());

				String commSql = GET_SQL_COMMUNICATION+id+"'";
				logger.info("sql query to pull communication info : "+commSql);
				List<Map<String,Object>> commList = jdbcTemplate.queryForList(commSql);
				for(Map<String,Object> comm : commList) {
					Communication communication = new Communication();
					communication.setType((String)comm.get(COM_TYPE));
					communication.setValue((String)comm.get(VALUESS));
					communication.setPreferred((String)comm.get(PREFERRED));
					communicationList.add(communication);
				}
				contact.setCommunication(communicationList);

				logger.info("Communication info : "+communicationList.toString());
			}
			contactResponse.setResponseMsg(RESPONSE_SUCCESS_STATUS);
			contactResponse.setResponseCode(RESPONSE_SUCCESS);
			contactResponse.setActualResponse(REC_FOUND);
			contactResponse.setContact(contact);
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while getting records : "+dataAccessException.toString());
			contactResponse.setResponseCode(RESPONSE_INTERNAL_SERVER_ERROR);
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
	 * @see com.app.samples.contactmanagementapi.dao.IContactManagementDao#updateContactBasedOnId(int)
	 */
	@Override
	public ContactResponse updateContactBasedOnId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Update contact details.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	public ContactResponse updateContactDetails(Contact contact) {
		ContactResponse contactResponse = new ContactResponse();;
		try {
			//method to update Identification details
			ContactResponse updateIdResponse = updateIdentification(contact);
			logger.info("Identification : "+updateIdResponse.getResponseMsg());
			//method to update Address details
			ContactResponse updateAddressResponse = updateAddress(contact);
			logger.info("Address : "+updateAddressResponse.getResponseMsg());
			//method to update Communication details
			ContactResponse updateCommResponse = updateCommunication(contact);
			logger.info("Communication : "+updateCommResponse.getResponseMsg());
			contactResponse.setResponseMsg(CONTACT_UPDATED);
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while updating records : "+dataAccessException.toString());
			contactResponse.setResponseMsg(RESPONSE_INTERNAL_SERVER_ERROR);
			contactResponse.setResponseCode(RESPONSE_FAILED);
			contactResponse.setResponseStatus(RESPONSE_FAIL_STATUS);
		}
		return contactResponse;
	}
	
	/**
	 * Update identification.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	@Override
	public ContactResponse updateIdentification(Contact contact) {

		logger.info("Identification Details : "+contact.getIdentification().toString());
		SimpleJdbcCall simpleJdbcCall = null;
		ContactResponse contactResponse = new ContactResponse();
		Identification identification = contact.getIdentification();
		try {
			Map<String,Object> inParams = new HashMap<String,Object>();
			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(UPDATE_ID_DETAILS);
			inParams.put(IN_CONTACT_ID, identification.getId());
			inParams.put(IN_FIRST_NAME, identification.getFirstName());
			inParams.put(IN_LAST_NAME, identification.getLastName());
			inParams.put(IN_DATE_OF_BIRTH,identification.getDOB());
			inParams.put(IN_GENDER,identification.getGender());
			inParams.put(IN_TITLE, identification.getTitle());
			SqlParameterSource parameterSource = new MapSqlParameterSource(inParams);
			Map<String,Object> simpleJdbcCallResult = simpleJdbcCall.execute(parameterSource);
			String responseMsg = (String)simpleJdbcCallResult.get(RESPONSE_MSG);
			contactResponse.setResponseMsg("Identification : "+responseMsg);
			contactResponse.setResponseCode(RESPONSE_SUCCESS);
			contactResponse.setResponseStatus(RESPONSE_SUCCESS_STATUS);
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while updating identification records : "+dataAccessException.toString());
			contactResponse.setResponseMsg("Identification : "+REC_NOT_UPDATED);
			contactResponse.setResponseCode(RESPONSE_INTERNAL_SERVER_ERROR);
		}
		return contactResponse;
	}

	/**
	 * Update address.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	@Override
	public ContactResponse updateAddress(Contact contact) {
		SimpleJdbcCall simpleJdbcCall = null;
		Identification identification = null;
		Map<String,Object> simpleJdbcCallResult = null;
		ContactResponse contactResponse = new ContactResponse();
		List<Address> addressList = contact.getAddress();

		//Insert every Address record into Address table
		try {
			for(Address address : addressList) {
				logger.info("Address Details : "+address.toString());
				identification = contact.getIdentification();
				Map<String,Object> inParams = new HashMap<String,Object>();
				simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(UPDATE_ADDRESS_DETAILS);
				inParams.put(IN_ADDRESS_TYPE, address.getType());
				inParams.put(IN_AD_NUMBER, address.getNumber());
				inParams.put(IN_STREET, address.getStreet());
				inParams.put(IN_UNIT,address.getUnit());
				inParams.put(IN_CITY,address.getCity());
				inParams.put(IN_STATE, address.getState());
				inParams.put(IN_ZIPCODE, address.getZipcode());
				inParams.put(IN_ADDRESS_ID, identification.getId());
				SqlParameterSource parameterSource = new MapSqlParameterSource(inParams);
				simpleJdbcCallResult = simpleJdbcCall.execute(parameterSource);
				String responseMsg = (String)simpleJdbcCallResult.get(RESPONSE_MSG);
				contactResponse.setResponseMsg("Address : "+responseMsg);
				contactResponse.setResponseCode(RESPONSE_SUCCESS);
				contactResponse.setResponseStatus(RESPONSE_SUCCESS_STATUS);
				logger.info("Response Message for Address Details : "+contactResponse.toString());
			}
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while updating address records : "+dataAccessException.toString());
			contactResponse.setResponseCode(RESPONSE_INTERNAL_SERVER_ERROR);
			contactResponse.setResponseMsg("Address : "+REC_NOT_UPDATED);			
		}
		return contactResponse;
	}

	/**
	 * Update communication.
	 *
	 * @param contact the contact
	 * @return the contact response
	 */
	@Override
	public ContactResponse updateCommunication(Contact contact) {
		SimpleJdbcCall simpleJdbcCall = null;
		Identification identification = null;
		Map<String,Object> simpleJdbcCallResult = null;
		ContactResponse contactResponse = new ContactResponse();
		List<Communication> communicationList = contact.getCommunication();

		//Insert every Address record into Communication table
		try {
			for(Communication communication : communicationList) {
				logger.info("Communication Details : "+communication.toString());
				identification = contact.getIdentification();
				Map<String,Object> inParams = new HashMap<String,Object>();
				simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName(UPDATE_COMMUNICATION_DETAILS);
				inParams.put(IN_COM_TYPE, communication.getType());
				inParams.put(IN_VALUE, communication.getValue());
				inParams.put(IN_PREFERRED, communication.getPreferred());
				inParams.put(IN_COM_ID,identification.getId());
				SqlParameterSource parameterSource = new MapSqlParameterSource(inParams);
				simpleJdbcCallResult = simpleJdbcCall.execute(parameterSource);
				String responseMsg = (String)simpleJdbcCallResult.get(RESPONSE_MSG);
				contactResponse.setResponseMsg("Communication : "+responseMsg);
				contactResponse.setResponseCode(RESPONSE_SUCCESS);
				contactResponse.setResponseStatus(RESPONSE_SUCCESS_STATUS);
				logger.info("Response Message for Communication Details : "+contactResponse.toString());
			}
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while updating communication records : "+dataAccessException.toString());
			contactResponse.setResponseCode(RESPONSE_INTERNAL_SERVER_ERROR);
			contactResponse.setResponseMsg("Communication : "+REC_NOT_UPDATED);			
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
		ContactResponse contactResponse = new ContactResponse();
		BigDecimal id = contact.getIdentification().getId();
		try {
				String idSql = DELETE_SQL_IDENTIFICATION+id+"';commit;";
				logger.info("sql query to remove identification info : "+idSql);				
				jdbcTemplate.queryForList(idSql);
				logger.info("Identification Details is deleted successfully for a given : "+id);
				
				//Delete Address for a given id
				String addressSql = DELETE_SQL_ADDRESS+id+"';commit;";
				logger.info("sql query to pull address info : "+addressSql);
				jdbcTemplate.queryForList(addressSql);
				logger.info("Address Details is deleted for a given : "+id);
				
				String commSql = DELETE_SQL_COMMUNICATION+id+"';commit;";
				logger.info("sql query to pull communication info : "+commSql);
				jdbcTemplate.queryForList(commSql);
				logger.info("Communication Details deleted for a given : "+id);
				
				contactResponse.setResponseCode(RESPONSE_SUCCESS);
				contactResponse.setResponseMsg(CONTACT_DELETED);
				contactResponse.setResponseStatus(RESPONSE_SUCCESS_STATUS);
				
		}
		catch(DataAccessException dataAccessException) {
			logger.info("exception while deleting records : "+dataAccessException.toString());
			contactResponse.setResponseCode(RESPONSE_FAILED);
			contactResponse.setResponseMsg(RESPONSE_FAIL_STATUS);
			contactResponse.setResponseStatus(RESPONSE_FAIL_STATUS);
		}
		return contactResponse;
	}
}
