package com.elibrary.mum.project.repository;

import com.elibrary.mum.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository <User,Long> {
}
