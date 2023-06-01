package com.rebel.ExamPortalSb.Angular.controller;

import com.rebel.ExamPortalSb.Angular.models.exams.Category;
import com.rebel.ExamPortalSb.Angular.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    //Adding new category
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category)
    {
        Category addedCate = this.categoryService.addCategory(category);
        return ResponseEntity.ok(addedCate);
    }

    //get single category by id
    @GetMapping("/{cId}")
    public Category getCategory(@PathVariable Integer cId)
    {
        return this.categoryService.getSingleCate(cId);
    }

    //get list of categories
    @GetMapping("/")
    public ResponseEntity<?> getListOfCategory()
    {
        return ResponseEntity.ok(this.categoryService.getAllCate());
    }

    //update category
    @PutMapping("/{cId}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Integer cId)
    {
        Category updatedCate = this.categoryService.updateCate(category, cId);

        return ResponseEntity.ok(updatedCate);

    }

    //Delete Category
    @DeleteMapping("/{cId}")
     public void deleteCate(@PathVariable Integer cId)
    {
        this.categoryService.deleteCat(cId);
    }

}
