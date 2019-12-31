package com.app.samples.contactmanagementapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class Contact.
 */
@JsonPropertyOrder({"Identification","Address","Communication"})
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Contact {
	
	/** The identification. */
	@JsonProperty
	private Identification Identification;
	
	/** The address list. */
	@JsonProperty
	private List<Address> Address;
	
	/** The communication list. */
	@JsonProperty
	private List<Communication> Communication;

	/**
	 * Instantiates a new contact.
	 */
	public Contact() {
		super();
	}

	/**
	 * Instantiates a new contact.
	 *
	 * @param Identification the identification
	 * @param Address the address
	 * @param Communication the communication
	 */
	public Contact(Identification Identification,
			List<com.app.samples.contactmanagementapi.model.Address> Address,
			List<com.app.samples.contactmanagementapi.model.Communication> Communication) {
		super();
		this.Identification = Identification;
		this.Address = Address;
		this.Communication = Communication;
	}

	/**
	 * Gets the identification object.
	 *
	 * @return the identification object
	 */
	public Identification getIdentification() {
		return Identification;
	}

	/**
	 * Sets the identification object.
	 *
	 * @param Identification the new identification
	 */
	public void setIdentification(Identification Identification) {
		this.Identification = Identification;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public List<Address> getAddress() {
		return Address;
	}

	/**
	 * Sets the address.
	 *
	 * @param Address the new address
	 */
	public void setAddress(List<Address> Address) {
		this.Address = Address;
	}

	/**
	 * Gets the communication.
	 *
	 * @return the communication
	 */
	public List<Communication> getCommunication() {
		return Communication;
	}

	/**
	 * Sets the communication.
	 *
	 * @param Communication the new communication
	 */
	public void setCommunication(List<Communication> Communication) {
		this.Communication = Communication;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [IdentificationObject=" + Identification.toString() + ", Address=" + Address.toString() + ", Communication="
				+ Communication.toString() + "]";
	}

	
}
