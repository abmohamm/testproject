package com.app.samples.contactmanagementapi.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// TODO: Auto-generated Javadoc
/**
 * The Class Identification.
 */
@JsonPropertyOrder({"Id","FirstName","LastName","DOB","Gender","Title"})
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class Identification {
	
	/** The Id. */
	@JsonProperty
	private BigDecimal Id;
	
	/** The First name. */
	@JsonProperty
	private String FirstName;
	  
  	/** The Last name. */
	@JsonProperty
  	private String LastName;
	  
  	/** The DOB. */
	@JsonProperty
	private String DOB;
	  
  	/** The Gender. */
	@JsonProperty
  	private String Gender;
	  
  	/** The Title. */
	@JsonProperty
  	private String Title;
	  
	/**
	 * Instantiates a new identification.
	 */
	public Identification() {
		super();
	}	

	/**
	 * Instantiates a new identification.
	 *
	 * @param Id the id
	 * @param FirstName the first name
	 * @param LastName the last name
	 * @param DOB the d OB
	 * @param Gender the Gender
	 * @param Title the Title
	 */
	public Identification(BigDecimal Id,String FirstName, String LastName, String DOB, String Gender, String Title) {
		super();
		this.Id=Id;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.DOB = DOB;
		this.Gender = Gender;
		this.Title = Title;
	}



	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param FirstName the new first name
	 */
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param LastName the new last name
	 */
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	/**
	 * Gets the DOB.
	 *
	 * @return the DOB
	 */
	public String getDOB() {
		return DOB;
	}

	/**
	 * Sets the DOB.
	 *
	 * @param DOB the new DOB
	 */
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	/**
	 * Gets the Gender.
	 *
	 * @return the Gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * Sets the Gender.
	 *
	 * @param Gender the new Gender
	 */
	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	/**
	 * Gets the Title.
	 *
	 * @return the Title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * Sets the Title.
	 *
	 * @param Title the new Title
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public BigDecimal getId() {
		return Id;
	}

	/**
	 * Sets the id.
	 *
	 * @param Id the new id
	 */
	public void setId(BigDecimal Id) {
		this.Id = Id;
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
		return "Identification [Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", DOB=" + DOB
				+ ", Gender=" + Gender + ", Title=" + Title + "]";
	}
	
	
	
	
}
