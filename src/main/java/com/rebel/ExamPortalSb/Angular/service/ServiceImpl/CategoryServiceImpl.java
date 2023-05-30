package com.rebel.ExamPortalSb.Angular.service.ServiceImpl;


import com.rebel.ExamPortalSb.Angular.models.exams.Category;
import com.rebel.ExamPortalSb.Angular.repo.CategoryRepo;
import com.rebel.ExamPortalSb.Angular.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepo categoryRepo;

    //Add new Category
    @Override
    public Category addCategory(Category category)
    {

        return this.categoryRepo.save(category);
    }

    //update Category
    @Override
    public Category updateCate(Category category, Integer cId)
    {
        Category existingCate = this.categoryRepo.findById(cId)
                .orElseThrow(()-> new ResourceAccessException("User not found with this ID"));

        existingCate.setDescription(category.getDescription());
        existingCate.setTitle(category.getTitle());

        Category updatedCate =this.categoryRepo.save(existingCate);

        return updatedCate;
    }

    //List of all categories
    @Override
    public List<Category> getAllCate() {

        List<Category> categories = this.categoryRepo.findAll();

        return categories;
    }

    // get Single Category
    @Override
    public Category getSingleCate(Integer cId)
    {

        Category category = this.categoryRepo.findById(cId)
                .orElseThrow(()-> new ResourceAccessException("User not found with this ID"));
        return category;
    }

    //Delete Category with Id
    @Override
    public void deleteCat(Integer cId)
    {
        Category category = this.categoryRepo.findById(cId)
                .orElseThrow(()-> new ResourceAccessException("User not found with this ID"));

        this.categoryRepo.delete(category);

    }
}
