package com.consumoApi.service;

import com.consumoApi.entities.Category;
import com.consumoApi.entities.Users;
import com.consumoApi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    private CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Integer id){
        categoryRepository.deleteById(id);
    }

    public List<Category> searchByName(){
        return categoryRepository.findAll();
    }

    public Category updateCategory(Integer id, Category category){
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if(existingCategory != null){
            existingCategory.setName(category.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }
}
