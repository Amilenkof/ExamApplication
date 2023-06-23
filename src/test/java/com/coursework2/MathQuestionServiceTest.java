package com.coursework2;

import com.coursework2.Exceptions.ArrayAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.ArrayIsEmptyException;
import com.coursework2.Exceptions.ArrayIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Repository.MathQuestionRepository;
import com.coursework2.Service.MathQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathQuestionServiceTest {
    private final MathQuestionService mathQuestionService = new MathQuestionService(new MathQuestionRepository());
    private  final Collection<Question> list = new HashSet<>();
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
        mathQuestionService.add(question1);
        assertThrows(ArrayAlreadyHaveThisQuestion.class, () -> mathQuestionService.add(question1));
    }


    @Test
    public void removeTests() {

        //throwTest
        assertThrows(ArrayIsNotContainsQuestion.class, () -> mathQuestionService.remove(question1));
        //2testPositive
        mathQuestionService.add(question1);
        assertEquals(question1, mathQuestionService.remove(question1));
        //3testCheckSize
        mathQuestionService.add(question1);
        int sizeWithOneElement = mathQuestionService.getAll().size();
        mathQuestionService.remove(question1);
        assertEquals(sizeWithOneElement - 1, mathQuestionService.getAll().size());
    }

    @Test
    public void findTests() {

        //throwTest
        assertThrows(ArrayIsNotContainsQuestion.class, () -> mathQuestionService.find(question1.getQuestion(), question1.getAnswer()));
        //test2
        mathQuestionService.add(question1);
        assertEquals(question1, mathQuestionService.find(question1.getQuestion(), question1.getAnswer()).get());

    }


    @Test
    public void getAllTests() {
        list.add(question1);
        list.add(question2);
        mathQuestionService.add(question1);
        mathQuestionService.add(question2);
        assertEquals(list, mathQuestionService.getAll());
    }


    @Test
    public void getRandomTests() {
        //testThrows
        assertThrows(ArrayIsEmptyException.class, mathQuestionService::getRandomQuestion);
        //testPositive
        mathQuestionService.add(question1);
        assertEquals(question1, mathQuestionService.getRandomQuestion());

    }
}


