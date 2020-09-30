package com.example.jfrd.modular.personnel.service;

import com.example.jfrd.modular.personnel.pojo.Personnel;
import com.example.jfrd.util.JsonResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonnelService {

    /**
     * 模糊查询
     * @param start 开始时间
     * @param end   截止时间
     * @param personnelName 人员名称
     * @return List<Personnel>
     */
    List<Personnel> personnelList(String start,String end,String personnelName);

    /**
     * 查询数据量
     * @param start 开始时间
     * @param end 截止时间
     * @param personnelName 人员名称
     * @return List<Personnel>
     */
    int queryAllCount(String start, String end, String personnelName);

    /**
     * 根据ID查询人员的基本信息
     * @param id 人员ID
     * @return 人员信息
     */
    JsonResult selectPersonnelById(String id);

    /**
     * 新增人员基本信息
     * @param personnel 人员信息
     */
    JsonResult addPersonnel(Personnel personnel);

    /**
     * 根据人员Id物理删除
     * @param id 人员ID
     */
    JsonResult deletePersonnelById(String id);

    /**
     * 修改人员信息
     * @param personnel 人员
     * @return 修改后的设备
     */
    JsonResult updatePersonnel(Personnel personnel);
}
