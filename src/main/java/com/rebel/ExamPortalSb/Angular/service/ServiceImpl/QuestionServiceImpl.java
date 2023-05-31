package com.rebel.ExamPortalSb.Angular.service.ServiceImpl;

import com.rebel.ExamPortalSb.Angular.models.exams.Questions;
import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;
import com.rebel.ExamPortalSb.Angular.repo.QuestionRepo;
import com.rebel.ExamPortalSb.Angular.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService
{
    @Autowired
    private QuestionRepo questionRepo;

    // Add question
    @Override
    public Questions addQuestion(Questions questions)
    {
        return this.questionRepo.save(questions);
    }

    //update question
    @Override
    public Questions updateQuestion(Questions questions)
    {
        return this.questionRepo.save(questions);
    }

    //get list of questions
    @Override
    public List<Questions> getAllQues()
    {
        return this.questionRepo.findAll();
    }

    //get single question
    @Override
    public Questions getSingleQuestions(Integer quesId)
    {
        return this.questionRepo.findById(quesId).get();
    }

    //delete question
    @Override
    public void deleteQuestionS(Integer quesId)
    {
        Questions question = this.questionRepo.findById(quesId).get();

        this.questionRepo.delete(question);
    }

    //getting specific quiz questions
    @Override
    public List<Questions> getQuestionsOfQuiz(Quiz quiz)
    {
        return this.questionRepo.findByQuiz(quiz);
    }
}
