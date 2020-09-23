package com.example.jfrd.modular.personnel.controller;

import com.example.jfrd.modular.personnel.pojo.Personnel;
import com.example.jfrd.modular.personnel.service.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/personnel")
public class PersonnelController {

    @Autowired
    private IPersonnelService IPersonnelService;


    /**
     * 查询所有人员
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object personnelList(){
        List<Personnel> list = IPersonnelService.personnelList();
        return list;
    }

    /**
     * 根据ID查询人员信息
     * @param id 人员ID
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/selectPersonnelById/{id}",method = RequestMethod.GET)
    public Object selectPersonnelById(@PathVariable String id){
     return IPersonnelService.selectPersonnelById(id);
    }

    /**
     * 添加设备
     * @param personnel 人员信息
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Object addPersonnel(Personnel personnel){
        IPersonnelService.addPersonnel(personnel);
        return null;
    }

    /**
     * 删除人员
     * @param id 人员ID
     * @return 成功 200 ，失败 500
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public Object deletePersonnelById(@PathVariable String id){
        IPersonnelService.deletePersonnelById(id);
        return null;
    }

}
