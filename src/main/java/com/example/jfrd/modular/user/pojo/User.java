package com.example.jfrd.modular.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_user")
public class User {
    @Id
    //主键回填
    @KeySql(useGeneratedKeys = true)
    private String id;

    private String username;

    private String password;
}
