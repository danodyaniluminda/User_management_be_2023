package com.omis.userManagementService.controller;

import com.omis.userManagementService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user_management/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/get_all_categories")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

}
