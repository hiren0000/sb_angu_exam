package com.rebel.ExamPortalSb.Angular.repo;

import com.rebel.ExamPortalSb.Angular.models.exams.Questions;
import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Integer>
{
    List<Questions> findByQuiz(Quiz quiz);
}
