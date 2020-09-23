package com.example.jfrd.modular.device.service.impl;

import com.example.jfrd.modular.device.dao.DeviceMapper;
import com.example.jfrd.modular.device.pojo.Device;
import com.example.jfrd.modular.device.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 查询所有设备
     * @return 设备list
     */
    @Override
    public List<Device> deviceList() {
        return deviceMapper.deviceList();
    }

    /**
     * 添加设备
     * @param device 设备
     */
    @Override
    public void addDevice(Device device) {
        Device deviceNew = new Device();
        deviceNew.setDeviceId(device.getDeviceId());
        deviceNew.setDeviceName(device.getDeviceName());
        deviceNew.setDeviceType(device.getDeviceType());
        deviceNew.setDeviceAddr(device.getDeviceAddr());
        deviceNew.setCreateTime(new Date());
        deviceMapper.addDevice(device);
    }

    /**
     * 删除设备
     * @param deviceId 设备IDe
     */
    @Override
    public void deleteDeviceById(String deviceId) {
        deviceMapper.deleteDeviceById(deviceId);
    }

    /**
     * 根据设备ID查询设备
     * @param deviceId 设备ID
     * @return 设备信息
     */
    @Override
    public Device selectDeviceById(String deviceId) {
        return deviceMapper.selectDeviceById(deviceId);
    }
}
