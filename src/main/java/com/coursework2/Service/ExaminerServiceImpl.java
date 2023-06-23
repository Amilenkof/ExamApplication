package com.coursework2.Service;

import com.coursework2.Exceptions.SetNotHaveSoMuchElements;
import com.coursework2.Model.ExaminerService;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService,MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService=mathQuestionService;
    }

    @Override
    public  HashSet <Question> getQuestions(int amount) {
        HashSet<Question> questionSet =(HashSet<Question>) mathQuestionService.getAll();
        questionSet.addAll(javaQuestionService.getAll());

        if (amount> questionSet.size())
            throw new SetNotHaveSoMuchElements("Set with questions not have so much elements");
        HashSet<Question> randomQuestion = new HashSet<>();
        Question q;
        while (randomQuestion.size()<amount) {
            q= javaQuestionService.getRandomQuestion();
            if (!randomQuestion.contains(q)) {
                randomQuestion.add(q);
            }
        }
        return randomQuestion;
    }
}
