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
@Table(name="Courses")
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
	
	@Column()
	private String courseName;
	
	
	/*@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinTable(name = "Courses_Trainers" ,
	   joinColumns = {@JoinColumn(name = "courseId")},
	   inverseJoinColumns = {@JoinColumn(name = "trainerId")}
	)*/
	//@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.PERSIST , mappedBy = "courses")
	//private Set<Trainers> trainers = new HashSet<>();


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	/*public Set<Trainers> getTrainers() {
		return trainers;
	}


	public void setTrainers(Set<Trainers> trainers) {
		this.trainers = trainers;
	}*/


	public Courses(int courseId, String courseName, Set<Trainers> trainers) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		//this.trainers = trainers;
	}


	public Courses() {
		super();
	}


	@Override
	public String toString() {
		return this.courseName;
	}
	
	

    
	


	


	
	/*@Override
	public String toString() {
		return courseName;
	}*/

	
	

}
