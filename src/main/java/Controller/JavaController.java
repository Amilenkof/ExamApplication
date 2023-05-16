package Controller;

import Model.Question;
import Service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    public JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }
    @GetMapping()
   public Collection <Question> getAll () {
        return javaQuestionService.getAll();
    }
    @GetMapping ("/add")
    public Question add (@RequestParam ("question") String question,@RequestParam ("answer") String answer ){
        return javaQuestionService.add(question, answer);
    }
    @GetMapping ("/add")
    public Question remove (@RequestParam ("question") String question,@RequestParam ("answer") String answer ){
        Question question1 = new Question(question, answer);
        return javaQuestionService.remove(question1);
    }



}
