package com.coursework2;

import com.coursework2.Exceptions.SetAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.SetIsEmptyException;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
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

public class MathQuestionRepositoryTest {

    private MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();
    private Collection<Question> list = new HashSet<>();
    private Question question1 = new Question("Вопрос1", "Ответ1");
    private Question question2 = new Question("Вопрос2", "Ответ2");

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
        mathQuestionRepository.add(question1);
        assertThrows(SetAlreadyHaveThisQuestion.class, () -> mathQuestionRepository.add(question1));
    }


    @Test
    public void removeTests() {

        //throwTest
        assertThrows(SetIsNotContainsQuestion.class, () -> mathQuestionRepository.remove(question1));
        //2testPositive
        mathQuestionRepository.add(question1);
        assertEquals(question1, mathQuestionRepository.remove(question1));
        //3testCheckSize
        mathQuestionRepository.add(question1);
        int sizeWithOneElement = mathQuestionRepository.getAll().size();
        mathQuestionRepository.remove(question1);
        assertEquals(sizeWithOneElement - 1, mathQuestionRepository.getAll().size());
    }




    @Test
    public void getAllTests() {
        list.add(question1);
        list.add(question2);
        mathQuestionRepository.add(question1);
        mathQuestionRepository.add(question2);
        assertEquals(list, mathQuestionRepository.getAll());
    }


}


