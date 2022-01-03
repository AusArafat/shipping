package com.shipping.ups.data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class upsShipment {
    @JsonProperty("shipmentServiceID")
    @Valid
    @NotNull
    private final String shipmentServiceID;

    @JsonProperty("package")
    @Valid
    @NotNull
    private final upsPackageDetails packageDetails;


    public upsShipment(String shipmentServiceID, upsPackageDetails packageDetails) {
        this.shipmentServiceID = shipmentServiceID;
        this.packageDetails = packageDetails;
    }


    @JsonProperty("shipmentServiceID")
    public String getShipmentServiceID() {
        return this.shipmentServiceID;
    }


    @JsonProperty("package")
    public upsPackageDetails getPackageDetails() {
        return this.packageDetails;
    }


    @Override
    public String toString() {
        return "{" +
            " shipmentServiceID='" + getShipmentServiceID() + "'" +
            ", packageDetails='" + getPackageDetails() + "'" +
            "}";
    }
    
}
