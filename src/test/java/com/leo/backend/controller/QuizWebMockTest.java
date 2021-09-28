package com.leo.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leo.backend.entity.Quiz;
import com.leo.backend.repository.QuizRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuizController.class)
public class QuizWebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuizRepository service;

    List<Quiz> responses;
    Quiz quiz;

    @BeforeEach
    void setUp() {
        quiz = new Quiz(null, "test@data.cl", "jazz");
        responses = Collections.singletonList(quiz);
    }

    @Test
    public void quizzesShouldReturnMessageFromService() throws Exception {
        when(service.findAll()).thenReturn(responses);
        this.mockMvc.perform(get("/quizzes"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("test@data.cl")));
    }

    @Test
    public void quizShouldReturnMessageFromService() throws Exception {
        when(service.save(any(Quiz.class))).thenReturn(quiz);
        this.mockMvc.perform(post("/quiz")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(quiz)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
