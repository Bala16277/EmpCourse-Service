package com.hcl.empcourse.service;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.empcourse.Repository.CourseRepository;
import com.hcl.empcourse.dto.CourseDto;
import com.hcl.empcourse.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	private static Logger logger = Logger.getLogger(CourseServiceImpl.class);
	
	@Autowired
	CourseRepository courseRepository;
 
	public CourseDto getCourseByCourseName(String courseName) {
		Course course = courseRepository.findByCourseName(courseName);
		CourseDto courseDto = new CourseDto();
		logger.info("courseDto:::: "+courseDto.getCourseName());
		BeanUtils.copyProperties(course, courseDto);
		logger.info("courseDto:::: "+courseDto.getCourseName());
		return courseDto;
	}
	
	public List<CourseDto> getCourseByCourseNameContains(String courseName) {
		List<Course> courses = courseRepository.findByCourseNameContains(courseName);
		List<CourseDto> courseDtos = new ArrayList<>();
		for(Course course: courses) {
			CourseDto courseDto = new CourseDto();
			BeanUtils.copyProperties(course,courseDto);
			logger.info("courseDto:::: "+courseDto.getCourseId());
			courseDtos.add(courseDto);
		}
		return courseDtos;
	}
	
}
