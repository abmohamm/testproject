package com.app.samples.contactmanagementapi.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class Address.
 */
@JsonPropertyOrder({"Type","Number","Street","Unit","City","State","Zipcode"})
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Address {
	
	/** The Type. */
	@JsonProperty
	private String Type;
	
	/** The Number. */
	@JsonProperty
	private BigDecimal Number;
	
	/** The Street. */
	@JsonProperty
	private String Street;
	
	/** The unit. */
	@JsonProperty
	private String Unit;
	
	/** The city. */
	@JsonProperty
	private String City;
	
	/** The state. */
	@JsonProperty
	private String State;
	
	/** The zip code. */
	@JsonProperty
	private String Zipcode;

	/**
	 * Instantiates a new address.
	 */
	public Address() {
		super();
	}

	/**
	 * Instantiates a new address.
	 *
	 * @param Type the Type
	 * @param Number the Number
	 * @param Street the Street
	 * @param unit the unit
	 * @param city the city
	 * @param state the state
	 * @param Zipcode the zip code
	 */
	public Address(String Type, BigDecimal Number, String Street, String unit, String city, String state,
			String Zipcode) {
		super();
		this.Type = Type;
		this.Number = Number;
		this.Street = Street;
		this.Unit = unit;
		this.City = city;
		this.State = state;
		this.Zipcode = Zipcode;
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
	 * Gets the Number.
	 *
	 * @return the Number
	 */
	public BigDecimal getNumber() {
		return Number;
	}

	/**
	 * Sets the Number.
	 *
	 * @param Number the new Number
	 */
	public void setNumber(BigDecimal Number) {
		this.Number = Number;
	}

	/**
	 * Gets the Street.
	 *
	 * @return the Street
	 */
	public String getStreet() {
		return Street;
	}

	/**
	 * Sets the Street.
	 *
	 * @param Street the new Street
	 */
	public void setStreet(String Street) {
		this.Street = Street;
	}

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipcode() {
		return Zipcode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param Zipcode the new zip code
	 */
	public void setZipcode(String Zipcode) {
		this.Zipcode = Zipcode;
	}

	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 */
	public String getUnit() {
		return Unit;
	}

	/**
	 * Sets the unit.
	 *
	 * @param unit the new unit
	 */
	public void setUnit(String unit) {
		Unit = unit;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return City;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		City = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return State;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		State = state;
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
		return "Address [Type=" + Type + ", Number=" + Number + ", Street=" + Street + ", Unit=" + Unit + ", City="
				+ City + ", State=" + State + ", Zipcode=" + Zipcode + "]";
	}

	
	
	
}
