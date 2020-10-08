package com.example.jfrd.modular.personnel.controller;

import com.example.jfrd.modular.personnel.pojo.Personnel;
import com.example.jfrd.modular.personnel.service.IPersonnelService;
import com.example.jfrd.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/personnel")
public class PersonnelController {

    @Autowired
    private IPersonnelService personnelService;


    /**
     * 查询所有人员
     * @return 成功 200 ，失败 500
     */
    @CrossOrigin
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object personnelList(String start,String end,String personnelName){
        List<Personnel> list = personnelService.personnelList(start,end,personnelName);
        int count=  personnelService.queryAllCount(start,end,personnelName);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    /**
     * 根据ID查询人员信息
     * @param id 人员ID
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/selectPersonnelById",method = RequestMethod.GET)
    public JsonResult selectPersonnelById(@Param(value = "id")  String id){
        JsonResult jsonResult = personnelService.selectPersonnelById(id);
        return jsonResult;
    }

    /**
     * 添加人员
     * @param personnel 人员信息
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult addPersonnel(@RequestBody Personnel personnel){
        JsonResult jsonResult = personnelService.addPersonnel(personnel);
        return jsonResult;
    }

    /**
     * 删除人员
     * @param id 人员ID
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET ,produces = "application/json;charset=UTF-8")
    public JsonResult deletePersonnelById(@Param(value = "id") String id){
        JsonResult jsonResult = personnelService.deletePersonnelById(id);
        return jsonResult;
    }

    /**
     * 修改人员信息
     * @param personnel 人员信息
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public JsonResult updateDevice(@RequestBody Personnel personnel){
        JsonResult jsonResult = personnelService.updatePersonnel(personnel);
        return jsonResult;
    }

}
