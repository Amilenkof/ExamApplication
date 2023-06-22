package com.coursework2;

import com.coursework2.Exceptions.ArrayAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.ArrayIsEmptyException;
import com.coursework2.Exceptions.ArrayIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService = new JavaQuestionService();
    private Collection<Question> list = new ArrayList<>();
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
        javaQuestionService.add(question1);
        assertThrows(ArrayAlreadyHaveThisQuestion.class, () -> javaQuestionService.add(question1));
    }


    @Test
    public void removeTests() {

        //throwTest
        assertThrows(ArrayIsNotContainsQuestion.class, () -> javaQuestionService.remove(question1));
        //2testPositive
        javaQuestionService.add(question1);
        assertEquals(question1, javaQuestionService.remove(question1));
        //3testCheckSize
        javaQuestionService.add(question1);
        int sizeWithOneElement = javaQuestionService.getAll().size();
        javaQuestionService.remove(question1);
        assertEquals(sizeWithOneElement - 1, javaQuestionService.getAll().size());
    }

    @Test
    public void findTests() {

        //throwTest
        assertThrows(ArrayIsNotContainsQuestion.class, () -> javaQuestionService.find(question1.getQuestion(), question1.getAnswer()));
        //test2
        javaQuestionService.add(question1);
        assertEquals(question1, javaQuestionService.find(question1.getQuestion(), question1.getAnswer()).get());

    }


    @Test
    public void getAllTests() {
        list.add(question1);
        list.add(question2);
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);
        assertEquals(list, javaQuestionService.getAll());
    }


    @Test
    public void getRandomTests() {
        //testThrows
        assertThrows(ArrayIsEmptyException.class,()-> javaQuestionService.getRandomQuestion());
        //testPositive
        javaQuestionService.add(question1);
        assertEquals(question1,javaQuestionService.getRandomQuestion());

    }
}
