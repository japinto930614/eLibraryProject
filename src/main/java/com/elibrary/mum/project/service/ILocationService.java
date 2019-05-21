package com.elibrary.mum.project.service;

import com.elibrary.mum.project.model.Category;
import com.elibrary.mum.project.model.Location;

import java.util.List;
import java.util.Optional;

public interface ILocationService {
    Location createLocation(Location location);
    void removeLocation(Location location);
    List<Location> getAllLocations();
    Optional<Location> findLocationByNumber (int locationNumber);
}
