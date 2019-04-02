package com.springapp.mvc.service.impl;
 
import com.springapp.mvc.domain.Location; 
import com.springapp.mvc.repository.LocationRepository; 
import com.springapp.mvc.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
 
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location getLocation(Long locationId) {
        return locationRepository.findById(locationId).orElse(null);
    }

    @Override
    public Location updateLocation(Long locationId, Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }

    @Override
    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }
}
