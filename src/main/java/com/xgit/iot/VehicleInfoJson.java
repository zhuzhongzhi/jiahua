package com.xgit.iot;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

/**
 * @author zhaoshengming
 * @create 2019-03-26 17:10
 **/
//@Measurement(name="vehicle_info",database = "iot_vehicle_jt")
@Measurement(name="vehicle_info")
public class VehicleInfoJson {

    @Column(name="time")
    private String time;
    @Column(name="detail_info")
    private String detail_info;
    @Column(name="vehicle_id")
    private String vehicle_id;

    public VehicleInfoJson() {
    }

    public VehicleInfoJson(String time, String detail_info, String vehicle_id) {
        this.time = time;
        this.detail_info = detail_info;
        this.vehicle_id = vehicle_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getDetail_info() {
        return detail_info;
    }

    public void setDetail_info(String detail_info) {
        this.detail_info = detail_info;
    }
}
