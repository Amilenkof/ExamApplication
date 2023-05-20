package com.coursework2.Service;

import com.coursework2.Exceptions.ArrayAlreadyHaveThisQuestion;
import com.coursework2.Exceptions.ArrayIsEmptyException;
import com.coursework2.Exceptions.ArrayIsNotContainsQuestion;
import com.coursework2.Model.Question;
import com.coursework2.Model.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;



@Service
public class JavaQuestionService implements QuestionService {
    private ArrayList<Question> questions;

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (!questions.contains(q)) {
            questions.add(q);
            return q;
        } else throw new ArrayAlreadyHaveThisQuestion("Arraylist already have this question");
    }

    @Override
    public Question add(Question question) {
        if (!questions.contains(question)) {
            questions.add(question);
            return question;
        } else throw new ArrayAlreadyHaveThisQuestion("Arraylist already have this question");
    }

    @Override
    public Question remove(Question question) {
        boolean b = questions.contains(question);
        if (b) {
            questions.remove(question);
            return question;
        } else throw new ArrayIsNotContainsQuestion("Arraylist is not contains this element");
    }
@Override
    public Optional<Question> find(String question, String answer) {
        Question q = new Question(question, answer);
        return Optional.ofNullable(questions.stream()
                .filter(e -> e.equals(q))
                .findAny()
                .orElseThrow(() -> new ArrayIsNotContainsQuestion("This Questions is not found")));
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
//        if (questions.size() > 0)
//            return questions.get(random.nextInt(questions.size()));
//        else throw new ArrayIsEmptyException("Arraylist is Empty");
         return questions.stream()
                .skip(random.nextInt(questions.size()-1))
                .findFirst()
                .orElseThrow(()->new ArrayIsEmptyException("Array is Empty"));
    }

}
