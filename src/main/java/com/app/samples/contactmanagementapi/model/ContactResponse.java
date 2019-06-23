package com.app.samples.contactmanagementapi.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactResponse.
 */
public class ContactResponse {
	
	/** The response msg. */
	@JsonProperty
	private String responseMsg;
	
	/** The response code. */
	@JsonProperty
	private String responseCode;
	
	/** The actual response. */
	@JsonProperty
	private String actualResponse;
	
	/** The response status. */
	@JsonProperty
	private String responseStatus;
	
	/** The contact. */
	@JsonProperty
	private Contact contact;
	
	
	/** The id records. */
	@JsonProperty
	private List<Map<String,Object>> idRecords;

	/** The check id. */
	private boolean checkId;
	
	
	/**
	 * Instantiates a new contact response.
	 */
	public ContactResponse() {
		super();
	}
	
	/**
	 * Gets the response msg.
	 *
	 * @return the response msg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}

	/**
	 * Instantiates a new contact response.
	 *
	 * @param responseMsg the response msg
	 * @param responseCode the response code
	 * @param actualResponse the actual response
	 * @param responseStatus the response status
	 * @param contact the contact
	 * @param idRecords the id records
	 * @param checkId the check id
	 */
	public ContactResponse(String responseMsg, String responseCode, String actualResponse, String responseStatus,
			Contact contact, List<Map<String, Object>> idRecords, boolean checkId) {
		super();
		this.responseMsg = responseMsg;
		this.responseCode = responseCode;
		this.actualResponse = actualResponse;
		this.responseStatus = responseStatus;
		this.contact = contact;
		this.idRecords = idRecords;
		this.checkId = checkId;
	}






	/**
	 * Sets the response msg.
	 *
	 * @param responseMsg the new response msg
	 */
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	/**
	 * Gets the response code.
	 *
	 * @return the response code
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * Sets the response code.
	 *
	 * @param responseCode the new response code
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Gets the actual response.
	 *
	 * @return the actual response
	 */
	public String getActualResponse() {
		return actualResponse;
	}

	/**
	 * Sets the actual response.
	 *
	 * @param actualResponse the new actual response
	 */
	public void setActualResponse(String actualResponse) {
		this.actualResponse = actualResponse;
	}

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * Gets the response status.
	 *
	 * @return the response status
	 */
	public String getResponseStatus() {
		return responseStatus;
	}

	/**
	 * Sets the response status.
	 *
	 * @param responseStatus the new response status
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * Gets the id records.
	 *
	 * @return the id records
	 */
	public List<Map<String, Object>> getIdRecords() {
		return idRecords;
	}

	/**
	 * Sets the id records.
	 *
	 * @param idRecords the id records
	 */
	public void setIdRecords(List<Map<String, Object>> idRecords) {
		this.idRecords = idRecords;
	}

	/**
	 * Checks if is check id.
	 *
	 * @return true, if is check id
	 */
	public boolean isCheckId() {
		return checkId;
	}

	/**
	 * Sets the check id.
	 *
	 * @param checkId the new check id
	 */
	public void setCheckId(boolean checkId) {
		this.checkId = checkId;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ContactResponse [responseMsg=" + responseMsg + ", responseCode=" + responseCode + ", actualResponse="
				+ actualResponse + ", responseStatus=" + responseStatus + ", contact=" + contact + ", idRecords="
				+ idRecords + ", checkId=" + checkId + "]";
	}
	
	
	
	


}
