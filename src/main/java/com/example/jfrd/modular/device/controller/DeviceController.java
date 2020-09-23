package com.example.jfrd.modular.device.controller;

import com.example.jfrd.modular.device.pojo.Device;
import com.example.jfrd.modular.device.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    private IDeviceService deviceService;

    /**
     * 查询所有设备
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object DeviceList(){
        List<Device> list = deviceService.deviceList();
        return list;
    }

    /**
     * 根据ID查询设备
     * @param deviceId 设备ID
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/selectDeviceById/{id}",method = RequestMethod.GET)
    public Object selectDeviceById(@PathVariable String deviceId){
        return deviceService.selectDeviceById(deviceId);
    }

    /**
     * 添加设备
     * @param device 设备信息
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Object addDevice(Device device){
        deviceService.addDevice(device);
        return null;
    }

    /**
     * 删除设备
     * @param deviceId 设备ID
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Object deleteDeviceById(@PathVariable String deviceId){
        deviceService.deleteDeviceById(deviceId);
        return null;
    }
}
