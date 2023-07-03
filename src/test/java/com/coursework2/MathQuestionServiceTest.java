package com.coursework2;

import com.coursework2.Service.MathQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


public class MathQuestionServiceTest {
    private MathQuestionService mathQuestionService = new MathQuestionService();
    private final String a1 = "а1";
    private final String a2 = "а2";
    private final String a3 = "а3";
    private final String a4 = "а4";
    private final String a5 = "а5";
    private final String a6 = "а6";
    private final String a7 = "а7";
    private final String a8 = "а8";
    private final String a9 = "а9";
    private final String a10 = "а10";
    private final List<String> answers = List.of(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    private final String q1 = "q1";
    private final String q2 = "q2";
    private final String q3 = "q3";
    private final String q4 = "q4";
    private final String q5 = "q5";
    private final String q6 = "q6";
    private final String q7 = "q7";
    private final String q8 = "q8";
    private final String q9 = "q9";
    private final String q10 = "q10";
    private final List<String> questions = List.of(q1, q2, q3, q4, q5, q6, q7, q8, q9, q10);

    @Test
    public void getRandomQuestionTests(){
        String actual=mathQuestionService.getRandomQuestion().getAnswer();
        Assertions.assertThat(answers.contains(actual));
    }
}