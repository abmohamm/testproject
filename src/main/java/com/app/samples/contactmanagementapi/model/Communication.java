package com.app.samples.contactmanagementapi.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class Communication.
 */
@JsonPropertyOrder({"Type","Value","Preferred"})
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Communication {
	
	/** The Type. */
	@JsonProperty
	private String Type;
	
	/** The Value. */
	@JsonProperty
	private String Value;
	
	/** The Preferred. */
	@JsonProperty
	private String Preferred;
	
	/**
	 * Instantiates a new communication.
	 */
	public Communication() {
		super();
	}

	/**
	 * Instantiates a new communication.
	 *
	 * @param Type the Type
	 * @param Value the Value
	 * @param Preferred the Preferred
	 */
	public Communication(String Type, String Value, String Preferred) {
		super();
		this.Type = Type;
		this.Value = Value;
		this.Preferred = Preferred;
	}

	/**
	 * Gets the Type.
	 *
	 * @return the Type
	 */
	public String getType() {
		return Type;
	}

	/**
	 * Sets the Type.
	 *
	 * @param Type the new Type
	 */
	public void setType(String Type) {
		this.Type = Type;
	}

	/**
	 * Gets the Value.
	 *
	 * @return the Value
	 */
	public String getValue() {
		return Value;
	}

	/**
	 * Sets the Value.
	 *
	 * @param Value the new Value
	 */
	public void setValue(String Value) {
		this.Value = Value;
	}

	/**
	 * Checks if is Preferred.
	 *
	 * @return true, if is Preferred
	 */
	public String getPreferred() {
		return Preferred;
	}

	/**
	 * Sets the Preferred.
	 *
	 * @param Preferred the new Preferred
	 */
	public void setPreferred(String Preferred) {
		this.Preferred = Preferred;
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
		return "Communication [Type=" + Type + ", Value=" + Value + ", Preferred=" + Preferred +"]";
	}
	
	
	
	

}
