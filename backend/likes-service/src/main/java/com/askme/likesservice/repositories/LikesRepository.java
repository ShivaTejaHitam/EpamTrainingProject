package com.askme.likesservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.askme.likesservice.entities.Like;


@Repository
public interface LikesRepository extends JpaRepository<Like,Integer>{
	
}
