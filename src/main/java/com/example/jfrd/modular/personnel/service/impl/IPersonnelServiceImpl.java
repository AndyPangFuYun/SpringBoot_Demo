package com.example.jfrd.modular.personnel.service.impl;

import com.example.jfrd.modular.personnel.dao.PersonnelMapper;
import com.example.jfrd.modular.personnel.pojo.Personnel;
import com.example.jfrd.modular.personnel.service.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IPersonnelServiceImpl implements IPersonnelService {

    @Autowired
    private PersonnelMapper personnelMapper;

    @Override
    public List<Personnel> personnelList() {
        return personnelMapper.personnelList();
    }

    @Override
    public Personnel selectPersonnelById(String id) {
        return personnelMapper.selectPersonnelById(id);
    }

    @Override
    public void addPersonnel(Personnel personnel) {
        Personnel personnelNew = new Personnel();
        personnelNew.setLabel(personnel.getLabel());
        personnelNew.setPersonnelName(personnel.getPersonnelName());
        personnelNew.setPersonnelPhone(personnel.getPersonnelPhone());
        personnelNew.setCreateTime(new Date());
        personnelMapper.addPersonnel(personnelNew);
    }

    @Override
    public void deletePersonnelById(String id) {
        personnelMapper.deletePersonnelById(id);
    }
}
