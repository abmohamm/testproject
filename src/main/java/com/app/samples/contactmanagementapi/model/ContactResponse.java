package com.app.samples.contactmanagementapi.model;

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
	
	@JsonProperty
	private String responseStatus;
	
	/** The contact. */
	@JsonProperty
	private Contact contact;

	/**
	 * Instantiates a new contact response.
	 */
	public ContactResponse() {
		super();
	}

	

	public ContactResponse(String responseMsg, String responseCode, String actualResponse, String responseStatus,
			Contact contact) {
		super();
		this.responseMsg = responseMsg;
		this.responseCode = responseCode;
		this.actualResponse = actualResponse;
		this.responseStatus = responseStatus;
		this.contact = contact;
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



	public String getResponseStatus() {
		return responseStatus;
	}



	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}



	@Override
	public String toString() {
		return "ContactResponse [responseMsg=" + responseMsg + ", responseCode=" + responseCode + ", actualResponse="
				+ actualResponse + ", responseStatus=" + responseStatus + ", contact=" + contact + ", getResponseMsg()="
				+ getResponseMsg() + ", getResponseCode()=" + getResponseCode() + ", getActualResponse()="
				+ getActualResponse() + ", getContact()=" + getContact() + ", getResponseStatus()="
				+ getResponseStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
	
	

}
