package com.hcl.empcourse.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.empcourse.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	
	public Course findByCourseName(String courseName);
	
	public List<Course> findByCourseNameContains(String courseName);

}
