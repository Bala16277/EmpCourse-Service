package com.hcl.empcourse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.empcourse.dto.CourseDto;
import com.hcl.empcourse.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
@Autowired
CourseService courseService;

	@GetMapping("")
	public ResponseEntity<CourseDto> getCourseByCourseName(@RequestParam String courseName) {
		return new ResponseEntity<>(courseService.getCourseByCourseName(courseName),HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<CourseDto>> getCourseByCourseNameContains(@RequestParam String courseName) {
		return new ResponseEntity<List<CourseDto>>(courseService.getCourseByCourseNameContains(courseName),HttpStatus.OK);
	}

}
