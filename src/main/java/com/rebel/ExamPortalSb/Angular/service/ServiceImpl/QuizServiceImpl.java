package com.rebel.ExamPortalSb.Angular.service.ServiceImpl;

import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;
import com.rebel.ExamPortalSb.Angular.repo.QuizRepo;
import com.rebel.ExamPortalSb.Angular.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuizServiceImpl implements QuizService
{
    @Autowired
    private QuizRepo quizRepo;

    //Add new Quiz
    @Override
    public Quiz addQuiz(Quiz quiz)
    {
        return this.quizRepo.save(quiz);
    }

    //update quiz
    @Override
    public Quiz updateQuiz(Quiz quiz)
    {
        return this.quizRepo.save(quiz);
    }

    // get list of quizzes
    @Override
    public List<Quiz> getALLQuiz()
    {
        return this.quizRepo.findAll();
    }

    //get single quiz
    @Override
    public Quiz getSingle(Integer qId)
    {
        return this.quizRepo.findById(qId).get();
    }

    //delete quiz by id
    @Override
    public void deleteQuiz(Integer qId)
    {
        Quiz quiz =this.quizRepo.findById(qId).get();

        this.quizRepo.delete(quiz);

    }
}
