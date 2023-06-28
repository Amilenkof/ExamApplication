package com.coursework2.Service;

import com.coursework2.Exceptions.MethodNotAllowed;
import com.coursework2.Exceptions.SetIsEmptyException;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private final String a1 = "а1";
    private final String a2 = "а2";
    private final String a3 = "а3";
    private final String a4 = "а4";
    private final String a5 = "а5";
    private final String a6 = "а6";
    private final String a7 = "а7";
    private final String a8 = "а8";
    private final String a9 = "а9";
    private final String a10 = "а10";
    private final List<String> answers = List.of(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    private final String q1 = "q1";
    private final String q2 = "q2";
    private final String q3 = "q3";
    private final String q4 = "q4";
    private final String q5 = "q5";
    private final String q6 = "q6";
    private final String q7 = "q7";
    private final String q8 = "q8";
    private final String q9 = "q9";
    private final String q10 = "q10";
    private final List<String> questions = List.of(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10);
    private final Random random = new Random(21);


    public MathQuestionService() {
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowed();

    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowed();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowed();
    }

    @Override
    public Optional<Question> find(String question, String answer) {
        throw new MethodNotAllowed();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowed();
    }

    @Override
    public Question getRandomQuestion() {
        int i = random.nextInt(0, questions.size());
        return new Question(questions.get(i), answers.get(i));
    }
    public int countSize() {
        return answers.size();
    }

}