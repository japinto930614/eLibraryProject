package com.elibrary.mum.project.service.impl;

import com.elibrary.mum.project.model.User;
import com.elibrary.mum.project.model.UserType;
import com.elibrary.mum.project.repository.IUserTypeRepository;
import com.elibrary.mum.project.service.IUserService;
import com.elibrary.mum.project.service.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService implements IUserTypeService {

    @Autowired
    public IUserTypeRepository userTypeRepository;
    @Override
    public UserType addUserType(UserType userType) {
        return userTypeRepository.save(userType);
    }

    @Override
    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    @Override
    public Optional<UserType> findByUserTypeById(int userTypeId) {
        return userTypeRepository.findById(userTypeId);
    }

    @Override
    public void deleteUserType(UserType userType) {
        userTypeRepository.delete(userType);
    }
}
