package com.example.jfrd.modular.location.service.impl;

import com.example.jfrd.modular.location.dao.LocationMapper;
import com.example.jfrd.modular.location.pojo.Location;
import com.example.jfrd.modular.location.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements ILocationService {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public List<Location> locationList() {
        return locationMapper.locationList();
    }

    @Override
    public Location selectLocationById(String id) {
        return locationMapper.selectLocationById(id);
    }

    @Override
    public void addLocation(Location location) {
        Location locationNew = new Location();
        locationNew.setDeviceId(location.getDeviceId());
        locationNew.setLabel(location.getLabel());
        locationNew.setDeviceRssi(location.getDeviceRssi());
        locationNew.setCreateTime(location.getCreateTime());
        locationMapper.addLocation(locationNew);
    }

    @Override
    public void deleteLocationById(String id) {
        locationMapper.deleteLocationById(id);
    }
}
