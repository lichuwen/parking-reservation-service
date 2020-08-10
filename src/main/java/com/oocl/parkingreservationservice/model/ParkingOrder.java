package com.oocl.parkingreservationservice.model;

import javax.persistence.*;

@Entity
public class ParkingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer parkingLotId;
    private String  parkingStartTime;
    private String parkingEndTime;
    private Integer fetchNumber;
    private Integer status;
    private String carNumber;
    private String createTime;


    public ParkingOrder() {
    }

    public ParkingOrder(Integer id, Integer userId, Integer parkingLotId, String parkingStartTime, String parkingEndTime, Integer status, String carNumber) {
        this.id = id;
        this.userId = userId;
        this.parkingLotId = parkingLotId;
        this.parkingStartTime = parkingStartTime;
        this.parkingEndTime = parkingEndTime;
        this.status = status;
        this.carNumber = carNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public String getParkingStartTime() {
        return parkingStartTime;
    }

    public void setParkingStartTime(String parkingStartTime) {
        this.parkingStartTime = parkingStartTime;
    }

    public String getParkingEndTime() {
        return parkingEndTime;
    }

    public void setParkingEndTime(String parkingEndTime) {
        this.parkingEndTime = parkingEndTime;
    }

    public Integer getFetchNumber() {
        return fetchNumber;
    }

    public void setFetchNumber(Integer fetchNumber) {
        this.fetchNumber = fetchNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
