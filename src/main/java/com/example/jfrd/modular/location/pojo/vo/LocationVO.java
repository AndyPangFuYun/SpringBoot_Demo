package com.example.jfrd.modular.location.pojo.vo;

public class LocationVO {
    /**
     * 人员定位信息id
     */
    private String id;
    /**
     * 标签号
     */
    private String label;
    /**
     * 人员名称
     */
    private String personnelName;
    /**
     * 设备名称
     */
    private String deviceName;
    /**
     * 设备的RSSI值
     */
    private String deviceRssi;
    /**
     * 设备的安装地址
     */
    private String deviceAddr;
    /**
     * 创建时间
     */
    private String createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPersonnelName() {
        return personnelName;
    }

    public void setPersonnelName(String personnelName) {
        this.personnelName = personnelName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceRssi() {
        return deviceRssi;
    }

    public void setDeviceRssi(String deviceRssi) {
        this.deviceRssi = deviceRssi;
    }

    public String getDeviceAddr() {
        return deviceAddr;
    }

    public void setDeviceAddr(String deviceAddr) {
        this.deviceAddr = deviceAddr;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "LocationVO{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", personnelName='" + personnelName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceRssi='" + deviceRssi + '\'' +
                ", deviceAddr='" + deviceAddr + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
