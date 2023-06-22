package com.coursework2.Repository;

import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;

import java.util.Collection;

public interface QuestionRepository {
    Question add();
    Question remove();

    Collection<Question> getAll();

}
