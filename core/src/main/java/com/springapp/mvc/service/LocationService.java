package com.springapp.mvc.service;

import com.springapp.mvc.domain.Location;

import java.util.List;

public interface LocationService {

    void addLocation(Location location);

    Location getLocation(Long locationId);

    Location updateLocation(Long locationId, Location location);

    void deleteLocation(Long locationId);

    List<Location> getAllLocations();

}