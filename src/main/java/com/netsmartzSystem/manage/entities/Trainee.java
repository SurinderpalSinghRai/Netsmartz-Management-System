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
@Table(name="TraineeInformation")
public class Trainee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int traineeId;
	private String traineeName;
	
	@Column(unique = true)
	private String traineeEmail;
	private String traineeAddress;
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
	@JoinTable(name = "Trainees_Courses" ,
	   joinColumns = {@JoinColumn(name = "traineeId")},
	   inverseJoinColumns = {@JoinColumn(name = "courseId")}
	)
	//@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "trainers")
	private Set<Courses> courses = new HashSet<>();

	public int getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getTraineeEmail() {
		return traineeEmail;
	}

	public void setTraineeEmail(String traineeEmail) {
		this.traineeEmail = traineeEmail;
	}

	public String getTraineeAddress() {
		return traineeAddress;
	}

	public void setTraineeAddress(String traineeAddress) {
		this.traineeAddress = traineeAddress;
	}

	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Trainee(int traineeId, String traineeName, String traineeEmail, String traineeAddress,
			Set<Courses> courses) {
		super();
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeEmail = traineeEmail;
		this.traineeAddress = traineeAddress;
		this.courses = courses;
	}

	

	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName=" + traineeName + ", traineeEmail=" + traineeEmail
				+ ", traineeAddress=" + traineeAddress + ", courses=" + courses + ", trainers=" + trainers + "]";
	}

	public Trainee() {
		super();
	}
	
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST)
	@JoinTable(name = "Trainers_Trainees" ,
	   joinColumns = {@JoinColumn(name = "traineeId")},
	   inverseJoinColumns = {@JoinColumn(name = "trainerId")}
	)
	//@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy = "trainers")
	private Set<Trainers> trainers = new HashSet<>();


	public Trainee(Set<Trainers> trainers) {
		super();
		this.trainers = trainers;
	}

	public Set<Trainers> getTrainers() {
		return trainers;
	}

	public void setTrainers(Set<Trainers> trainers) {
		this.trainers = trainers;
	}
	
	


}
