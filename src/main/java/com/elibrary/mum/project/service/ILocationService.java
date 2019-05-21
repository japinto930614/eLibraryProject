package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.Location;

import java.util.List;

public interface ILocationService {
    String createPost(Location book);
    boolean removeCategory(Location location);
    List<Location> listOfCategory();
    Location findOneCategory(Long id);
}
