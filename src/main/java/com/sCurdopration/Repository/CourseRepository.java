package com.sCurdopration.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sCurdopration.binding.Course;
@Repository // optional
public interface CourseRepository extends JpaRepository<Course,Serializable>{
	
}

