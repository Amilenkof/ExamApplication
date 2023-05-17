package com.coursework2.Service;

import com.coursework2.Exceptions.ArrayNotHaveSoMuch;
import com.coursework2.Model.ExaminerService;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private  QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }



    @Override
    public  HashSet <Question> getQuestions(int amount) {
        if (amount> questionService.getAll().size())
            throw new ArrayNotHaveSoMuch("Arraylist with questions not have so much ");
        HashSet<Question> randomQuestion = new HashSet<>();
        questionService.getAll().stream()
                .filter(e->!randomQuestion.contains(e) && randomQuestion.size()<amount)
                .forEach(randomQuestion::add);


        return randomQuestion;
    }
}
