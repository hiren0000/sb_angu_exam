package com.rebel.ExamPortalSb.Angular.service;

import com.rebel.ExamPortalSb.Angular.models.exams.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface CategoryService
{
    //creating service
    public Category addCategory(Category category);

    //update category
    public Category updateCate(Category category, Integer cId);

    //list of categories
    public List<Category> getAllCate();

    //get single category
    public Category getSingleCate(Integer cId);

    //delete Cate
    public void deleteCat(Integer cId);
}
