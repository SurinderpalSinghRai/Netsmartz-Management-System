package com.netsmartzSystem.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netsmartzSystem.manage.entities.Trainers;

@Repository
public interface TrainersRepo extends JpaRepository<Trainers ,Integer>{

}
