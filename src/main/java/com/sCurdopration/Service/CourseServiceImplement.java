package com.sCurdopration.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCurdopration.Repository.CourseRepository;
import com.sCurdopration.binding.Course;
@Service
public class CourseServiceImplement implements CourseService {
	@Autowired
	private CourseRepository courserepo;

	@Override
	public String upsert(Course course) {

		courserepo.save(course); // upsert (insert / update based on PK)

		return "success";
	}

	@Override
	public Course getById(Integer id) {
		Optional<Course> findById = courserepo.findById(id);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return  courserepo.findAll();
	}

	@Override
	public String deleteById(Integer id) {
		if (courserepo.existsById(id)) {
			courserepo.deleteById(id);
			return "Delete Success";
		} else {
			return "No Record Found";
		}
		// TODO Auto-generated method stub
		
	}

}