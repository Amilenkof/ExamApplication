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

    private final List<String> actions = List.of("+", "-", "*", "/");

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
        int a = random.nextInt(100);
        int b = random.nextInt(100);
        String action = actions.get(random.nextInt(4));
        String question = a + action + b;
        String answer = "";
        double res = switch (action) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> Double.NEGATIVE_INFINITY;
        };
        answer = answer + res;

        return new Question(question, answer);
    }


}