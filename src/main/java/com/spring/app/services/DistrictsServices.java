package com.spring.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spring.app.model.Districts;

@Service
public class DistrictsServices {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
 
    @Transactional
    public List<Districts> findAll() {
        return jdbcTemplate.query("select * from enum_districts",new DistrictRowMapper());
    }

}
