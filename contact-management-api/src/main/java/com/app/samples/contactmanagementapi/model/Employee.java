/*
 * 
 */
package com.app.samples.contactmanagementapi.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;
//import javax.faces.component.UIComponent;
//import javax.faces.context.FacesContext;
//import javax.faces.validator.ValidatorException;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 *
 * @author Abid
 * The Class Employee.
 */
//@ManagedBean
//@ApplicationScoped
public class Employee {
	
	/** The logger. */
	Logger logger = Logger.getLogger(Employee.class.getName());
	
	/** The employeeid. */
	private int employeeid;
	
	/** The phone number. */
	private String phoneNumber;
	
	/** The hire date. */
	private Date hireDate;
	
	/** The job id. */
	private String jobId;
	
	/** The salary. */
	private int salary;
	
	/** The commission pct. */
	private int commissionPct;
	
	/** The manager id. */
	private int managerId;
	
	/** The department id. */
	private int departmentId;

	/** The full name. */
	private String fullName;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;	
	
	/** The email. */
	private String email;

	/** The country. */
	private String country;
	
	/** The zip code. */
	private String zipCode;
	
	/** The free passes. */
	private int freePasses;

	/** The country options. */
	private List<String> countryOptions;

	/** The favorite language. */
	private String favoriteLanguage;

	/** The favorite games. */
	private String[] favoriteGames;
	
	/** The contact number. */
	private String contactNumber;
	
	/** The employee code. */
	private String employeeCode;
	
	/** The date updated. */
	private String dateUpdated;
	
	/**
	 * Instantiates a new employee.
	 */
	public Employee() {
		super();
		countryOptions = new ArrayList<String>();
		logger.info("created class : "+Employee.class.getName());
		countryOptions.add("Brazil");
		countryOptions.add("France");
		countryOptions.add("Germany");
		countryOptions.add("India");
		countryOptions.add("Turkey");
		countryOptions.add("United Kingdom");
		countryOptions.add("United States");		
	}
	
	/**
	 * Instantiates a new employee.
	 *
	 * @return the first name
	 */
	



	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		if(firstName != null) {
			logger.info("first name : "+firstName);
		}
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		if(lastName != null) {
			logger.info("last name : "+lastName);
		}
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		if(country != null) {
			logger.info("country : "+country);
		}
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the country options.
	 *
	 * @return the country options
	 */
	public List<String> getCountryOptions() {
		if(countryOptions != null) {
			logger.info("list of countries : "+countryOptions);
		}
		return countryOptions;
	}	


	/**
	 * Gets the favorite language.
	 *
	 * @return the favorite language
	 */
	public String getFavoriteLanguage() {
		if(favoriteLanguage != null) {
			logger.info("favorite language : "+favoriteLanguage);
		}
		return favoriteLanguage;
	}

	/**
	 * Sets the favorite language.
	 *
	 * @param favoriteLanguage the new favorite language
	 */
	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		if(firstName != null && lastName != null) {
			logger.info("full name : "+firstName+" "+lastName);
			return firstName+" "+lastName;
		}
		else {
			return fullName;
		}
		
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	/**
	 * Gets the favorite games.
	 *
	 * @return the favorite games
	 */
	public String[] getFavoriteGames() {
		if(favoriteGames != null) {
			logger.info("Favorite Games : ");
			for(String str : favoriteGames) {
				logger.info(str+",");
			}
		}
		return favoriteGames;
	}

	/**
	 * Sets the favorite games.
	 *
	 * @param favoriteGames the new favorite games
	 */
	public void setFavoriteGames(String[] favoriteGames) {
		this.favoriteGames = favoriteGames;
	}
	
	

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		if(email != null) {
			logger.info("Email : "+email);
		}
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		if(zipCode != null) {
			logger.info("Zip Code : "+zipCode);
		}
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets the free passes.
	 *
	 * @return the free passes
	 */
	public int getFreePasses() {
		return freePasses;
	}

	/**
	 * Sets the free passes.
	 *
	 * @param freePasses the new free passes
	 */
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	

	/**
	 * Gets the contact number.
	 *
	 * @return the contact number
	 */
	public String getContactNumber() {
		if(contactNumber != null) {
			logger.info("Contact Number : "+contactNumber);
		}
		return contactNumber;
	}

	/**
	 * Sets the contact number.
	 *
	 * @param contactNumber the new contact number
	 */
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	

	/**
	 * Gets the employee code.
	 *
	 * @return the employee code
	 */
	public String getEmployeeCode() {
		if(employeeCode != null) {
			logger.info("Employee Code : "+employeeCode);
		}
		return employeeCode;
	}

	/**
	 * Sets the employee code.
	 *
	 * @param employeeCode the new employee code
	 */
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate
				+ ", jobId=" + jobId + ", salary=" + salary + ", commissionPct=" + commissionPct + ", managerId="
				+ managerId + ", departmentId=" + departmentId + ", fullName=" + fullName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", country=" + country + ", zipCode=" + zipCode
				+ ", freePasses=" + freePasses + ", countryOptions=" + countryOptions + ", favoriteLanguage="
				+ favoriteLanguage + ", favoriteGames=" + Arrays.toString(favoriteGames) + ", contactNumber="
				+ contactNumber + ", employeeCode=" + employeeCode + ", dateUpdated=" + dateUpdated + "]";
	}		
	
	
	
	/**
	 * Gets the employeeid.
	 *
	 * @return the employeeid
	 */
	public int getEmployeeid() {
		return employeeid;
	}

	/**
	 * Sets the employeeid.
	 *
	 * @param employeeid the new employeeid
	 */
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the hire date.
	 *
	 * @return the hire date
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * Sets the hire date.
	 *
	 * @param hireDate the new hire date
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * Gets the job id.
	 *
	 * @return the job id
	 */
	public String getJobId() {
		return jobId;
	}

	/**
	 * Sets the job id.
	 *
	 * @param jobId the new job id
	 */
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * Gets the commission pct.
	 *
	 * @return the commission pct
	 */
	public int getCommissionPct() {
		return commissionPct;
	}

	/**
	 * Sets the commission pct.
	 *
	 * @param commissionPct the new commission pct
	 */
	public void setCommissionPct(int commissionPct) {
		this.commissionPct = commissionPct;
	}

	/**
	 * Gets the manager id.
	 *
	 * @return the manager id
	 */
	public int getManagerId() {
		return managerId;
	}

	/**
	 * Sets the manager id.
	 *
	 * @param managerId the new manager id
	 */
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	/**
	 * Gets the department id.
	 *
	 * @return the department id
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * Sets the department id.
	 *
	 * @param departmentId the new department id
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * Sets the country options.
	 *
	 * @param countryOptions the new country options
	 */
	public void setCountryOptions(List<String> countryOptions) {
		this.countryOptions = countryOptions;
	}
	
	

	/**
	 * Instantiates a new employee.
	 *
	 * @param employeeid the employeeid
	 * @param phoneNumber the phone number
	 * @param hireDate the hire date
	 * @param jobId the job id
	 * @param salary the salary
	 * @param commissionPct the commission pct
	 * @param managerId the manager id
	 * @param departmentId the department id
	 * @param fullName the full name
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 * @param country the country
	 * @param zipCode the zip code
	 * @param freePasses the free passes
	 * @param countryOptions the country options
	 * @param favoriteLanguage the favorite language
	 * @param favoriteGames the favorite games
	 * @param contactNumber the contact number
	 * @param employeeCode the employee code
	 * @param dateUpdated the date updated
	 */
	public Employee(int employeeid, String phoneNumber, Date hireDate, String jobId, int salary, int commissionPct,
			int managerId, int departmentId, String fullName, String firstName, String lastName, String email,
			String country, String zipCode, int freePasses, List<String> countryOptions, String favoriteLanguage,
			String[] favoriteGames, String contactNumber, String employeeCode, String dateUpdated) {
		super();
		this.employeeid = employeeid;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
		this.zipCode = zipCode;
		this.freePasses = freePasses;
		this.countryOptions = countryOptions;
		this.favoriteLanguage = favoriteLanguage;
		this.favoriteGames = favoriteGames;
		this.contactNumber = contactNumber;
		this.employeeCode = employeeCode;
		this.dateUpdated = dateUpdated;
	}

	/**
	 * Gets the date updated.
	 *
	 * @return the date updated
	 */
	public String getDateUpdated() {
		return dateUpdated;
	}

	/**
	 * Sets the date updated.
	 *
	 * @param dateUpdated the new date updated
	 */
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

//	/**
//	 * Validate emp code.
//	 *
//	 * @param facesContext the faces context
//	 * @param uiComponent the ui component
//	 * @param value the value
//	 * @throws ValidatorException the validator exception
//	 */
//	public void validateEmpCode(FacesContext facesContext,UIComponent uiComponent,Object value) throws ValidatorException { 
//		FacesMessage facesMessage = null;
//		if(value == null) {
//			return;
//		}
//		String data = value.toString();
//		logger.info("value passed is : "+data);
//		
//		if(!data.startsWith(EMP_CODE)) {
//			facesMessage = new FacesMessage("Employee Code must start with LUV");
//			throw new ValidatorException(facesMessage);			
//		}
//	}

}
