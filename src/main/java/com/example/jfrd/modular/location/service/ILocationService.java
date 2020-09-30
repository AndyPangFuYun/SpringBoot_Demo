package com.example.jfrd.modular.location.service;

import com.example.jfrd.modular.location.pojo.Location;
import com.example.jfrd.modular.location.pojo.vo.LocationVO;
import com.example.jfrd.util.JsonResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILocationService {

    /**
     * 查询所有的定位信息
     * @return
     */
    List<Location> locationList();
    List<LocationVO> getLocationVoAll();

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

    /**
     * 查询数据量
     * @param start 开始时间
     * @param end 截止时间
     * @param personnelName 姓名
     * @return List<LocationVO>
     */
    int queryAllCount(String start, String end, String personnelName);

    /**
     * 模糊查询
     * @param start 开始时间
     * @param end   截止时间
     * @param personnelName 姓名
     * @return List<LocationVO>
     */
    List<LocationVO> getLocationVoLike(String start, String end, String personnelName);
}
