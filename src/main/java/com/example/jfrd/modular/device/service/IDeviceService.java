package com.example.jfrd.modular.device.service;

import com.example.jfrd.modular.device.pojo.Device;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDeviceService {

    /**
     * 查询所有设备
     * @return 设备集合
     */
    List<Device> deviceList();


    /**
     * 添加设备
     * @param device 设备
     */
    void addDevice(Device device);

    /**
     * 物理删除设备
     * @param deviceId 设备IDe
     */
    void deleteDeviceById(String deviceId);

    /**
     * 根据设备ID查询设备
     * @param deviceId 设备ID
     * @return 设备信息
     */
    Device selectDeviceById(String deviceId);
}
