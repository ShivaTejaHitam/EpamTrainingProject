package com.askme.commentsservice.services;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.askme.commentsservice.dto.CommentDto;
import com.askme.commentsservice.entities.Comment;
import com.askme.commentsservice.exceptions.CommentNotFoundException;
import com.askme.commentsservice.mapper.Mapper;
import com.askme.commentsservice.repositories.CommentsRepository;
import com.askme.commentsservice.services.CommentsService;

@SpringBootTest
public class CommentsServiceTest {

    @InjectMocks
    private CommentsService commentsService;

    @Mock
    private CommentsRepository commentsRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPostComment() {
        CommentDto commentDto = new CommentDto();
        Comment comment = new Comment();
        comment.setTimestamp(Timestamp.from(Instant.now()));

        when(commentsRepository.save(any(Comment.class))).thenReturn(comment);

        CommentDto savedComment = commentsService.postComment(commentDto);

        assertNotNull(savedComment);
        assertEquals(comment.getTimestamp(), savedComment.getTimestamp());
    }

    @Test
    public void testGetAllComments() {
        List<Comment> comments = Arrays.asList(new Comment(), new Comment());
        when(commentsRepository.findAll()).thenReturn(comments);

        List<CommentDto> commentDtos = commentsService.getAllComments();

        assertNotNull(commentDtos);
        assertEquals(comments.size(), commentDtos.size());
    }

    @Test
    public void testGetCommentById() {
        int commentId = 1;
        Comment comment = new Comment();
        when(commentsRepository.findById(commentId)).thenReturn(Optional.of(comment));

        CommentDto foundComment = commentsService.getCommentById(commentId);

        assertNotNull(foundComment);
    }

    @Test
    public void testGetCommentById_NotFound() {
        int commentId = 1;
        when(commentsRepository.findById(commentId)).thenReturn(Optional.empty());

        assertThrows(CommentNotFoundException.class, () -> {
            commentsService.getCommentById(commentId);
        });
    }

    @Test
    public void testDeleteComment() {
        int commentId = 1;
        Comment comment = new Comment();
        when(commentsRepository.findById(commentId)).thenReturn(Optional.of(comment));

        String result = commentsService.deleteComment(commentId);

        assertEquals("Comment Deleted Successfully", result);
    }

    @Test
    public void testUpdateComment_NotFound() {
        int commentId = 1;
        CommentDto commentDto = new CommentDto();

        when(commentsRepository.findById(commentId)).thenReturn(Optional.empty());

        assertThrows(CommentNotFoundException.class, () -> {
            commentsService.updateComment(commentDto, commentId);
        });
    }
}
