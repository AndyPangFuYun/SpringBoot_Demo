package com.example.jfrd.modular.location.controller;

import com.example.jfrd.modular.location.pojo.Location;
import com.example.jfrd.modular.location.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private ILocationService ILocationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object list() {
        return ILocationService.locationList();
    }

    @RequestMapping(value = "/selectLocationById/{id}", method = RequestMethod.GET)
    public Object selectLocationById(@PathVariable String id) {
        return ILocationService.selectLocationById(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody Location location){
        ILocationService.addLocation(location);
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Object delete(@PathVariable String id) {
        ILocationService.deleteLocationById(id);
        return null;
    }
}
