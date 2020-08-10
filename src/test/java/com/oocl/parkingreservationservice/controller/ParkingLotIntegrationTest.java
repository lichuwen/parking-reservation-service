package com.oocl.parkingreservationservice.controller;

import com.oocl.parkingreservationservice.model.ParkingLot;
import com.oocl.parkingreservationservice.repository.ParkingLotRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @BeforeEach
    public void before() {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("ali");
        parkingLot.setLatitude("1.0");
        parkingLot.setLongitude("1.0");
        parkingLotRepository.save(parkingLot);
        parkingLot = new ParkingLot();
        parkingLot.setName("ali");
        parkingLot.setLatitude("1.0");
        parkingLot.setLongitude("1.0");
        parkingLotRepository.save(parkingLot);
    }

    @AfterEach
    public void after() {
        parkingLotRepository.deleteAll();
        assert parkingLotRepository.findAll().isEmpty();
    }

    @Test
    public void should_return_parking_lot_when_get_parking_lot_given_lng_and_lat() throws Exception {
        //when then
        mockMvc.perform(get("/parkingLots").contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("lng", "1.0")
                .param("lat", "1.0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("ali"))
                .andExpect(jsonPath("$[1].name").value("ali"));
    }
}
