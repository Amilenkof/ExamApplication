package com.coursework2.Service;

import com.coursework2.Exceptions.SetNotHaveSoMuchElements;
import com.coursework2.Model.ExaminerService;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServiceList;
//    private final int countQuestions;
    private final Random random = new Random(723);


    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.questionServiceList = new ArrayList<>();
        questionServiceList.add(javaQuestionService);
        questionServiceList.add(mathQuestionService);
//        countQuestions = javaQuestionService.getAll().size() + mathQuestionService.countSize();


    }

    @Override
    public Set<Question> getQuestions(int amount) {
//        if (amount > countQuestions)
//            throw new SetNotHaveSoMuchElements("Set with questions not have so much elements");
        HashSet<Question> randomQuestion = new HashSet<>();
        while (randomQuestion.size() < amount) {
            if (random.nextInt(0, 2) == 0) {
                randomQuestion.add(questionServiceList.get(0).getRandomQuestion());
            } else {
                randomQuestion.add(questionServiceList.get(1).getRandomQuestion());
            }
        }
        return randomQuestion;

    }

}
