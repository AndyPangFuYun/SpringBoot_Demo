package com.example.jfrd.modular.user.pojo;


import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {
    @Id
    //主键回填
    @KeySql(useGeneratedKeys = true)
    private String id;

    //用户名
    @Column(name = "username")
    private String username;

    //用户密码
    @Column(name = "password")
    private String password;

    //盐值
    @Column(name = "salt")
    private String salt;

    //性别
    @Column(name = "sex")
    private int sex;

    //名字
    @Column(name = "name")
    private String name;

    //出生日期
    @Column(name = "birthday")
    private String birthday;

    //电子邮件
    @Column(name = "email")
    private String email;

    //电话
    @Column(name = "phone")
    private String phone;

    //角色ID
    @Column(name = "roleid")
    private String roleId;

    //部门ID
    @Column(name = "deptid")
    private String deptId;

    //状态（1：启用、2：冻结、3：删除）
    @Column(name = "status")
    private int status;

    //创建时间
    @Column(name = "createtime")
    private String createTime;
}
