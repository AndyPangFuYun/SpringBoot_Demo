package com.example.jfrd.modular.personnel.service.impl;

import com.example.jfrd.modular.personnel.dao.PersonnelMapper;
import com.example.jfrd.modular.personnel.pojo.Personnel;
import com.example.jfrd.modular.personnel.service.IPersonnelService;
import com.example.jfrd.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IPersonnelServiceImpl implements IPersonnelService {

    @Autowired
    private PersonnelMapper personnelMapper;

    @Override
    public List<Personnel> personnelList(String start,String end,String personnelName) {
        return personnelMapper.personnelList(start,end,personnelName);
    }

    @Override
    public int queryAllCount(String start, String end, String personnelName) {
        return personnelMapper.queryAllCount(start,end,personnelName);
    }

    @Override
    public JsonResult selectPersonnelById(String id) {
        JsonResult jsonResult = new JsonResult();
        Map<Object,Object> map = new HashMap<>();
        Personnel personnel = personnelMapper.selectPersonnelById(id);
        if (personnel != null){
            jsonResult.setCode("200");
            jsonResult.setMessage("服务器：查询成功");
            map.put("personnel",personnel);
            jsonResult.setMap(map);
        } else {
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：没有此人员");
        }
        return jsonResult;
    }

    @Override
    public JsonResult addPersonnel(Personnel personnel) {
        JsonResult jsonResult = new JsonResult();
        if (personnel != null){
            if (personnel.getLabel() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入标签号");
                return jsonResult;
            }
            if (personnel.getPersonnelName() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入姓名");
                return jsonResult;
            }
            if (personnel.getPersonnelPhone() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入联系方式");
                return jsonResult;
            }
        }else {
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：无法添加，请刷新后重试");
            return jsonResult;
        }
        Personnel personnelNew = new Personnel();
        personnelNew.setLabel(personnel.getLabel());
        personnelNew.setPersonnelName(personnel.getPersonnelName());
        personnelNew.setPersonnelPhone(personnel.getPersonnelPhone());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        personnelNew.setCreateTime(sdf.format(date));
        int success = personnelMapper.addPersonnel(personnelNew);
        if (success == 0){
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：添加失败");
        } else {
            jsonResult.setCode("200");
            jsonResult.setMessage("服务器：添加成功");
        }
        return jsonResult;
    }

    @Override
    public JsonResult deletePersonnelById(String id) {
        JsonResult jsonResult = new JsonResult();
        int success = personnelMapper.deletePersonnelById(id);
        if (success == 0){
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：删除失败");
        } else {
            jsonResult.setCode("200");
            jsonResult.setMessage("服务器：删除成功");
        }
        return jsonResult;
    }

    @Override
    public JsonResult updatePersonnel(Personnel personnel) {
        JsonResult jsonResult = new JsonResult();
        if (personnel != null){
            if (personnel.getLabel() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入标签号");
                return jsonResult;
            }
            if (personnel.getPersonnelName() == null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入员工姓名");
                return jsonResult;
            }
            if (personnel.getPersonnelPhone() ==null){
                jsonResult.setCode("500");
                jsonResult.setMessage("服务器：请输入联系电话");
                return jsonResult;
            }
        }else {
            jsonResult.setCode("500");
            jsonResult.setMessage("服务器：无法修改，请刷新后重试");
            return jsonResult;
        }
        Personnel personnelobj = personnelMapper.selectPersonnelById(personnel.getId());
        personnelobj.setLabel(personnel.getLabel());
        personnelobj.setPersonnelName(personnel.getPersonnelName());
        personnelobj.setPersonnelPhone(personnel.getPersonnelPhone());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        personnelobj.setCreateTime(sdf.format(date));

        int success = personnelMapper.updatePersonnel(personnelobj);
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
