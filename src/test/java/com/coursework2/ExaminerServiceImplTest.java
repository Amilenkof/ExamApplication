package com.coursework2;

import com.coursework2.Exceptions.SetNotHaveSoMuchElements;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import com.coursework2.Service.ExaminerServiceImpl;
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
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionServiceTest;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;




    @Test
    public void getQuestionsNegativeTest() {
        Mockito.when(examinerServiceImpl.getQuestions(any())).thenThrow(SetNotHaveSoMuchElements.class);
        Assertions.assertThrows(SetNotHaveSoMuchElements.class, () -> examinerServiceImpl.getQuestions(100500));
    }
@Test
    public void getQuestionPositiveTest(){
    Mockito.when(examinerServiceImpl.getQuestions(any())).thenReturn(questionServiceTest);


    questionServiceTest.add(new Question("1", "1"));
    Set<Question> set = new HashSet<>();
    set.add(new Question("1", "1"));
    Assertions.assertEquals(set,examinerServiceImpl.getQuestions(1));
}
}


