package com.elibrary.mum.project.repository;


import com.elibrary.mum.project.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {
}
