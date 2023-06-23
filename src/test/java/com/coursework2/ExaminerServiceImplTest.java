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
import static org.mockito.ArgumentMatchers.same;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    private Set<Question> questionSet = new HashSet<>();
    private Question question = new Question("Вопрос", "Ответ");





    @Test
    public void getQuestionsNegativeTest() {
        Assertions.assertThrows(SetNotHaveSoMuchElements.class, () -> examinerServiceImpl.getQuestions(100500));
    }
@Test
    public void getQuestionPositiveTest(){
    questionSet.add(question);

    Mockito.when(questionService.getAll()).thenReturn(questionSet);
    Mockito.when(questionService.getRandomQuestion()).thenReturn(new Question("Вопрос", "Ответ"));
    Assertions.assertEquals(questionSet,examinerServiceImpl.getQuestions(1));

}
}


