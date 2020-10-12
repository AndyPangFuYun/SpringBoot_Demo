package com.example.jfrd.modular.device.controller;

import com.example.jfrd.modular.device.pojo.Device;
import com.example.jfrd.modular.device.service.IDeviceService;
import com.example.jfrd.util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "DeviceController" ,description = "设备数据接口")   //对controller的描述
@RestController
@RequestMapping(value = "/device")
public class DeviceController {

    @Autowired
    private IDeviceService deviceService;

    /**
     * 模糊查询所有设备
     *
     * @return 成功 200 ，失败 500
     */
    @ApiOperation(value = "模糊查询所有设备", notes = "根据用户id查询用户")   //对方法的描述
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "start", value = "开始时间", required = false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "end", value = "结束时间", required = false,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "deviceName", value = "设备名称", required = false,dataType = "String")
    })
    public Object DeviceList(String start,String end,String deviceName) {
        List<Device> list = deviceService.deviceList(start,end,deviceName);
        int count=  deviceService.queryAllCount(start,end,deviceName);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    /**
     * 根据ID查询设备
     *
     * @param id 设备ID
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/selectDeviceById", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JsonResult selectDeviceById(@Param(value = "id") String id) {
        JsonResult jsonResult = deviceService.selectDeviceById(id);
        return jsonResult;
    }

    /**
     * 添加设备
     *
     * @param device 设备信息
     * @return 成功 200 ，失败 500
     */
//    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addDevice(@RequestBody Device device) {
        JsonResult jsonResult = deviceService.addDevice(device);
        return jsonResult;
    }

    /**
     * 删除设备
     *
     * @param id 设备ID
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public JsonResult deleteDeviceById(@Param(value = "id") String id) {
        JsonResult jsonResult = deviceService.deleteDeviceById(id);
        return jsonResult;
    }

    /**
     * 修改设备
     * @param device 设备信息
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult updateDevice(@RequestBody Device device){
        JsonResult jsonResult = deviceService.updateDevice(device);
        return jsonResult;
    }
}
