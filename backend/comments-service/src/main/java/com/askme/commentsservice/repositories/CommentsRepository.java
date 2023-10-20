package com.askme.commentsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.askme.commentsservice.entities.Comment;

@Repository
public interface CommentsRepository extends JpaRepository<Comment,Integer>{
	
}
