package com.coursework2;

import com.coursework2.Exceptions.SetAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.SetIsEmptyException;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Repository.MathQuestionRepository;
import com.coursework2.Service.MathQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private  MathQuestionRepository mathQuestionRepository;

    @InjectMocks
    private MathQuestionService mathQuestionService;

    private  final Question question = new Question("Вопрос", "Ответ");



    @Test
    public void addTests() {
        Mockito.when(mathQuestionService.add(question)).thenReturn(question);
        Assertions.assertEquals(question,mathQuestionService.add("Вопрос","Ответ"));

        Mockito.when(mathQuestionService.add("Вопрос","Ответ")).thenReturn(question);
        Assertions.assertEquals(question,mathQuestionService.add(question));

        Mockito.when(mathQuestionService.add(any())).thenThrow(SetAlreadyHaveThisQuestion.class);
        Assertions.assertThrows(SetAlreadyHaveThisQuestion.class, () -> mathQuestionService.add(any()));
    }
    @Test
    public void removeTests() {


        Mockito.when(mathQuestionService.remove(question)).thenReturn(question);
        Assertions.assertEquals(question,mathQuestionService.remove(question));

        Mockito.when(mathQuestionService.remove(any())).thenThrow(SetIsNotContainsQuestion.class);
        Assertions.assertThrows(SetIsNotContainsQuestion.class, () -> mathQuestionService.remove(any()));
    }


    @Test
    public void getAllTests() {
        Set<Question> set = new HashSet<>();
        set.add(question);
        Mockito.when(mathQuestionRepository.getAll()).thenReturn(set);
        Assertions.assertEquals(set,mathQuestionService.getAll());
    }

    @Test
    public void getRandomQuestionsTest() {
        Assertions.assertThrows(SetIsEmptyException.class, () -> mathQuestionService.getRandomQuestion());


        Set<Question> set = new HashSet<>();
        set.add(question);
        Mockito.when(mathQuestionRepository.getAll()).thenReturn(set);
        Assertions.assertEquals(question, mathQuestionService.getRandomQuestion());

    }

    @Test
    public void findTests(){
        Assertions.assertThrows(SetIsNotContainsQuestion.class, () -> mathQuestionService.find("вопрос","ответ"));


        Set<Question> set = new HashSet<>();
        set.add(question);
        Mockito.when(mathQuestionRepository.getAll()).thenReturn(set);
        Assertions.assertEquals(question, (mathQuestionService.find("Вопрос", "Ответ")).get());

    }
}
