package com.coursework2.Repository;

import com.coursework2.Exceptions.SetAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component

public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> javaRepository;


    public JavaQuestionRepository() {
        this.javaRepository = new HashSet<>() ;
    }
//    ### вопрос 1

    @PostConstruct
    public void init() {
        javaRepository.add(new Question("Что такое string-pool","string-pool — структура в памяти, хранящая массив всех строк-литералов программы."));
        javaRepository.add(new Question("Сравнение по == и по equals (*)","Сравнение по \"==\" — сравнение по ссылкам ,Сравнение по «equals» — " +
                "если переопределен equals, то это сравнение эквивалентности объектов по их полям, если нет — по ссылкам на объекты"));
        javaRepository.add(new Question("что такое массив?","структура данных в имеющая фиксированную длину"));
        javaRepository.add(new Question("Сollections- класс или интерфейс?","класс"));
        javaRepository.add(new Question("Наследование это- ?","механизм, который позволяет создавать классы на основе других классов"));
        javaRepository.add(new Question("Назовите принципы ООП?","Наследование, Полиморфизм, Инкапсуляция"));
        javaRepository.add(new Question("Что такое модификаторы доступа?","ключевые слова, которые регулируют уровень доступа к разным частям твоего кода."));
        javaRepository.add(new Question("Назовите примитивные типы данных","int,double,short,float,long,byte,char.."));
    }
    @Override
    public Question add(Question question) {
        if (!javaRepository.contains(question)) {
            javaRepository.add(question);
            return question;
        } else throw new SetAlreadyHaveThisQuestion("Set already have this question");
    }

    @Override
    public Question remove(Question question) {
        boolean b = javaRepository.contains(question);
        if (b) {
            javaRepository.remove(question);
            return question;
        } else throw new SetIsNotContainsQuestion("Set is not contains this element");
    }

    @Override
    public Collection<Question> getAll() {
        return javaRepository;
    }
}
