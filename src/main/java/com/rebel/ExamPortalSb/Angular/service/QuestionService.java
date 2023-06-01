package com.rebel.ExamPortalSb.Angular.service;

import com.rebel.ExamPortalSb.Angular.models.exams.Question;
import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;

import java.util.List;


public interface QuestionService
{
    // Adding Questions
    public Question addQuestion(Question question);

    //update Question
    public Question updateQuestion(Question question);

    //get list of questions
    public List<Question> getAllQues();

    //get single question by id
    public Question getSingleQuestions(Integer quesId);

    //delete questions
    public void deleteQuestionS(Integer quesId);

    public List<Question> getQuestionsOfQuiz(Quiz quiz);

}
