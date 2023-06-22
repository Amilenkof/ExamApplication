package com.coursework2.Controller;

import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import com.coursework2.Service.MathQuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    private final MathQuestionService mathQuestionService;

    public MathQuestionController(MathQuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }
    @GetMapping()
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question,
                        @RequestParam("answer") String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        return mathQuestionService.remove(question1);
    }
    @GetMapping("/find")
    public Optional find (@RequestParam("question") String question,
                          @RequestParam("answer") String answer) {
        return mathQuestionService.find(question, answer);
    }
}
