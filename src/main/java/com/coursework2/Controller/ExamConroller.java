package com.coursework2.Controller;

import com.coursework2.Model.Question;
import com.coursework2.Service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class ExamConroller {
    private  final ExaminerServiceImpl examinerService;

    public ExamConroller(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(value = "/get", params = "amount")
    public HashSet <Question> getQuestions (int amount) {
        return examinerService.getQuestions(amount);
    }
}

