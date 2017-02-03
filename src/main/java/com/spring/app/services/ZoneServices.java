package com.spring.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spring.app.model.Zones;

@Service
public class ZoneServices {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
 
    @Transactional
    public List<Zones> findAll() {
        return jdbcTemplate.query("SELECT * FROM ENUM_ZONE", new ZoneRowMapper());
    }
   

}
