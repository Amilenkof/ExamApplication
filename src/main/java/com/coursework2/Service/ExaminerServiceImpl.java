package com.coursework2.Service;

import com.coursework2.Exceptions.SetNotHaveSoMuchElements;
import com.coursework2.Model.ExaminerService;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount > (javaQuestionService.getAll().size() + mathQuestionService.getAll().size()))
            throw new SetNotHaveSoMuchElements("Set with questions not have so much elements");
        HashSet<Question> randomQuestion = new HashSet<>();
        Question q;
        QuestionService questionService=javaQuestionService;

        while (randomQuestion.size()<amount) {
            double temp = Math.random();
            if (temp > 0.5) questionService = mathQuestionService;
            q= questionService.getRandomQuestion();
                randomQuestion.add(q);
        }
        return randomQuestion;

    }

}
