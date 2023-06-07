package com.rebel.ExamPortalSb.Angular.controller;

import com.rebel.ExamPortalSb.Angular.models.exams.Category;
import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;
import com.rebel.ExamPortalSb.Angular.service.CategoryService;
import com.rebel.ExamPortalSb.Angular.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController
{
    @Autowired
    private QuizService quizService;

    //Adding new Quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
    {
        Quiz addedQuiz = this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(addedQuiz);
    }

    //get single quiz by id
    @GetMapping("/{qId}")
    public Quiz getQuiz(@PathVariable Integer qId)
    {
        return this.quizService.getSingle(qId);
    }

    //get list of quiz
    @GetMapping("/")
    public ResponseEntity<?> getListOfQuiz()
    {
        return ResponseEntity.ok(this.quizService.getALLQuiz());
    }

    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateCategory(@RequestBody Quiz quiz)
    {
        Quiz updatedQuiz = this.quizService.updateQuiz(quiz);

        return ResponseEntity.ok(updatedQuiz);

    }


    //Delete quiz
    @DeleteMapping("/{qId}")
    public void deleteCate(@PathVariable Integer qId)
    {
        this.quizService.deleteQuiz(qId);
    }


    //Getting List of Quizzes by category
    @GetMapping("/category/{cId}")
    public ResponseEntity<List<Quiz>> getAllQuizByCat(@PathVariable Integer cId)
    {
        return ResponseEntity.ok(this.quizService.getQuizzesByCategory(cId));
    }


    //Get only Activated Quizzes
    @GetMapping("/active")
    public ResponseEntity<List<Quiz>> getQuizzesAc()
    {
        return ResponseEntity.ok(this.quizService.getActiveQuizzes());
    }


    //Get
    @GetMapping("/category/active/{cId}")
    public ResponseEntity<List<Quiz>> getAllActiveQuizByCat(@PathVariable Integer cId)
    {
        Category category = new Category();
        category.setcId(cId);

        return ResponseEntity.ok(this.quizService.getActiveQuizzesOfCategory(category));
    }



}
