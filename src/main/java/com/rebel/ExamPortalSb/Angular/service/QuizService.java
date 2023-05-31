package com.rebel.ExamPortalSb.Angular.service;

import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuizService
{
    //Add new Quiz
    public Quiz addQuiz(Quiz quiz);

    //update quiz
    public Quiz updateQuiz(Quiz quiz);

    //get list of quizes
    public List<Quiz> getALLQuiz();

    //get single quiz
    public Quiz getSingle(Integer qId);

    //delete quiz
    public void deleteQuiz(Integer qId);

}
