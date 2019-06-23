package com.app.samples.contactmanagementapi.constants;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConstans.
 */
public class DBConstans {	
	
	/** The Constant RESPONSE_MSG. */
	public static final String RESPONSE_MSG = "RESPONSE_MSG";
	
	/** The Constant CONTACT_ID. */
	//Identification table constants
	public static final String CONTACT_ID = "CONTACT_ID";
	
	/** The Constant FIRST_NAME. */
	public static final String FIRST_NAME = "FIRST_NAME";
	
	/** The Constant LAST_NAME. */
	public static final String LAST_NAME = "LAST_NAME";
	
	/** The Constant DATE_OF_BIRTH. */
	public static final String DATE_OF_BIRTH = "DATE_OF_BIRTH";
	
	/** The Constant GENDER. */
	public static final String GENDER = "GENDER";
	
	/** The Constant TITLE. */
	public static final String TITLE = "TITLE";
	
	/** The Constant ID_LST_MDF_TS. */
	public static final String ID_LST_MDF_TS = "ID_LST_MDF_TS";
	
	/** The Constant ADDRESS_TYPE. */
	//Address table constants
	public static final String ADDRESS_TYPE = "ADDRESS_TYPE";
	
	/** The Constant AD_NUMBER. */
	public static final String AD_NUMBER = "AD_NUMBER";
	
	/** The Constant STREET. */
	public static final String STREET = "STREET";
	
	/** The Constant UNIT. */
	public static final String UNIT = "UNIT";
	
	/** The Constant CITY. */
	public static final String CITY = "CITY";
	
	/** The Constant STATE. */
	public static final String STATES = "STATES";
	
	/** The Constant ZIPCODE. */
	public static final String ZIPCODE = "ZIPCODE";
	
	/** The Constant ADDRESS_ID. */
	public static final String ADDRESS_ID = "ADDRESS_ID";
	
	/** The Constant AD_LST_MDF_TS. */
	public static final String AD_LST_MDF_TS = "AD_LST_MDF_TS";
	
	/** The Constant COM_TYPE. */
	//Communication table constants
	public static final String COM_TYPE = "COM_TYPE";
	
	/** The Constant VALUE. */
	public static final String VALUESS = "VALUESS";
	
	/** The Constant PREFERRED. */
	public static final String PREFERRED = "PREFERRED";
	
	/** The Constant COM_ID. */
	public static final String COM_ID = "COM_ID";
	
	/** The Constant COM_LST_MDF_TS. */
	public static final String COM_LST_MDF_TS = "COM_LST_MDF_TS";
	
	/** The Constant RESPONSE_SUCCESS. */
	//Response status codes
	public static final String RESPONSE_SUCCESS = "200";
	
	/** The Constant RESPONSE_FAILED. */
	public static final String RESPONSE_FAILED = "500";
	
	/** The Constant RESPONSE_NOT_FOUND. */
	public static final String RESPONSE_NOT_FOUND = "404";
	
	/** The Constant RESPONSE_OK. */
	//Response status messages
	public static final String RESPONSE_OK = "OK";
	
	/** The Constant RESPONSE_NO_RECORDS. */
	public static final String RESPONSE_NO_RECORDS = "Records Not Found";
	
	/** The Constant RESPONSE_FOUND. */
	public static final String RESPONSE_FOUND = "Records Found";
	
	/** The Constant RESPONSE_INTERNAL_SERVER_ERROR. */
	public static final String RESPONSE_INTERNAL_SERVER_ERROR = "Internal Server Error";
	
	/** The Constant IN_CONTACT_ID. */
	//Stored Procedure : ADD_ID_DETAILS input parameters to Identification Table
	public static final String IN_CONTACT_ID = "IN_CONTACT_ID";
	
	/** The Constant IN_FIRST_NAME. */
	public static final String IN_FIRST_NAME = "IN_FIRST_NAME";
	
	/** The Constant IN_LAST_NAME. */
	public static final String IN_LAST_NAME = "IN_LAST_NAME";
	
	/** The Constant IN_DATE_OF_BIRTH. */
	public static final String IN_DATE_OF_BIRTH = "IN_DATE_OF_BIRTH";
	
	/** The Constant IN_GENDER. */
	public static final String IN_GENDER = "IN_GENDER";
	
	/** The Constant IN_TITLE. */
	public static final String IN_TITLE = "IN_TITLE";
		
	/** The Constant IN_ADDRESS_TYPE. */
	//Stored Procedure : ADD_ADDRESS_DETAILS input parameters to Address Table
	public static final String IN_ADDRESS_TYPE = "IN_ADDRESS_TYPE";
	
	/** The Constant IN_AD_NUMBER. */
	public static final String IN_AD_NUMBER = "IN_AD_NUMBER";
	
	/** The Constant IN_STREET. */
	public static final String IN_STREET = "IN_STREET";
	
	/** The Constant IN_UNIT. */
	public static final String IN_UNIT = "IN_UNIT";
	
	/** The Constant IN_CITY. */
	public static final String IN_CITY = "IN_CITY";
	
	/** The Constant IN_STATE. */
	public static final String IN_STATE = "IN_STATE";
	
	/** The Constant IN_ZIPCODE. */
	public static final String IN_ZIPCODE = "IN_ZIPCODE";
	
	/** The Constant IN_ADDRESS_ID. */
	public static final String IN_ADDRESS_ID = "IN_ADDRESS_ID";
	
	/** The Constant IN_ROW_NUM. */
	public static final String IN_ROW_NUM = "IN_ROW_NUM";
	
	/** The Constant IN_COM_TYPE. */
	//Stored Procedure : ADD_COMMUNICATION_DETAILS input parameters to Communication Table
	public static final String IN_COM_TYPE = "IN_COM_TYPE";
	
	/** The Constant IN_VALUE. */
	public static final String IN_VALUE = "IN_VALUE";
	
	/** The Constant IN_PREFERRED. */
	public static final String IN_PREFERRED = "IN_PREFERRED";
	
	/** The Constant IN_COM_ID. */
	public static final String IN_COM_ID = "IN_COM_ID";	
	
	/** The Constant ADD_ID_DETAILS. */
	//Stored Procedure names
	public static final String ADD_ID_DETAILS = "ADD_ID_DETAILS";
	
	/** The Constant ADD_ADDRESS_DETAILS. */
	public static final String ADD_ADDRESS_DETAILS = "ADD_ADDRESS_DETAILS";
	
	/** The Constant ADD_COMMUNICATION_DETAILS. */
	public static final String ADD_COMMUNICATION_DETAILS = "ADD_COMMUNICATION_DETAILS";
	
	/** The Constant UPDATE_ID_DETAILS. */
	public static final String UPDATE_ID_DETAILS = "UPDATE_ID_DETAILS";
	
	/** The Constant UPDATE_ADDRESS_DETAILS. */
	public static final String UPDATE_ADDRESS_DETAILS = "UPDATE_ADDRESS_DETAILS";
	
	/** The Constant UPDATE_COMMUNICATION_DETAILS. */
	public static final String UPDATE_COMMUNICATION_DETAILS = "UPDATE_COMMUNICATION_DETAILS";
	
	/** The Constant DELETE_CONTACT_DETAILS. */
	public static final String DELETE_CONTACT_DETAILS = "DELETE_CONTACT_DETAILS";
	
	
	/** The Constant REC_NOT_INSERTED. */
	public static final String REC_NOT_INSERTED = "Record not inserted into database";
	
	/** The Constant REC_NOT_UPDATED. */
	public static final String REC_NOT_UPDATED = "Record not updated in database";
	
	/** The Constant REC_FOUND. */
	public static final String REC_FOUND = "Records Found";
	
	/** The Constant CONTACT_SAVED. */
	public static final String CONTACT_SAVED = "Identification record inserted successfully\r\n" + 
											   "Address record inserted successfully\r\n" + 
											   "Communication record inserted successfully";
	
	/** The Constant CONTACT_UPDATED. */
	public static final String CONTACT_UPDATED = "Contact details updated successfully";
	
	/** The Constant CONTACT_NOT_SAVED. */
	public static final String CONTACT_NOT_SAVED = "Contact Details Not Inserted Successfully"; 
	
	/** The Constant CONTACT_NOT_UPDATED. */
	public static final String CONTACT_NOT_UPDATED = "Contact Details Not Updated Successfully";
	
	/** The Constant CONTACT_NOT_DELETED. */
	public static final String CONTACT_NOT_DELETED = "Contact Details Not Deleted Successfully";
	
	/** The Constant CONTACT_DELETED. */
	public static final String CONTACT_DELETED = "Contact Details deleted successfully";
	
	/** The Constant RESPONSE_SUCCESS_STATUS. */
	public static final String RESPONSE_SUCCESS_STATUS = "success";
	
	/** The Constant RESPONSE_FAIL_STATUS. */
	public static final String RESPONSE_FAIL_STATUS = "failed";
	
	/** The Constant NO_CONTACT_ID. */
	public static final String NO_CONTACT_ID = "That Id does not exists";
	
	
}
