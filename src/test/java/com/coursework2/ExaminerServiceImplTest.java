package com.coursework2;

import com.coursework2.Exceptions.SetNotHaveSoMuchElements;
import com.coursework2.Model.Question;
import com.coursework2.Service.ExaminerServiceImpl;
import com.coursework2.Service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;


    @Test
    public void getQuestionsNegativeTest() {
        Assertions.assertThrows(SetNotHaveSoMuchElements.class, () -> examinerServiceImpl.getQuestions(100500));
    }

    @Test
    public void getQuestionPositiveTest() {
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(new Question("Вопрос", "Ответ"));
        Assertions.assertEquals((new Question("Вопрос", "Ответ")),examinerServiceImpl.getQuestions(1));
    }
}


