package com.example.jfrd.modular.location.service.impl;

import com.example.jfrd.config.BizExceptionEnum;
import com.example.jfrd.config.GuiMedicalException;
import com.example.jfrd.modular.location.dao.LocationMapper;
import com.example.jfrd.modular.location.pojo.Location;
import com.example.jfrd.modular.location.pojo.vo.LocationVO;
import com.example.jfrd.modular.location.service.ILocationService;
import com.example.jfrd.util.JsonResult;
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
    public List<LocationVO> getLocationVoAll() {
        return locationMapper.getLocationVoAll();
    }

    @Override
    public Location selectLocationById(String id) {
        return locationMapper.selectLocationById(id);
    }

    @Override
    public void addLocation(Location location) {
        if (location.getLabel().isEmpty()){
            throw new GuiMedicalException(BizExceptionEnum.USER_NOT_EXISTED.getCode(),BizExceptionEnum.USER_NOT_EXISTED.getMessage());
        }else {
            Location locationNew = new Location();
            locationNew.setDeviceId(location.getDeviceId());
            locationNew.setLabel(location.getLabel());
            locationNew.setDeviceRssi(location.getDeviceRssi());
            locationNew.setDeviceVersion(location.getDeviceVersion());
            locationNew.setCreateTime(location.getCreateTime());
            locationMapper.addLocation(locationNew);
        }
    }

    @Override
    public void deleteLocationById(String id) {
        locationMapper.deleteLocationById(id);
    }

    @Override
    public int queryAllCount(String start, String end, String personnelName) {
        return locationMapper.queryAllCount(start,end,personnelName);
    }

    @Override
    public List<LocationVO> getLocationVoLike(String start, String end, String personnelName) {
        List<LocationVO> list = locationMapper.getLocationVoLike(start,end,personnelName);
        return list;
    }
}
