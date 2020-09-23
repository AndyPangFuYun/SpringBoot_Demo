package com.example.jfrd.modular.device.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_device")
public class Device {
    @Id
    //主键回填
    @KeySql(useGeneratedKeys = true)
    private String id;

    //设备ID
    @Column(name = "device_id")
    private String deviceId;

    //设备名称
    @Column(name = "device_name")
    private String deviceName;

    //设备类型
    @Column(name = "device_type")
    private String deviceType;

    //设备地址
    @Column(name = "device_addr")
    private String deviceAddr;

    //创建时间
    @Column(name = "createtime")
    private Date createTime;
}
