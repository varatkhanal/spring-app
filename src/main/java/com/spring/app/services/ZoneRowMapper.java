package com.spring.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.app.model.Zones;

public class ZoneRowMapper implements RowMapper<Zones>{

		  @Override
		    public Zones mapRow(ResultSet rs, int rowNum) throws SQLException {
			  Zones zones = new Zones();
			  zones.setZones(rs.getString("zones"));
		        return zones;
		    }

}
