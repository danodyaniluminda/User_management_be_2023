package com.omis.userManagementService.service;

import com.omis.userManagementService.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category > getAllCategories();
    Category findById(Long id);
}
