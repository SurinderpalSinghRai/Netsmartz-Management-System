package com.netsmartzSystem.manage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netsmartzSystem.manage.entities.Courses;
import com.netsmartzSystem.manage.repository.CoursesRepo;
import com.netsmartzSystem.manage.services.CoursesServices;

@Controller
public class CoursesController {
	
	@Autowired
	private CoursesServices coursesServices;
	
	
	@Autowired
	private CoursesRepo coursesRepo;
	
	
	
	
	@RequestMapping("/showAllCourses")
	public String showAllCourses(Model m)
	{
		
		List<Courses> courses = coursesRepo.findAll();
		m.addAttribute("courses" , courses);
		
		
		return "CoursesView";
	}
	
	@GetMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable Integer id)
	{
		coursesServices.deleteCourse(id);
		return "redirect:/showAllCourses";
		
	}

}
