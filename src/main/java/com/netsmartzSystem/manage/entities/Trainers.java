package com.netsmartzSystem.manage.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TrainersInformation")
public class Trainers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int trainerId;
	private String trainerName;
	
	@Column(unique = true)
	private String trainerEmail;
	private String trainerAddress;
	

	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
	@JoinTable(name = "Trainers_Courses" ,
	   joinColumns = {@JoinColumn(name = "trainerId")},
	   inverseJoinColumns = {@JoinColumn(name = "courseId")}
	)
	//@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "trainers")
	private Set<Courses> courses = new HashSet<>();


	public int getTrainerId() {
		return trainerId;
	}


	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}


	public String getTrainerName() {
		return trainerName;
	}


	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}


	public String getTrainerEmail() {
		return trainerEmail;
	}


	public void setTrainerEmail(String trainerEmail) {
		this.trainerEmail = trainerEmail;
	}


	public String getTrainerAddress() {
		return trainerAddress;
	}


	public void setTrainerAddress(String trainerAddress) {
		this.trainerAddress = trainerAddress;
	}


	public Set<Courses> getCourses() {
		return courses;
	}


	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}


	public Trainers(int trainerId, String trainerName, String trainerEmail, String trainerAddress,
			Set<Courses> courses) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerEmail = trainerEmail;
		this.trainerAddress = trainerAddress;
		this.courses = courses;
	}


	public Trainers() {
		super();
	}


	@Override
	public String toString() {
		return this.trainerName;
	}
	
	
	


	public Trainers(Set<Courses> courses) {
		super();
		this.courses = courses;
	}
	
	
	
	

}
