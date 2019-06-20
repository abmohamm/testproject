package com.app.samples.contactmanagementapi.rowmapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.app.samples.contactmanagementapi.model.Identification;
import static com.app.samples.contactmanagementapi.constants.DBConstans.*;


// TODO: Auto-generated Javadoc
/**
 * The Class IdentificationRowMapper.
 */
public class IdentificationRowMapper implements RowMapper<Identification>{


	/**
	 * Map row.
	 *
	 * @param rs the rs
	 * @param rowNum the row num
	 * @return the identification
	 * @throws SQLException the SQL exception
	 */
	@Override
	public Identification mapRow(ResultSet rs, int rowNum) throws SQLException {
		Identification identification = null;
		try {
			if(rs != null) {
				identification = new Identification();
				identification.setId((BigDecimal)rs.getBigDecimal(CONTACT_ID));
				identification.setFirstName((String)rs.getString(FIRST_NAME));
				identification.setLastName((String)rs.getString(LAST_NAME));
				identification.setDOB((String)rs.getString(DATE_OF_BIRTH));
				identification.setGender((String)rs.getString(GENDER));
				identification.setTitle((String)rs.getString(TITLE));
			}
		}
		catch(DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		}
		return null;
	}

}
