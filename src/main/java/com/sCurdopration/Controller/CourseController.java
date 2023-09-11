package com.sCurdopration.Controller;


    import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
   // import org.springframework.web.bind.annotation.RequestMapping;
  //  import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.bind.annotation.RestController;
    import com.sCurdopration.Service.CourseService;
    import com.sCurdopration.binding.Course;


	@RestController
	public class CourseController {

		@Autowired
		private CourseService courseService;

		@PostMapping("/course")
	//	@RequestMapping(value = "/course")
		public ResponseEntity<String> createCourse(@RequestBody Course course) {
			String status = courseService.upsert(course);
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		}
		/*@PostMapping("/course")
		public ResponseEntity<Course> createCourse(@RequestBody Course course) {
			 courseService.upsert(course);
			return new ResponseEntity<>(course, HttpStatus.CREATED);
		}
*/
		//@GetMapping("/course/{id}")
		
		public ResponseEntity<Course> getCourse(@PathVariable Integer id) {
			Course course = courseService.getById(id);
			return new ResponseEntity<>(course, HttpStatus.OK);
		}

	@GetMapping("/courses")
		
		public ResponseEntity<List<Course>> getAllCourses() {
			List<Course> allCourses = courseService.getAllCourses();
			return new ResponseEntity<>(allCourses, HttpStatus.OK);
		}

		@PutMapping("/course")
		public ResponseEntity<String> updateCourse(@RequestBody Course course) {
			String status = courseService.upsert(course);
			return new ResponseEntity<>(status, HttpStatus.OK);
		}

		@DeleteMapping("/course/{id}")
		public ResponseEntity<String> deleteCourse(@PathVariable Integer id) {
			String status = courseService.deleteById(id);
			return new ResponseEntity<>(status, HttpStatus.OK);
		}

	}


