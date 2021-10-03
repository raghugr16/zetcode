package org.raghu.opensource.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.raghu.opensource.entity.City;
import org.raghu.opensource.entity.Employee;
import org.raghu.opensource.service.ICityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MyController {
	
	private Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@Autowired
	private ICityService iCityService;
	
	@GetMapping(value = "/cities/{id}")
	public City getCity(@PathVariable Long id) {
		return iCityService.findById(id);
	}
	
	@PostMapping(value = "/cities", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public City createCity(@RequestBody @Valid City city) {
		return iCityService.save(city); 
	}
	
	@GetMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<City>> getAllCities() {
		logger.debug("Get All Cities start");
		List<City> cities = iCityService.findAll();
		return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}

	@PostMapping(value = "/saveEmployee" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveEmployee(@ModelAttribute Employee employee){
		logger.debug("Save Employee");
		try {
				employee.getMultipartFile().transferTo(new File("/Users/raghavendragr/Desktop/Raghu/File/output.png"));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("SAved",HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/saveMultipart" , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> saveMultipart(@RequestPart MultipartFile multipartFile){
		logger.debug("Save Employee");
		try {
				multipartFile.transferTo(new File("/Users/raghavendragr/Desktop/Raghu/File/output.png"));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("SAved",HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/saveEmployee")
	public ResponseEntity<String> saveEmployee1(){
		logger.debug("Save Employee");
		return new ResponseEntity<String>("SAved",HttpStatus.ACCEPTED);
	}
}
