package com.example.jfrd.modular.personnel.dao;

import com.example.jfrd.modular.personnel.pojo.Personnel;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface PersonnelMapper extends BaseMapper<Personnel>{

    /**
     * 模糊查询
     * @param start 开始时间
     * @param end 截止时间
     * @param personnelName 人员名
     * @return 查询到的集合
     */
    List<Personnel> personnelList(@Param(value = "start")String start, @Param(value = "end")String end, @Param(value = "personnelName")String personnelName);

    /**
     *
     * @param start 开始时间
     * @param end   截止时间
     * @param personnelName 人员名
     * @return 查询的数量
     */
    int queryAllCount(@Param(value = "start")String start, @Param(value = "end")String end, @Param(value = "personnelName")String personnelName);

    /**
     * 根据ID查询人员的基本信息
     * @param id 人员ID
     * @return 人员信息
     */
    Personnel selectPersonnelById(@Param(value = "id")String id);

    /**
     * 新增人员基本信息
     * @param personnel 人员信息
     */
    Integer addPersonnel(Personnel personnel);

    /**
     * 根据人员Id物理删除
     * @param id 人员ID
     */
    Integer deletePersonnelById(@Param(value = "id")String id);

    /**
     * 修改人员信息
     * @param personnel 人员
     * @return 修改后的设备
     */
    Integer updatePersonnel(Personnel personnel);
}
