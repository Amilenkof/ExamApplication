package com.coursework2;

import com.coursework2.Exceptions.SetNotHaveSoMuchElements;
import com.coursework2.Model.Question;
import com.coursework2.Service.ExaminerServiceImpl;
import com.coursework2.Service.JavaQuestionService;
import com.coursework2.Service.MathQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    private final Set<Question> questionSet1 = new HashSet<>();
    private final Set<Question> questionSet2 = new HashSet<>();
    private final Question question11 = new Question("Q11", "A11");
    private final Question question12 = new Question("Q12", "A12");
    private final Question question13 = new Question("Q13", "A13");

    private final Question question21 = new Question("Q21", "A21");
    private final Question question22 = new Question("Q22", "A22");
    private final Question question23 = new Question("Q23", "A23");


    @Test
    public void getQuestionPositiveTest() {
        questionSet1.add(question11);
        questionSet1.add(question12);
        questionSet1.add(question13);

        questionSet2.add(question21);
        questionSet2.add(question22);
        questionSet2.add(question23);
        Mockito.when(javaQuestionService.getRandomQuestion())
                .thenReturn(question11)
                .thenReturn(question12)
                .thenReturn(question13);
        Mockito.when(mathQuestionService.getRandomQuestion())
                .thenReturn(question21)
                .thenReturn(question22)
                .thenReturn(question23);

        Mockito.when(javaQuestionService.getAll()).thenReturn(questionSet1);
        Mockito.when(mathQuestionService.getAll()).thenReturn(questionSet2);

        Set<Question> actual = examinerServiceImpl.getQuestions(6);
        boolean b = actual.size() == 6;
        //test1 -check size
        assertThat(b);
        //test2 -check all elements
        assertThat(actual.contains(questionSet1.addAll(questionSet2)));
        //test 3- check throw if amount>size
        assertThrows(SetNotHaveSoMuchElements.class, () -> examinerServiceImpl.getQuestions(100500));
        //test 4 - check returned elements
        Set<Question> actual1 = examinerServiceImpl.getQuestions(1);
        assertThat(questionSet1.containsAll(actual1));
    }
}
