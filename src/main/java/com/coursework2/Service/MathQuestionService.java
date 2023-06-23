package com.coursework2.Service;

import com.coursework2.Exceptions.ArrayAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.ArrayIsEmptyException;
import com.coursework2.Exceptions.ArrayIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import com.coursework2.Repository.MathQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MathQuestionService implements QuestionService {
    private MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository javaQuestionRepository) {
        this.mathQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (!mathQuestionRepository.getAll().contains(q)) {
            mathQuestionRepository.add(q);
            return q;
        } else throw new ArrayAlreadyHaveThisQuestion("Set already have this question");
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
                .orElseThrow(() -> new ArrayIsNotContainsQuestion("This Questions is not found")));
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
//            return questions.get(random.nextInt(questions.size()));
        else throw new ArrayIsEmptyException("Set is Empty");
    }

}