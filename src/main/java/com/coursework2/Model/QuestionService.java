package com.coursework2.Model;

import java.util.Collection;
import java.util.Optional;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Optional<Question> find(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
