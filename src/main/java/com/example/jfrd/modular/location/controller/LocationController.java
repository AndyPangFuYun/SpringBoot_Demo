package com.example.jfrd.modular.location.controller;

import com.example.jfrd.modular.location.pojo.Location;
import com.example.jfrd.modular.location.pojo.vo.LocationVO;
import com.example.jfrd.modular.location.service.ILocationService;
import com.example.jfrd.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private ILocationService ILocationService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public Object list() {
//        return ILocationService.locationList();
//    }

    @CrossOrigin
    @RequestMapping(value = "/locationList", method = RequestMethod.GET)
    public Object locationList() {
        List<LocationVO> locationVOList = ILocationService.getLocationVoAll();
        return locationVOList;
    }

    @RequestMapping(value = "/selectLocationById", method = RequestMethod.GET)
    public Object selectLocationById(@PathVariable String id) {
        return ILocationService.selectLocationById(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody Location location){
        ILocationService.addLocation(location);
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(@PathVariable String id) {
        ILocationService.deleteLocationById(id);
        return null;
    }

//    @ResponseBody
//    @RequestMapping(value = "/list",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
//    public Object getLocationVoLike(String start,String end,String personnelName){
//        System.out.println("start: " + start);
//        System.out.println("end: " + end);
//        System.out.println("personnelName: " + personnelName);
//        return ILocationService.getLocationVoLike(start,end,personnelName);
//    }


    //测试用
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public Object getLocationVoLike(String start,String end,String personnelName){
        List<LocationVO> data = ILocationService.getLocationVoLike(start,end,personnelName);
        int count=  ILocationService.queryAllCount(start,end,personnelName);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",data);
        return map;
    }

}
