package com.shipping.fedex.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import javax.validation.Valid;

import com.shipping.fedex.data.fedexResponse;
import com.shipping.fedex.data.fedexShipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class fedexShipmentController {
    private static final Logger log = LoggerFactory.getLogger(fedexShipmentController.class);
    
    @PostMapping("/fedexDummy")
    private fedexResponse getFedexResponse(@Valid @RequestBody fedexShipment fedexShipment){
        log.info(fedexShipment.toString());
        fedexResponse dummyResponse = new fedexResponse();
        dummyResponse.setId(UUID.randomUUID().toString());
        dummyResponse.setSuccess("FEDEX Success");
        return dummyResponse;
    }

    
}
