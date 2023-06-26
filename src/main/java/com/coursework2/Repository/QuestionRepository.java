package com.coursework2.Repository;

import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);

    Collection<Question> getAll();

}
