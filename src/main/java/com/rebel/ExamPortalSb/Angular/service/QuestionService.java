package com.rebel.ExamPortalSb.Angular.service;

import com.rebel.ExamPortalSb.Angular.models.exams.Questions;
import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService
{
    // Adding Questions
    public Questions addQuestion(Questions questions);

    //update Question
    public Questions updateQuestion(Questions questions);

    //get list of questions
    public List<Questions> getAllQues();

    //get single question by id
    public Questions getSingleQuestions(Integer quesId);

    //delete questions
    public void deleteQuestionS(Integer quesId);

    public List<Questions> getQuestionsOfQuiz(Quiz quiz);

}
