package com.netsmartzSystem.manage.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netsmartzSystem.manage.entities.Courses;
import com.netsmartzSystem.manage.entities.Trainee;
import com.netsmartzSystem.manage.entities.Trainers;
import com.netsmartzSystem.manage.repository.CoursesRepo;
import com.netsmartzSystem.manage.repository.TraineeRepo;
import com.netsmartzSystem.manage.repository.TrainersRepo;
import com.netsmartzSystem.manage.services.CoursesServices;
import com.netsmartzSystem.manage.services.TraineeServices;

@Controller
public class TraineeController {
	
	@Autowired
	private CoursesServices coursesServices;
	
	
	@Autowired
	private CoursesRepo coursesRepo;
	
	@Autowired
	private TraineeRepo traineeRepo;
	
	@Autowired
	private TrainersRepo trainersRepo;
	
	@Autowired
	private TraineeServices traineeServices;
	
	/*@RequestMapping("/traineeForm")
	public String traineeForm()
	{
		return "TraineeForm";
	}
	
	@RequestMapping("/traineesView")
	public String traineesView()
	{
		return "TraineesView";
	}*/
	@RequestMapping("/AddNewTrainee")
	public String form1(Model m)
	{
		List<Trainers> trainers = trainersRepo.findAll();
		m.addAttribute("trainers" , trainers);
		List<Courses> courses = coursesRepo.findAll();
		m.addAttribute("courses" ,courses);
		m.addAttribute("trainee" , new Trainee());
		return "TraineeForm";
	}
	@PostMapping("/traineesView")
	public String addTrainee(Trainee trainee , Model m)
	{
	
		m.addAttribute("result", this.traineeServices.addTrainee(trainee));
	
		
		return "redirect:/showAllTrainees";
	}
	
	@RequestMapping("/showAllTrainees")
	public String showAllTrainees(Model m)
	{
		//List<Trainers> trainer = trainerServices.getAllTrainers();
		
		List<Trainee> trainees = traineeRepo.findAll();
		m.addAttribute("trainees" , trainees);
		
		
		//m.addAttribute("trainer" , trainer );
		/*for(Trainee x:trainees)
		{
			System.out.println(x.getCourses());
			System.out.println(x.getTraineeName());
		}*/
		
		
		//System.out.println(trainer.get(3));
		/*List<Courses> courses = coursesRepo.findAll();
		m.addAttribute("courses" ,courses);*/
		
		return "TraineesView";
	}
	
	@GetMapping("/updateTrainee/{id}")
	public String updateTrainee(@PathVariable Integer id , Model m)
	{
		Trainee trainee=traineeServices.getTraineeById(id);
		
		m.addAttribute("trainee" , trainee);
		
		List<Courses> courses = coursesRepo.findAll();
		m.addAttribute("courses" ,courses);
		
		List<Trainers> trainers = trainersRepo.findAll();
		m.addAttribute("trainers" , trainers);
		
		return "UpdateTrainee";
		
	}
	@PostMapping("/updateTrainee")
	public String updateTrainee(@ModelAttribute Trainee trainee)
	{
		traineeServices.addTrainee(trainee);
		return "redirect:/showAllTrainees";
	}
	
	@GetMapping("/deleteTrainee/{id}")
	public String deleteTrainee(@PathVariable Integer id)
	{
		traineeServices.delete(id);
		return "redirect:/showAllTrainees";
		
	}
	
	
	
	

}
