package com.askme.likesservice.services;

import com.askme.likesservice.dto.LikeDto;
import com.askme.likesservice.mapper.Mapper;
import com.askme.likesservice.repositories.LikesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LikesServiceTest {

    @Mock
    private LikesRepository likesRepository;

    @InjectMocks
    private LikesService likesService;
    
    LikeDto likeDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        likeDto = new LikeDto();
        likeDto.setLikeId(1);
        likeDto.setAnswerId(1);
        likeDto.setUserEmail("testuser");
    }

    @Test
    public void testGetLikes() {
        when(likesRepository.findAll()).thenReturn(Collections.emptyList());

        List<LikeDto> result = likesService.getLikes();

        assertEquals(0, result.size());
        verify(likesRepository, times(1)).findAll();
    }

    @Test
    public void testLikeAnswer() {
        when(likesRepository.save(any())).thenReturn(Mapper.toEntity(likeDto));

        LikeDto result = likesService.likeAnswer(likeDto);

        assertEquals(likeDto.getLikeId(), result.getLikeId());
        verify(likesRepository, times(1)).save(any());
    }

    @Test
    public void testDislikeAnswer() {
        int likeId = 123; 

        likesService.dislikeAnswer(likeId);

        verify(likesRepository, times(1)).deleteById(likeId);
    }
}
