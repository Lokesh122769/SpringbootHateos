package com.SpringRest.SpringBootHateos.Contoller;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
@RequestMapping("/api1")
public class CourseController
{
     
	@GetMapping("/getCourse/{id}")
	public ResponseEntity<?> getCourseDetails(@PathVariable("id") Integer id)
	{
		Course c=new Course(101,"SBM",9999.9);
		
		return new ResponseEntity<Course>(c,HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllCourse")
	public ResponseEntity<?> getAllCourseDetails()
	{
		List<Course> l=new ArrayList<>();
		Course c1=new Course(101,"SBM",9999.9);
		Course c2=new Course(102,"Java",9999.9);
		Course c3=new Course(103,"DevOps",9999.9);
		Course c4=new Course(104,"React",9999.9);
		
		l.add(c1);
		l.add(c2);
		l.add(c3);
		l.add(c4);
		
		return new ResponseEntity<List<Course>>(l,HttpStatus.OK);
	}
	
	
	@GetMapping("/getThreadCourse/{id}")
	public ResponseEntity<?> getJavaCourse(@PathVariable("id") Integer id)
	{
		Course c=new Course(105,"MultiThreading",9999.9);
		
		
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getAllCourseDetails())
				.withRel("getAllCourse");
		
		c.add(link);
		
		return new ResponseEntity<Course>(c,HttpStatus.OK);
	}
}
