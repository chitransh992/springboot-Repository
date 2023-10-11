package com.xebia.BloggingApplication.controller;

import com.xebia.BloggingApplication.payloads.ApiResponse;
import com.xebia.BloggingApplication.payloads.CategoryDto;
import com.xebia.BloggingApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    //create
    @PostMapping("/")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryDto categoryDto){
        categoryService.createCategory(categoryDto);
        return new ResponseEntity(new ApiResponse("Category Created Successfully",true), HttpStatus.CREATED);
    }

    //update

    @PutMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable int categoryId){
        categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity(new ApiResponse("Category Updated Successfully",true),HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity(new ApiResponse("Category Deleted SuccessFully",true),HttpStatus.OK);
    }

    //getAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categoryDtos = categoryService.readAllCategories();
        return ResponseEntity.ok(categoryDtos);
    }
    //get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int categoryId){
        CategoryDto categoryDto = categoryService.readCategories(categoryId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
    }
}
