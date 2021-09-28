package com.leo.backend.controller;

import com.leo.backend.entity.Quiz;
import com.leo.backend.repository.QuizRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {

    private final QuizRepository repository;

    QuizController(QuizRepository repository) {
        this.repository = repository;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/quizzes")
    List<Quiz> all() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/quiz")
    Quiz newQuiz(@RequestBody Quiz quiz) {
        return repository.save(quiz);
    }
}
