package com.oocl.parkingreservationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingOrderRequest {
    private String parkingStartTime;
    private String parkingEndTime;
    private Integer parkingLotId;
    private String carNumber;
    private String email;
    private String phone;


}
