package com.example.jfrd.modular.personnel.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_personnel_info")
public class Personnel {

    @Id
    //主键回填
    @KeySql(useGeneratedKeys = true)
    private String id;

    //标签号
    @Column(name = "label")
    private String label;

    //员工姓名
    @Column(name = "personnel_name")
    private String personnelName;

    //联系方式
    @Column(name = "personnel_phone")
    private String personnelPhone;

    //创建时间
    @Column(name = "createtime")
    private String createTime;
}
