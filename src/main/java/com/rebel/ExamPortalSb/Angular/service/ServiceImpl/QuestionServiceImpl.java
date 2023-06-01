package com.rebel.ExamPortalSb.Angular.service.ServiceImpl;

import com.rebel.ExamPortalSb.Angular.models.exams.Question;
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
    public Question addQuestion(Question question)
    {
        return this.questionRepo.save(question);
    }

    //update question
    @Override
    public Question updateQuestion(Question question)
    {
        return this.questionRepo.save(question);
    }

    //get list of questions
    @Override
    public List<Question> getAllQues()
    {
        return this.questionRepo.findAll();
    }

    //get single question
    @Override
    public Question getSingleQuestions(Integer quesId)
    {
        return this.questionRepo.findById(quesId).get();
    }

    //delete question
    @Override
    public void deleteQuestionS(Integer quesId)
    {
        Question question = this.questionRepo.findById(quesId).get();

        this.questionRepo.delete(question);
    }

    //getting specific quiz questions
    @Override
    public List<Question> getQuestionsOfQuiz(Quiz quiz)
    {
        return this.questionRepo.findByQuiz(quiz);
    }
}
