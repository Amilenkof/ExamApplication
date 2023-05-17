package com.coursework2.Model;

import java.util.Collection;
import java.util.HashSet;

public interface ExaminerService {


  HashSet<Question> getQuestions(int amount);
}
