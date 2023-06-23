package com.coursework2.Service;

import com.coursework2.Exceptions.ArrayAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.ArrayIsEmptyException;
import com.coursework2.Exceptions.ArrayIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import com.coursework2.Repository.JavaQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (!javaQuestionRepository.getAll().contains(q)) {
            javaQuestionRepository.add(q);
            return q;
        } else throw new ArrayAlreadyHaveThisQuestion("Set already have this question");
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
                .orElseThrow(() -> new ArrayIsNotContainsQuestion("This Questions is not found")));
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();


        if (javaQuestionRepository.getAll().size() > 0) {
            return javaQuestionRepository.getAll().stream()
                    .skip(random.nextInt(javaQuestionRepository.getAll().size()))
                    .findAny()
                    .get();
        }
//            return questions.get(random.nextInt(questions.size()));
        else throw new ArrayIsEmptyException("Set is Empty");
    }

}
