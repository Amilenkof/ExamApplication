package com.coursework2;

import com.coursework2.Exceptions.SetNotHaveSoMuchElements;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import com.coursework2.Service.ExaminerServiceImpl;
import com.coursework2.Service.JavaQuestionService;
import com.coursework2.Service.MathQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    private final Set<Question> questionSet = new HashSet<>();
    private final Question question = new Question("Вопрос", "Ответ");


    @Test
    public void getQuestionsNegativeTest() {

        questionSet.add(question);

        Mockito.when(javaQuestionService.getAll()).thenReturn(questionSet);
        Mockito.when(mathQuestionService.getAll()).thenReturn(questionSet);
        Assertions.assertThrows(SetNotHaveSoMuchElements.class, () -> examinerServiceImpl.getQuestions(100500));
    }

    @Test
    public void getQuestionPositiveTest() {
        questionSet.add(question);

        Mockito.when(javaQuestionService.getAll()).thenReturn(questionSet);
        Mockito.when(mathQuestionService.getAll()).thenReturn(questionSet);
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);
//        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(question);
        Assertions.assertEquals(questionSet,examinerServiceImpl.getQuestions(1));
    }
}
