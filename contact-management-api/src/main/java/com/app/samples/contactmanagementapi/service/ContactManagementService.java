package com.app.samples.contactmanagementapi.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.app.samples.contactmanagementapi.dao.ContactManagementDao;
import com.app.samples.contactmanagementapi.model.ConferenceStudent;
import com.app.samples.contactmanagementapi.model.Contact;
import com.app.samples.contactmanagementapi.model.ContactResponse;
import com.app.samples.contactmanagementapi.model.Employee;

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

	@SuppressWarnings("deprecation")
	@Override
	public void readExcelAndSaveIt(InputStream inputStream) {
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet = null;
		Row row = null;
//		Cell cell = null;
		Employee employee = null;
		Iterator<Row> rowIterator = null;
	//	Iterator<Cell> cellIterator = null;
		try {
			if(inputStream != null) {
				xssfWorkbook = new XSSFWorkbook(inputStream);
				xssfSheet = xssfWorkbook.getSheetAt(0);
			}
			rowIterator = xssfSheet.iterator();
			while(rowIterator.hasNext()) {
				employee = new Employee();
				row = rowIterator.next();//ignore header information
				row = rowIterator.next();				
//				logger.info("cell length : "+row.cellIterator());
				employee.setEmployeeid((int)row.getCell(0).getNumericCellValue());
				employee.setFirstName((String)row.getCell(1).getStringCellValue());
				employee.setLastName((String)row.getCell(2).getStringCellValue());
				employee.setEmail((String)row.getCell(3).getStringCellValue());
				employee.setPhoneNumber((String)row.getCell(4).getStringCellValue());
				employee.setHireDate((Date)row.getCell(5).getDateCellValue());
				employee.setJobId((String)row.getCell(6).getStringCellValue());
				employee.setSalary((int)row.getCell(7).getNumericCellValue());
				employee.setCommissionPct((int)row.getCell(8).getNumericCellValue());
				employee.setManagerId((int)row.getCell(9).getNumericCellValue());
				employee.setDepartmentId((int)row.getCell(10).getNumericCellValue());
				
				//Save it to the database
				contactManagementDao.addEmployee(employee);
				
//				cellIterator = row.cellIterator();
//				while(cellIterator.hasNext()) {
//					cell = cellIterator.next();
//					switch(cell.getCellType()) {
//						case Cell.CELL_TYPE_STRING :
//							logger.info("cell value : "+"");
//						case Cell.CELL_TYPE_NUMERIC : 
//							logger.info("cell value : "+"");
//					}
//					logger.info("Cell value : "+cell);
//				}
			}
			inputStream.close();
		}
		catch(IOException ioException) {
			ioException.printStackTrace();
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}

	}

	@Override
	public ContactResponse readConferenceStudentExcel(InputStream inputStream) throws IOException, DataAccessException{
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet = null;
		ContactResponse contactResponse = new ContactResponse();
		Row row = null;
//		Cell cell = null;
		ConferenceStudent conferenceStudent = null;
		Iterator<Row> rowIterator = null;
		List<ConferenceStudent> conferenceStudentsList = new ArrayList<>();
	//	Iterator<Cell> cellIterator = null;
		try {
			if(inputStream != null) {
				xssfWorkbook = new XSSFWorkbook(inputStream);
				xssfSheet = xssfWorkbook.getSheetAt(0);
			}
			rowIterator = xssfSheet.iterator();
			while(rowIterator.hasNext()) {
				conferenceStudent = new ConferenceStudent();
				row = rowIterator.next();//ignore header information
				row = rowIterator.next();				
//				logger.info("cell length : "+row.cellIterator());
				conferenceStudent.setFirstName((String)row.getCell(0).getStringCellValue());
				conferenceStudent.setLastName((String)row.getCell(1).getStringCellValue());
				conferenceStudent.setUniversity((String)row.getCell(2).getStringCellValue());
				conferenceStudent.setCountry((String)row.getCell(3).getStringCellValue());
				conferenceStudent.setComments((String)row.getCell(4).getStringCellValue());
				conferenceStudentsList.add(conferenceStudent);				
			}
			addConferenceStudentsInformation(conferenceStudentsList);
			inputStream.close();
		}
		catch(IOException ioException) {
			ioException.printStackTrace();
		}
		catch(DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return contactResponse;
	}

	@Override
	public ContactResponse addConferenceStudentsInformation(List<ConferenceStudent> conferenceStudentsList) throws DataAccessException {
		ContactResponse contactResponse = null;
		try {
			contactResponse = contactManagementDao.addConferenceStudentsInformation(conferenceStudentsList);
		}
		catch(DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		return contactResponse;
		
	}
}
