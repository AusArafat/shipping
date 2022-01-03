package com.shipping.ups.service;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import javax.validation.Valid;

import com.shipping.ups.data.upsResponse;
import com.shipping.ups.data.upsShipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class upsShipmentController {
    private static final Logger log = LoggerFactory.getLogger(upsShipmentController.class);
    
    @PostMapping("/upsDummy")
    private upsResponse getUpsResponse(@Valid @RequestBody upsShipment upsShipment){
        log.info(upsShipment.toString());
        upsResponse dummyResponse = new upsResponse();
        dummyResponse.setId(UUID.randomUUID().toString());
        dummyResponse.setSuccess("UPS Success");
        return dummyResponse;
    }
}
