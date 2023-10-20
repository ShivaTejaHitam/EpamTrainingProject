package com.askme.questionsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.askme.questionsservice.entities.Question;

public interface QuestionsRepository extends JpaRepository<Question,Integer>{
	
}
