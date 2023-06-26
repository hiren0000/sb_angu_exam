package com.rebel.ExamPortalSb.Angular.controller;

import com.rebel.ExamPortalSb.Angular.models.exams.Question;
import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;
import com.rebel.ExamPortalSb.Angular.repo.QuizRepo;
import com.rebel.ExamPortalSb.Angular.service.QuestionService;
import com.rebel.ExamPortalSb.Angular.service.QuizService;
import com.rebel.ExamPortalSb.Angular.util.ApiRepsonse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/question")
public class QuestionController 
{
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //Adding new Question
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        Question addedQuestion = this.questionService.addQuestion(question);
        return ResponseEntity.ok(addedQuestion);
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> updateCategory(@RequestBody Question question)
    {
        Question updatedQuestion = this.questionService.updateQuestion(question);

        return ResponseEntity.ok(updatedQuestion);

    }

    //get list of Questions
    @GetMapping("/")
    public ResponseEntity<?> getListOfQuestion()
    {
        return ResponseEntity.ok(this.questionService.getAllQues());
    }


    //get single quiz by id
    @GetMapping("/{quesId}")
    public Question getQuestion(@PathVariable Integer quesId)
    {
        return this.questionService.getSingleQuestions(quesId);
    }


    //Delete quiz
    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable Integer quesId)
    {
        this.questionService.deleteQuestionS(quesId);
    }


    //get all questions of any quiz as per the Get number of questions
    @GetMapping("/quiz/{qId}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable Integer qId)
    {
        /*Quiz quiz = new Quiz();
        quiz.setqId(qId);
        List<Question> questionsofQuiz =  this.questionService.getQuestionsOfQuiz(quiz);

        return ResponseEntity.ok(questionsofQuiz);*/

        Quiz quiz = this.quizService.getSingle(qId);
        List<Question> list = quiz.getQuestions();

        if((list.size()) > Integer.parseInt(quiz.getNumberOfQuestions()))
        {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);

        return ResponseEntity.ok(list);

    }



    // to get all questions by Quiz for Admin
    @GetMapping("/quiz/all/{qId}")
    public ResponseEntity<?> getAllQuestionOfQuiz(@PathVariable Integer qId)
    {
        Quiz quiz = new Quiz();
        quiz.setqId(qId);
        List<Question> questionsOfQuiz =  this.questionService.getQuestionsOfQuiz(quiz);

        return ResponseEntity.ok(questionsOfQuiz);



    }

    //Calculating Quiz marks
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
    {

        Double gotTotalMarks = 0.0;
        Integer correctAnswers = 0;
        Integer attempted = 0;

       for(Question q : questions)
       {
           //get question by id
           Question localQuestion = this.questionService.getSingleQuestions(q.getQuesId());

           if (localQuestion.getAnswer().equals(q.getGivenAnswer()))
           {
               //correct
               correctAnswers++;

               //calculating marks on the basis of quiz max marks
               double singMark = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
               gotTotalMarks += singMark;
           }

           if(q.getGivenAnswer() != null)
           {
               //--this will give us the attempting quizzes---
               attempted++;
           }
       }

        Map<String, Object> map = Map.of("gotTotalMarks", gotTotalMarks, "correct", correctAnswers, "attemptQuestions", attempted);
        return ResponseEntity.ok(map);
    }


}
