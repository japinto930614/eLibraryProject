package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User addUser(User user);
    List<User> getAllUsers();
    Optional<User> findByUserNumber(Long userId);
    void delete(Long id);
}
