package com.example.jfrd.modular.device.service;

import com.example.jfrd.modular.device.pojo.Device;
import com.example.jfrd.util.JsonResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDeviceService {

    /**
     * 查询数据量
     * @param start 开始时间
     * @param end 截止时间
     * @param deviceName 设备名
     * @return List<Device>
     */
    int queryAllCount(String start, String end, String deviceName);

    /**
     * 模糊查询
     * @param start 开始时间
     * @param end   截止时间
     * @param deviceName 设备名
     * @return List<Device>
     */
    List<Device> deviceList(String start, String end, String deviceName);


    /**
     * 添加设备
     * @param device 设备
     */
    JsonResult addDevice(Device device);

    /**
     * 物理删除设备
     * @param id 设备ID
     */
    JsonResult deleteDeviceById(String id);

    /**
     * 根据设备ID查询设备
     * @param deviceId 设备ID
     * @return 设备信息
     */
    JsonResult selectDeviceById(String deviceId);

    /**
     * 修改设备
     * @param device 设备
     * @return 修改后的设备
     */
    JsonResult updateDevice(Device device);
}
