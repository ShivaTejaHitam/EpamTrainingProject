package com.askme.likesservice.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.askme.likesservice.dto.LikeDto;
import com.askme.likesservice.services.LikesService;

public class LikesControllerTest {
	
	@InjectMocks
    private LikesController likesController;
	@Mock
    private LikesService likesService;
	
	LikeDto likeDto;

    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.openMocks(this);
        likeDto = new LikeDto();
        likeDto.setLikeId(1);
        likeDto.setUserEmail("user1");
        likeDto.setAnswerId(1);
    }

    @Test
    public void testGetLikes() {
        // Arrange
        List<LikeDto> likeList = new ArrayList<>();
        likeList.add(likeDto);
        when(likesService.getLikes()).thenReturn(likeList);

        // Act
        ResponseEntity<List<LikeDto>> response = likesController.getLikes();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(likeList, response.getBody());
    }

    @Test
    public void testLikeAnswer() {
        // Arrange
        when(likesService.likeAnswer(likeDto)).thenReturn(likeDto);

        // Act
        ResponseEntity<LikeDto> response = likesController.likeAnswer(likeDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(likeDto, response.getBody());
    }

    @Test
    public void testDislikeAnswer() {
        // Arrange
        int likeId = 1;
        when(likesService.dislikeAnswer(likeId)).thenReturn("Answer Disliked Successfully");

        // Act
        ResponseEntity<String> response = likesController.dislikeAnswer(likeId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Answer Disliked Successfully", response.getBody());
    }
}

