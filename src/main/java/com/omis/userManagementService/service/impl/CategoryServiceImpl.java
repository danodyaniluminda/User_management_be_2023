package com.omis.userManagementService.service.impl;

import com.omis.userManagementService.models.Category;
import com.omis.userManagementService.repository.CategoryRepository;
import com.omis.userManagementService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        try {
            return categoryRepository.findById(id).orElse(null);
        }catch (Error e){
            return null;
        }
    }
}
