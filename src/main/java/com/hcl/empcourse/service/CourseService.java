package com.hcl.empcourse.service;

import java.util.List;

import com.hcl.empcourse.dto.CourseDto;

public interface CourseService {

	public CourseDto getCourseByCourseName(String courseName);
	
	public List<CourseDto> getCourseByCourseNameContains(String courseName);
	
}
