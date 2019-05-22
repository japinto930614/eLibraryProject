package com.elibrary.mum.project.service.impl;

import com.elibrary.mum.project.model.User;
import com.elibrary.mum.project.repository.IUserRepository;
import com.elibrary.mum.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    public IUserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by("firstName"));
    }


    @Override
    public User findByUserNumber(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
