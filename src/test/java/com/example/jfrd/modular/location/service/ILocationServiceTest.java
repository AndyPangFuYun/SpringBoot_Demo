package com.example.jfrd.modular.location.service;

import com.example.jfrd.modular.location.pojo.Location;
import com.example.jfrd.modular.location.service.impl.LocationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ILocationServiceTest {

    @Autowired
    private LocationServiceImpl service;

    @Test
    void list(){
        System.out.println(service.locationList());
    }

    @Test
    void add(){
        Location location = new Location();
        location.setDeviceId("2");
        location.setLabel("123");
        location.setDeviceRssi("-23");
        location.setCreateTime("2020-09-21 21:07:41");
        service.addLocation(location);
    }
}