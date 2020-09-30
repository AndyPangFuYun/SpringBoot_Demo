package com.example.jfrd.modular.device.service.impl;

import com.example.jfrd.modular.device.dao.DeviceMapper;
import com.example.jfrd.modular.device.pojo.Device;
import com.example.jfrd.modular.device.service.IDeviceService;
import com.example.jfrd.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceServiceImpl implements IDeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public int queryAllCount(String start, String end, String deviceName) {
        return deviceMapper.queryAllCount(start,end,deviceName);
    }

    /**
     * 查询所有设备
     * @return 设备list
     */
    @Override
    public List<Device> deviceList(String start, String end, String deviceName) {
        return deviceMapper.deviceList(start,end,deviceName);
    }

    /**
     * 添加设备
     * @param device 设备
     */
    @Override
    public JsonResult addDevice(Device device) {
        JsonResult jsonResult = new JsonResult();
        if (device != null){
            if (device.getDeviceId() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入设备ID");
                return jsonResult;
            }
            if (device.getDeviceName() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入设备名称");
                return jsonResult;
            }
            if (device.getDeviceType() ==null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入设备类型");
                return jsonResult;
            }
            if (device.getDeviceAddr() ==null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入设备安装位置");
                return jsonResult;
            }
        }else {
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：无法添加，请刷新后重试");
            return jsonResult;
        }
        Device deviceNew = new Device();
        deviceNew.setDeviceId(device.getDeviceId());
        deviceNew.setDeviceName(device.getDeviceName());
        deviceNew.setDeviceType(device.getDeviceType());
        deviceNew.setDeviceAddr(device.getDeviceAddr());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        deviceNew.setCreateTime(sdf.format(date));
        int success = deviceMapper.addDevice(deviceNew);
        if (success == 0){
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：添加失败");
        } else {
            jsonResult.setCode("200");
            jsonResult.setMessage("服务器：添加成功");
        }
        return jsonResult;
    }

    /**
     * 删除设备
     * @param id 设备IDe
     */
    @Override
    public JsonResult deleteDeviceById(String id) {
        JsonResult jsonResult = new JsonResult();
        int success = deviceMapper.deleteDeviceById(id);
//        int success = 0;
        if (success == 0){
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：删除失败");
        } else {
            jsonResult.setCode("200");
            jsonResult.setMessage("服务器：删除成功");
        }
        return jsonResult;
    }

    /**
     * 根据设备ID查询设备
     * @param id 设备ID
     * @return 设备信息
     */
    @Override
    public JsonResult selectDeviceById(String id) {
        JsonResult jsonResult = new JsonResult();
        Map<Object,Object> map = new HashMap<>();
        Device device = deviceMapper.selectDeviceById(id);
        if (device != null){
            jsonResult.setCode("200");
            jsonResult.setMessage("服务器：查询成功");
            map.put("device",device);
            jsonResult.setMap(map);
        } else {
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：没有此设备");
        }
        return jsonResult;
    }

    @Override
    public JsonResult updateDevice(Device device) {
        JsonResult jsonResult = new JsonResult();
        if (device != null){
            if (device.getDeviceId() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入设备ID");
                return jsonResult;
            }
            if (device.getDeviceName() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入设备名称");
                return jsonResult;
            }
            if (device.getDeviceType() ==null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入设备类型");
                return jsonResult;
            }
            if (device.getDeviceAddr() ==null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入设备安装位置");
                return jsonResult;
            }
        }else {
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：无法修改，请刷新后重试");
            return jsonResult;
        }
        Device deviceobj = deviceMapper.selectDeviceById(device.getId());
        deviceobj.setDeviceId(device.getDeviceId());
        deviceobj.setDeviceName(device.getDeviceName());
        deviceobj.setDeviceType(device.getDeviceType());
        deviceobj.setDeviceAddr(device.getDeviceAddr());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        deviceobj.setCreateTime(sdf.format(date));

        int success = deviceMapper.updateDevice(deviceobj);
        if (success == 0){
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：修改失败，请刷新后重试");
        } else {
            jsonResult.setCode("200");
            jsonResult.setMessage("服务器：修改成功");
        }
        return jsonResult;
    }
}
