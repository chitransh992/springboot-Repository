package com.xebia.BloggingApplication.service.Impl;

import com.xebia.BloggingApplication.entites.Category;
import com.xebia.BloggingApplication.exceptions.ResouceNotFoundException;
import com.xebia.BloggingApplication.payloads.CategoryDto;
import com.xebia.BloggingApplication.payloads.UserDto;
import com.xebia.BloggingApplication.repositories.CategoryRepository;
import com.xebia.BloggingApplication.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    CategoryServiceImplementation(CategoryRepository categoryRepository,ModelMapper modelMapper){
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = modelMapper.map(categoryDto,Category.class);
        Category addCategory = categoryRepository.save(cat);
        return modelMapper.map(addCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) {
        Category cat = categoryRepository.findById(categoryId).orElseThrow(()->new ResouceNotFoundException("Category","Id",categoryId));
        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());
        Category savedCategory = categoryRepository.save(cat);
        return modelMapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public void deleteCategory(int categoryId) {
        Category cat = categoryRepository.findById(categoryId).orElseThrow(()->new ResouceNotFoundException("Category","Id",categoryId));
        categoryRepository.delete(cat);
    }

    @Override
    public CategoryDto readCategories(int categoryId) {
        Category cat = categoryRepository.findById(categoryId).orElseThrow(()->new ResouceNotFoundException("Category","Id",categoryId));
        return modelMapper.map(cat,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> readAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> catDtos = categories.stream().map((cat)->modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
        return catDtos;
    }
}
