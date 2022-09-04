package com.netsmartzSystem.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netsmartzSystem.manage.entities.Trainee;

@Repository
public interface TraineeRepo extends JpaRepository<Trainee ,Integer> {

}
