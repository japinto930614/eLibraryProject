package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.User;
import com.elibrary.mum.project.model.UserType;

import java.util.List;
import java.util.Optional;

public interface IUserTypeService {
    User addUserType(UserType userType);
    List<UserType> getAllUserTypes();
    Optional<UserType> findByUserTypeById(int userTypeId);
}
