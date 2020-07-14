package com.hcl.empcourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.empcourse.dto.EmployeeDto;
import com.hcl.empcourse.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

		@GetMapping("")
		public ResponseEntity<EmployeeDto> getEmployeebyEmployeeId(@RequestParam Integer employeeId) {
			return new ResponseEntity<EmployeeDto>(employeeService.getEmployeebyEmployeeId(employeeId),HttpStatus.OK);
		}
		

}
