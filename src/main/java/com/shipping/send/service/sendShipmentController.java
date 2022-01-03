package com.shipping.send.service;

import javax.validation.Valid;

import com.shipping.errors.carrierIdNotFoundException;
import com.shipping.fedex.data.fedexPackageDetails;
import com.shipping.fedex.data.fedexResponse;
import com.shipping.fedex.data.fedexShipment;
import com.shipping.send.data.sendResponse;
import com.shipping.send.data.sendShipment;
import com.shipping.ups.data.upsPackageDetails;
import com.shipping.ups.data.upsResponse;
import com.shipping.ups.data.upsShipment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class sendShipmentController {

    private static final Logger log = LoggerFactory.getLogger(sendShipmentController.class);
    @Value("${destinations.fedex}")
    private String fedexURL;
    @Value("${destinations.ups}")
    private String upsURL;

    @PostMapping("/ship")
    sendResponse sendShipment(@Valid @RequestBody sendShipment sentShipment) throws Exception{
        log.info(sentShipment.toString());
        sendResponse response = new sendResponse();
        RestTemplate restTemplate = new RestTemplate();
        String carrierID = sentShipment.getCarrierID().toLowerCase();
        switch(carrierID){
            case "fedexair":
            case "fedexground":
            fedexPackageDetails packageDetails = new fedexPackageDetails(sentShipment.getPackageDetails());
            fedexShipment fedexShipment = new fedexShipment(carrierID, packageDetails);
            log.info(fedexShipment.toString());
            fedexResponse fedexResponse = restTemplate.postForObject(fedexURL, fedexShipment, fedexResponse.class);
            response.setShipmentID(fedexResponse.getId());
            response.setErrorCode(0);
            response.setErrorDescription(fedexResponse.getSuccess());
            break;
            case "ups2day":
            case "upsexpress":
            upsPackageDetails upsPackageDetails = new upsPackageDetails(sentShipment.getPackageDetails(), "imperial");
            upsShipment upsShipment = new upsShipment(carrierID,  upsPackageDetails);
            log.info(upsShipment.toString());
            upsResponse upsResponse = restTemplate.postForObject(upsURL, upsShipment, upsResponse.class);
            response.setShipmentID(upsResponse.getId());
            response.setErrorCode(0);
            response.setErrorDescription(upsResponse.getSuccess());
            break;
            default:
            throw new carrierIdNotFoundException("must equal ['fedexAIR', 'fedexGroud', 'UPSExpress', 'UPS2DAY'] not case sensitive");
        }
        return response;
    }
}
