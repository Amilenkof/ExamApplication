package Service;

import Exceptions.ArrayIsEmptyException;
import Model.Question;
import Model.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {
    private ArrayList<Question> questions;

    public JavaQuestionService() {
        this.questions = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if (questions.size() > 0)
            return questions.get(random.nextInt(questions.size()));
        else throw new ArrayIsEmptyException("Arraylist is Empty");
    }
}
