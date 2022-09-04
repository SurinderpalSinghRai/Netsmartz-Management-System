package com.netsmartzSystem.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netsmartzSystem.manage.entities.Courses;

@Repository
public interface CoursesRepo extends JpaRepository<Courses , Integer>{

}
