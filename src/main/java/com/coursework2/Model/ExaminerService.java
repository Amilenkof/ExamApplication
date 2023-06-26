package com.coursework2.Model;

import java.util.Collection;

public interface ExaminerService {


  Collection<Question> getQuestions(int amount);
}
