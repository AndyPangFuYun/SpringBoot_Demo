package com.example.jfrd.modular.device.dao;

import com.example.jfrd.modular.device.pojo.Device;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface DeviceMapper extends BaseMapper<Device> {
    /**
     * 查询数据量
     * @param start 开始时间
     * @param end 截止时间
     * @param deviceName 设备名
     * @return List<Device>
     */
    int queryAllCount(@Param(value = "start")String start, @Param(value = "end")String end, @Param(value = "deviceName")String deviceName);

    /**
     * 模糊查询
     * @param start 开始时间
     * @param end   截止时间
     * @param deviceName 设备名
     * @return List<Device>
     */
    List<Device> deviceList(@Param(value = "start")String start, @Param(value = "end")String end, @Param(value = "deviceName")String deviceName);

    /**
     * 根据设备ID查询设备
     * @param deviceId 设备ID
     * @return 设备信息
     */
    Device selectDeviceById(String deviceId);

    /**
     * 添加设备
     * @param device 设备
     */
    Integer addDevice(Device device);

    /**
     * 物理删除设备
     * @param deviceId 设备IDe
     */
    Integer deleteDeviceById(String deviceId);

    /**
     * 修改设备
     * @param device 设备
     * @return 修改后的设备
     */
    Integer updateDevice(Device device);
}
