package com.coursework2.Repository;

import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

public class MathQuestionRepository implements QuestionRepository {
    private HashSet<Question> mathRepository;

    public MathQuestionRepository(HashSet<Question> mathRepository) {
        this.mathRepository = mathRepository;
    }
    public MathQuestionRepository() {
        this.mathRepository = new HashSet<>();
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
