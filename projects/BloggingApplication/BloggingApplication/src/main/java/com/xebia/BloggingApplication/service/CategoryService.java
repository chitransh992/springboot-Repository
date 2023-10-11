package com.xebia.BloggingApplication.service;

import com.xebia.BloggingApplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto,int categoryId);
    //delete
    void deleteCategory(int categoryId);
    //read
    CategoryDto readCategories(int categoryId);

    //readAll
    List<CategoryDto> readAllCategories();
}
