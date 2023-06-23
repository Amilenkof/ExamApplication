package com.coursework2.Service;

import com.coursework2.Exceptions.SetAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.SetIsEmptyException;
import com.coursework2.Exceptions.SetIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MathQuestionService implements QuestionService {
    private final Set<Question> questions;

    public MathQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (!questions.contains(q)) {
            questions.add(q);
            return q;
        } else throw new SetAlreadyHaveThisQuestion("Arraylist already have this question");
    }

    @Override
    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
            return question;
        } else throw new SetAlreadyHaveThisQuestion("Arraylist already have this question");
    }

    @Override
    public Question remove(Question question) {
        boolean b = questions.contains(question);
        if (b) {
            questions.remove(question);
            return question;
        } else throw new SetIsNotContainsQuestion("Arraylist is not contains this element");
    }
    @Override
    public Optional<Question> find(String question, String answer) {
        Question q = new Question(question, answer);
        return Optional.ofNullable(questions.stream()
                .filter(e -> questions.contains(q))
                .findAny()
                .orElseThrow(() -> new SetIsNotContainsQuestion("This Questions is not found")));
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();


        if (questions.size() > 0){
            return   questions.stream()
                    .skip(random.nextInt(questions.size()))
                    .findAny()
                    .get();
        }
//            return questions.get(random.nextInt(questions.size()));
        else throw new SetIsEmptyException("Arraylist is Empty");
    }

}
