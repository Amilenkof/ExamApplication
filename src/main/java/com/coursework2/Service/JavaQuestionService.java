package com.coursework2.Service;

import com.coursework2.Exceptions.SetAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.SetIsEmptyException;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import com.coursework2.Repository.JavaQuestionRepository;
import com.coursework2.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;
    private final Random random = new Random();

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Optional<Question> find(String question, String answer) {
        Question q = new Question(question, answer);
        return Optional.ofNullable(javaQuestionRepository.getAll().stream()
                .filter(e -> javaQuestionRepository.getAll().contains(q))
                .findAny()
                .orElseThrow(() -> new SetIsNotContainsQuestion("This Questions is not found")));
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (javaQuestionRepository.getAll().size() > 0) {
            return javaQuestionRepository.getAll().stream()
                    .skip(random.nextInt(javaQuestionRepository.getAll().size()))
                    .findAny()
                    .get();
        } else throw new SetIsEmptyException("Set is Empty");
    }

}
