package com.example.jfrd.modular.personnel.dao;

import com.example.jfrd.modular.personnel.pojo.Personnel;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface PersonnelMapper extends BaseMapper<Personnel>{

    /**
     * 查询全部人员基本信息
     * @return 人员基本信息
     */
    List<Personnel> personnelList();

    /**
     * 根据ID查询人员的基本信息
     * @param id 人员ID
     * @return 人员信息
     */
    Personnel selectPersonnelById(String id);

    /**
     * 新增人员基本信息
     * @param personnel 人员信息
     */
    void addPersonnel(Personnel personnel);

    /**
     * 根据人员Id物理删除
     * @param id 人员ID
     */
    void deletePersonnelById(String id);
}
