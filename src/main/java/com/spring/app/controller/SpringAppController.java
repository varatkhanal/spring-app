package com.spring.app.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.app.model.Districts;
import com.spring.app.model.Zones;
import com.spring.app.services.DistrictsServices;
import com.spring.app.services.ZoneServices;

@RestController
@RequestMapping(value="/")
public class SpringAppController {
	
	@Autowired
	ZoneServices zoneServices;
	
	@Autowired
	DistrictsServices districtsServices;
	
	
	@RequestMapping(value={"/spring-app","/"},
			method=RequestMethod.GET)
	public ModelAndView getIndex(ModelMap model){
		
		model.addAttribute("evnts", "welcome");
		return new ModelAndView("home", model);
		
	}
	
	@RequestMapping(value="/spring-app/zone",
	method=RequestMethod.GET,
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Zones>> listAllZones() {
        List<Zones> zon = zoneServices.findAll();
        if(zon.isEmpty()){
            return new ResponseEntity<List<Zones>>(HttpStatus.NO_CONTENT);//return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Zones>>(zon, HttpStatus.OK);
    }
	

	@RequestMapping(value="/spring-app/districts",
	method=RequestMethod.GET,
	produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Districts>> findAllDistricts() {
		List<Districts> dist = districtsServices.findAll();
        if(dist.isEmpty()){
            return new ResponseEntity<List<Districts>>(HttpStatus.NO_CONTENT);//return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Districts>>(dist, HttpStatus.OK);
    }
	
	/*@SuppressWarnings("unchecked")
	@RequestMapping(value="/spring-app/Both",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<List<String>> findBoth() {
			 List<Zones>  zon = zoneServices.findAll();
			 List<Districts>   dist = districtsServices.findAll();
				
		     
		       
		        return new ResponseEntity<ArrayList<String>>(list, HttpStatus.OK);
		    }*/
	

}
