package com.cellent.employee.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cellent.employee.EmployeeDTO.EmployeeDTO;
import com.cellent.employee.entity.Employee;
import com.cellent.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {

		Employee addEmployee = service.addEmployee(employee);
		return new ResponseEntity<String>("employee added successfully and empId is "+addEmployee.getId(),HttpStatus.OK) ;
	}

	@GetMapping(value = "/getemployees", /* consumes = MediaType.APPLICATION_JSON_VALUE, */ produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDTO>> getAllEmployess() {

		List<EmployeeDTO> allEmployess = service.getAllEmployess();
		return new ResponseEntity<List<EmployeeDTO>>(allEmployess,HttpStatus.OK) ;
	}
	
	@GetMapping(value = "/getemployee", /* consumes = MediaType.APPLICATION_JSON_VALUE, */ produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> getemployee(@RequestParam BigInteger id) {

		 EmployeeDTO employee = service.getEmployee(id);
		return new ResponseEntity<EmployeeDTO>(employee,HttpStatus.OK) ;
	}
	
	@DeleteMapping(value = "/deleteEmployee", /* consumes = MediaType.APPLICATION_JSON_VALUE, */ produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteEmployee(@RequestParam BigInteger id) {

		String deleteEmployee = service.deleteEmployee(id);
		return new ResponseEntity<String>(deleteEmployee,HttpStatus.OK) ;
	}
	

	@PostMapping(value = "/send", /* consumes = MediaType.APPLICATION_JSON_VALUE, */ produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendMessage(@RequestParam String sms)
	{
		kafkaTemplate.send("sms",sms);
		return sms+"   sms sent";
	}

	@PostMapping(value = "/send2", /* consumes = MediaType.APPLICATION_JSON_VALUE, */ produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendMessage2(@RequestParam String sms)
	{
		kafkaTemplate.send("squared",sms);	
		return sms+"   sms2 sent2";
	}
}
