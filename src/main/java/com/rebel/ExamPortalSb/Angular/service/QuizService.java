package com.rebel.ExamPortalSb.Angular.service;

import com.rebel.ExamPortalSb.Angular.models.exams.Category;
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

    //Getting quiz by category Id
    public List<Quiz> getQuizzesByCategory(Integer cId);

    //get only active quizzes
    public List<Quiz> getActiveQuizzes();

    //get list of quizzes  by category and mst be active status
    public List<Quiz> getActiveQuizzesOfCategory(Category c);

}
