package com.netsmartzSystem.manage.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartzSystem.manage.entities.Trainee;
import com.netsmartzSystem.manage.entities.Trainers;
import com.netsmartzSystem.manage.repository.TraineeRepo;


@Service
public class TraineeServices {
	
	@Autowired
	private TraineeRepo traineeRepo;
	
	 public Trainee addTrainee(Trainee t)
	 {
		 Trainee result=traineeRepo.save(t);
		 
		 return result;
	 }
	 
	 public Trainee getTraineeById(Integer id)
	{
			Optional<Trainee> t= traineeRepo.findById(id);
			if(t.isPresent())
			{
				return t.get();
			}
			return null;
	}
	 
	public void delete(Integer id)
	{
			traineeRepo.deleteById(id);
	}

}
