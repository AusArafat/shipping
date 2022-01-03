package com.shipping.send.data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class sendShipment {
    @NotNull
    private final String carrierID;
    @NotNull
    @Valid
    @JsonProperty("Details")
    private final receivedPckageDetails packageDetails;


    public sendShipment(String carrierID, receivedPckageDetails packageDetails) {
        this.carrierID = carrierID;
        this.packageDetails = packageDetails;
    }

    public String getCarrierID() {
        return carrierID;
    }
    public receivedPckageDetails getPackageDetails() {
        return packageDetails;
    }


    @Override
    public String toString() {
        return "{" +
            " carrierID='" + getCarrierID() + "'" +
            ", Details='" + getPackageDetails() + "'" +
            "}";
    }


}
