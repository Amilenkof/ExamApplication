package com.coursework2.Repository;

import com.coursework2.Model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;


public class JavaQuestionRepository implements QuestionRepository{
    private HashSet<Question> JavaRepository;

    public JavaQuestionRepository(HashSet<Question> javaRepository) {
        this.JavaRepository = javaRepository;
    }
    public JavaQuestionRepository() {
        this.JavaRepository = new HashSet<>() ;
    }

    @Override
    public Question add() {
        return null;
    }

    @Override
    public Question remove() {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return null;
    }
}
