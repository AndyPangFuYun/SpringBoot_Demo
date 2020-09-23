package com.example.jfrd.modular.location.dao;

import com.example.jfrd.modular.location.pojo.Location;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface LocationMapper extends BaseMapper<Location> {

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
