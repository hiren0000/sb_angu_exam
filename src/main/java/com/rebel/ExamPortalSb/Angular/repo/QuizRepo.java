package com.rebel.ExamPortalSb.Angular.repo;

import com.rebel.ExamPortalSb.Angular.models.exams.Category;
import com.rebel.ExamPortalSb.Angular.models.exams.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer>
{
   List<Quiz> findByCategory(Category category);

   List<Quiz> findByActive(Boolean b);

   List<Quiz> findByCategoryAndActive(Category c, Boolean b);
}
