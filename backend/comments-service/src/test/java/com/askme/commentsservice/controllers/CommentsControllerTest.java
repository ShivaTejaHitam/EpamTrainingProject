package com.askme.commentsservice.controllers;

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

import com.askme.commentsservice.dto.CommentDto;
import com.askme.commentsservice.services.CommentsService;

public class CommentsControllerTest {
	
	@InjectMocks
    private CommentsController commentsController;
	
	@Mock
    private CommentsService commentsService;

    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllComments() {
        // Prepare test data
        List<CommentDto> comments = new ArrayList<>();
        comments.add(new CommentDto());
        when(commentsService.getAllComments()).thenReturn(comments);

        // Test the controller method
        ResponseEntity<List<CommentDto>> response = commentsController.getAllComments();

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(comments, response.getBody());
    }

    @Test
    public void testPostComment() {
        // Prepare test data
        CommentDto commentDto = new CommentDto();
        when(commentsService.postComment(commentDto)).thenReturn(commentDto);

        // Test the controller method
        ResponseEntity<CommentDto> response = commentsController.postComment(commentDto);

        // Assertions
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(commentDto, response.getBody());
    }

    @Test
    public void testGetCommentById() {
        // Prepare test data
        int commentId = 1;
        CommentDto commentDto = new CommentDto();
        when(commentsService.getCommentById(commentId)).thenReturn(commentDto);

        // Test the controller method
        ResponseEntity<CommentDto> response = commentsController.getCommentById(commentId);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(commentDto, response.getBody());
    }

    @Test
    public void testUpdateComment() {
        // Prepare test data
        int commentId = 1;
        CommentDto commentDto = new CommentDto();
        when(commentsService.updateComment(commentDto, commentId)).thenReturn(commentDto);

        // Test the controller method
        ResponseEntity<CommentDto> response = commentsController.updateComment(commentId, commentDto);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(commentDto, response.getBody());
    }

    @Test
    public void testDeleteComment() {
        // Prepare test data
        int commentId = 1;
        when(commentsService.deleteComment(commentId)).thenReturn("Deleted");

        // Test the controller method
        ResponseEntity<String> response = commentsController.deleteComment(commentId);

        // Assertions
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertEquals("Deleted", response.getBody());
    }
}

