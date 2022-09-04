package com.netsmartzSystem.manage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartzSystem.manage.entities.Courses;
import com.netsmartzSystem.manage.entities.Trainers;
import com.netsmartzSystem.manage.repository.CoursesRepo;

@Service
public class CoursesServices  {
	
	@Autowired
	private CoursesRepo  coursesRepo;
	
	public void addCourse(Courses c)
	{
		coursesRepo.save(c);
		
	}
	
	/*public List<Courses>> getAllCourses()
	 {
		 List<Courses> list=(List<Courses>)this.coursesRepo.findAll();
		 return list;
	 }*/
	
	public void deleteCourse(Integer id)
	{
		coursesRepo.deleteById(id);
	}

}
