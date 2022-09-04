package com.netsmartzSystem.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netsmartzSystem.manage.entities.Trainers;
import com.netsmartzSystem.manage.repository.TrainersRepo;

@Service
public class TrainersServices {
	
	@Autowired
	private TrainersRepo trainersRepo;
	
	/*public void addTrainer(Trainers t)
	{
		trainersRepo.save(t);
		
	}*/
	 public Trainers addTrainer(Trainers t)
	 {
		 Trainers result=trainersRepo.save(t);
		 
		 return result;
	 }
	
	public List<Trainers> getAllTrainers()
	 {
		 List<Trainers> list=(List<Trainers>)this.trainersRepo.findAll();
		 return list;
	 }
	
	/*public List<Trainers> getAllTrainers()
	{
		return trainersRepo.findAll();
	}*/
	
	/*public Trainers getTrainerId(int id)
	{
		Optional<Trainers> t=trainersRepo.findById(id);
		if(t.isPresent())
		{
			
		}
	}*/
	
	public Trainers getTrainerById(Integer id)
	{
		Optional<Trainers> t= trainersRepo.findById(id);
		if(t.isPresent())
		{
			return t.get();
		}
		return null;
	}
	
	public void delete(Integer id)
	{
		trainersRepo.deleteById(id);
	}


}
