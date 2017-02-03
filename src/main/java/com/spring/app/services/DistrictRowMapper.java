package com.spring.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.spring.app.model.Districts;

public class DistrictRowMapper implements RowMapper<Districts>{

	  @Override
	    public Districts mapRow(ResultSet rs, int rowNum) throws SQLException {
		  Districts districts = new Districts();
		  districts.setDistricts(rs.getString("districts"));
	        return districts;
	    }

}
