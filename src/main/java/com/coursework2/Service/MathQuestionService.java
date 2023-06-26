package com.coursework2.Service;

import com.coursework2.Exceptions.SetAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.SetIsEmptyException;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import com.coursework2.Repository.MathQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MathQuestionService implements QuestionService {
    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository javaQuestionRepository) {
        this.mathQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
            return  mathQuestionRepository.add(new Question(question,answer));

    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Optional<Question> find(String question, String answer) {
        Question q = new Question(question, answer);
        return Optional.ofNullable(mathQuestionRepository.getAll().stream()
                .filter(e -> mathQuestionRepository.getAll().contains(q))
                .findAny()
                .orElseThrow(() -> new SetIsNotContainsQuestion("This Question is not found")));
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if (mathQuestionRepository.getAll().size() > 0) {
            return mathQuestionRepository.getAll().stream()
                    .skip(random.nextInt(mathQuestionRepository.getAll().size()))
                    .findAny()
                    .get();
        }
        else throw new SetIsEmptyException("Set is Empty");
    }

}