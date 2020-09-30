package com.example.jfrd.modular.location.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_location_info")
public class Location {

    //主键ID
    @Id
    @KeySql(useGeneratedKeys = true)
    private String id;

    //设备ID
    @Column(name = "device_id")
    private String deviceId;

    //标签号
    @Column(name = "label")
    private String label;

    //当前设备信号强度值
    @Column(name = "device_rssi")
    private String deviceRssi;

    //设备固件版本
    @Column(name = "device_version")
    private String deviceVersion;

    //创建时间
    @Column(name = "createtime")
    private String createTime;
}
