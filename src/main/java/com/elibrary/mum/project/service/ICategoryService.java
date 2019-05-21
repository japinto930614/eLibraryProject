package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.Book;
import com.elibrary.mum.project.model.BookCopy;
import com.elibrary.mum.project.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    Category createCategory(Category category);
    void removeCategory(Category category);
    List<Category> getAllCategories();
    Optional<Category> findCategoryByNumber (int categoryNumber);



}
