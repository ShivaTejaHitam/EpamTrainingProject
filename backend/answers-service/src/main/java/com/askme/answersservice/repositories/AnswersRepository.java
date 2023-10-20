package com.askme.answersservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.askme.answersservice.entities.Answer;

@Repository
public interface AnswersRepository extends JpaRepository<Answer,Integer>{
	
}
