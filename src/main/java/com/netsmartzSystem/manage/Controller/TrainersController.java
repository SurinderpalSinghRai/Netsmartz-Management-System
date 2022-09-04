package com.netsmartzSystem.manage.Controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netsmartzSystem.manage.entities.Courses;
import com.netsmartzSystem.manage.entities.Trainers;
import com.netsmartzSystem.manage.repository.CoursesRepo;
import com.netsmartzSystem.manage.repository.TrainersRepo;
import com.netsmartzSystem.manage.services.CoursesServices;
import com.netsmartzSystem.manage.services.TrainersServices;

@Controller
public class TrainersController {
	
	@Autowired
	private TrainersRepo trainersRepo;
	
	
	@Autowired
	private TrainersServices trainerServices;
	
	@Autowired
	private CoursesServices coursesServices;
	
	@Autowired
	private CoursesRepo coursesRepo;
	
	@RequestMapping("/trainersForm")
	public String form()
	{
		return "NewFile";
	}
	
	@RequestMapping("/AddNewTrainer")
	public String form1(Model m)
	{
		List<Courses> courses = coursesRepo.findAll();
		m.addAttribute("courses" ,courses);
		m.addAttribute("trainer" , new Trainers());
		return "TrainersForm";
	}
	
	@RequestMapping("/showAllTrainers")
	public String showAllTrainers(Model m)
	{
		//List<Trainers> trainer = trainerServices.getAllTrainers();
		
		List<Trainers> trainers = trainersRepo.findAll();
		m.addAttribute("trainer" , trainers);
		
		
		//m.addAttribute("trainer" , trainer );
		for(Trainers x:trainers)
		{
			System.out.println(x.getCourses());
			System.out.println(x.getTrainerName());
		}
		
		
		//System.out.println(trainer.get(3));
		/*List<Courses> courses = coursesRepo.findAll();
		m.addAttribute("courses" ,courses);*/
		
		return "TrainersView";
	}
	
	@RequestMapping("/AddCourse")
	public String addCourse()
	{
 
		return "AddNewCourse";
	}
	
	@RequestMapping("/AddNewCourse")
	public String form3(@ModelAttribute Courses cr , HttpSession session)
	{
        System.out.println(cr);
		
        coursesServices.addCourse(cr);
        session.setAttribute("msg", "Course added sucessfully");
		return "AddNewCourse";
	}
	
	/*@PostMapping("/trainersView")
	public String resister(@ModelAttribute  Trainers t)
	{
		System.out.println(t);
		
		trainerServices.addTrainer(t);
		return "trainersView";
	}*/
	@PostMapping("/trainersView")
	public String addTrainer(Trainers trainers , Model m)
	{
	
		m.addAttribute("result", this.trainerServices.addTrainer(trainers));
	
		
		return "redirect:/showAllTrainers";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id , Model m)
	{
		Trainers trainer=trainerServices.getTrainerById(id);
		
		m.addAttribute("trainer" , trainer);
		
		List<Courses> courses = coursesRepo.findAll();
		m.addAttribute("courses" ,courses);
		
		return "UpdateTrainer";
		
	}
	@PostMapping("/update")
	public String updateTrainer(@ModelAttribute Trainers trainer)
	{
		trainerServices.addTrainer(trainer);
		return "redirect:/showAllTrainers";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id)
	{
		trainerServices.delete(id);
		return "redirect:/showAllTrainers";
		
	}
	
	
	
	/*@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id)
	{
	    return "edit";	
	}*/
	
	@GetMapping("/home")
	public String Home(Model m)
	{
		List<Trainers> trainers=trainerServices.getAllTrainers();
		m.addAttribute("trainer" , trainers );
		
		return "NewFile";
	}
	
	
	

}
