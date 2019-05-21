package com.elibrary.mum.project.repository;

import com.elibrary.mum.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository  extends JpaRepository<Category,Integer> {
}
