package com.coursework2;

import com.coursework2.Exceptions.SetAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.SetIsEmptyException;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Repository.JavaQuestionRepository;
import com.coursework2.Service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    private final Question question = new Question("Вопрос", "Ответ");



    @Test
    public void addTests() {
        Mockito.when(javaQuestionService.add(question)).thenReturn(question);
        Assertions.assertEquals(question, javaQuestionService.add("Вопрос","Ответ"));

        Mockito.when(javaQuestionService.add("Вопрос","Ответ")).thenReturn(question);
        Assertions.assertEquals(question, javaQuestionService.add(question));

        Mockito.when(javaQuestionService.add(any())).thenThrow(SetAlreadyHaveThisQuestion.class);
        Assertions.assertThrows(SetAlreadyHaveThisQuestion.class, () -> javaQuestionService.add(any()));
    }
    @Test
    public void removeTests() {


        Mockito.when(javaQuestionService.remove(question)).thenReturn(question);
        Assertions.assertEquals(question, javaQuestionService.remove(question));

        Mockito.when(javaQuestionService.remove(any())).thenThrow(SetIsNotContainsQuestion.class);
        Assertions.assertThrows(SetIsNotContainsQuestion.class, () -> javaQuestionService.remove(any()));
    }


    @Test
    public void getAllTests() {
        Set<Question> set = new HashSet<>();
        set.add(question);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(set);
        Assertions.assertEquals(set, javaQuestionService.getAll());
    }

    @Test
    public void getRandomQuestionsTest() {
        Assertions.assertThrows(SetIsEmptyException.class, () -> javaQuestionService.getRandomQuestion());


        Set<Question> set = new HashSet<>();
        set.add(question);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(set);
        Assertions.assertEquals(question, javaQuestionService.getRandomQuestion());

    }

    @Test
    public void findTests(){
        Assertions.assertThrows(SetIsNotContainsQuestion.class, () -> javaQuestionService.find("вопрос","ответ"));


        Set<Question> set = new HashSet<>();
        set.add(question);
        Mockito.when(javaQuestionRepository.getAll()).thenReturn(set);
        Assertions.assertEquals(question, (javaQuestionService.find("Вопрос", "Ответ")).get());

    }
}
