package com.coursework2;

import com.coursework2.Exceptions.SetAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Repository.JavaQuestionRepository;
import com.coursework2.Repository.MathQuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionRepositoryTest {

    private final JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();
    private final Collection<Question> list = new HashSet<>();
    private final Question question1 = new Question("Вопрос1", "Ответ1");
    private final Question question2 = new Question("Вопрос2", "Ответ2");

    public static Stream<Arguments> paramsForTests() {
        Question question1 = new Question("Вопрос1", "Ответ1");
        Question question2 = new Question("Вопрос2", "Ответ2");


        return Stream.of(
                Arguments.of(question1, question1),
                Arguments.of(question2, question2)

        );

    }

    @ParameterizedTest
    @MethodSource("paramsForTests")
    public void addTests(Question in, Question out) {
        assertEquals(in, out);
    }

    @Test
    public void addTestThrows() {
        javaQuestionRepository.add(question1);
        assertThrows(SetAlreadyHaveThisQuestion.class, () -> javaQuestionRepository.add(question1));
    }


    @Test
    public void removeTests() {

        //throwTest
        assertThrows(SetIsNotContainsQuestion.class, () -> javaQuestionRepository.remove(question1));
        //2testPositive
        javaQuestionRepository.add(question1);
        assertEquals(question1, javaQuestionRepository.remove(question1));
        //3testCheckSize
        javaQuestionRepository.add(question1);
        int sizeWithOneElement = javaQuestionRepository.getAll().size();
        javaQuestionRepository.remove(question1);
        assertEquals(sizeWithOneElement - 1, javaQuestionRepository.getAll().size());
    }


    @Test
    public void getAllTests() {
        list.add(question1);
        list.add(question2);
        javaQuestionRepository.add(question1);
        javaQuestionRepository.add(question2);
        assertEquals(list, javaQuestionRepository.getAll());
    }


}


