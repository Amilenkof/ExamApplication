package com.coursework2.Repository;

import com.coursework2.Exceptions.ArrayAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.ArrayIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> mathRepository;


    public MathQuestionRepository() {
        this.mathRepository = new HashSet<>() ;
    }
    @PostConstruct
    public void init() {
        mathRepository.add(new Question("Как называется сотая часть числа","ПРОЦЕНТ"));
        mathRepository.add(new Question("Место, занимаемое цифрой и записи числа","разряд"));
        mathRepository.add(new Question("Цифровой знак, обозначающий отсутствие величины","ноль"));
        mathRepository.add(new Question("Сколько раз в году встает солнце","365"));
        mathRepository.add(new Question("На какое наибольшее целое число делится без остатка любое целое число","само на себя"));
        mathRepository.add(new Question("Имеет ли прямая линия концы","нет"));
        mathRepository.add(new Question("Сумма углов четырехугольника","360"));
        mathRepository.add(new Question("Назовите наибольшее отрицательное число","-1"));
    }

    @Override
    public Question add(Question question) {
        if (!mathRepository.contains(question)) {
            mathRepository.add(question);
            return question;
        } else throw new ArrayAlreadyHaveThisQuestion("Set already have this question");
    }

    @Override
    public Question remove(Question question) {
        boolean b = mathRepository.contains(question);
        if (b) {
            mathRepository.remove(question);
            return question;
        } else throw new ArrayIsNotContainsQuestion("Set is not contains this element");
    }

    @Override
    public Collection<Question> getAll() {
        return mathRepository;
    }
}
