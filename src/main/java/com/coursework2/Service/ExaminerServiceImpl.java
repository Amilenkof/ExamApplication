package com.coursework2.Service;

import com.coursework2.Exceptions.SetNotHaveSoMuchElements;
import com.coursework2.Model.ExaminerService;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private  QuestionService questionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }



    @Override
    public  HashSet <Question> getQuestions(int amount) {
        if (amount> questionService.getAll().size())
            throw new SetNotHaveSoMuchElements("Set with questions not have so much elements");
        HashSet<Question> randomQuestion = new HashSet<>();
        Question q;
        while (randomQuestion.size()<amount) {
            q= questionService.getRandomQuestion();
            if (!randomQuestion.contains(q)) {
                randomQuestion.add(q);
            }
        }
        return randomQuestion;
    }
}
