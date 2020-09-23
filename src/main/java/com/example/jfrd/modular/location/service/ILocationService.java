package com.example.jfrd.modular.location.service;

import com.example.jfrd.modular.location.pojo.Location;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationService {

    /**
     * 查询所有的定位信息
     * @return
     */
    List<Location> locationList();

    /**
     * 根据id查询单条记录
     * @param id
     * @return
     */
    Location selectLocationById(String id);

    /**
     * 新增定位信息
     * @param location
     */
    void addLocation(Location location);

    /**
     * 根据id删除
     * @param id
     */
    void deleteLocationById(String id);
}
