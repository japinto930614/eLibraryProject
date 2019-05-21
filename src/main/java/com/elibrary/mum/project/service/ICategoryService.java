package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.Book;
import com.elibrary.mum.project.model.Category;

import java.util.List;

public interface ICategoryService {
    String createPost(Book book);
    boolean removeCategory(Category category);
    List<Category> listOfCategory();
    Category findOneCategory(Long id);




}
