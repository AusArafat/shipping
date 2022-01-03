package com.shipping.fedex.data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class fedexShipment {
    @JsonProperty("carrierServiceID")
    @Valid
    @NotNull
    private final String carrierServiceID;

    @JsonProperty("packageDetails")
    @Valid
    @NotNull
    private final fedexPackageDetails packageDetails;

    public fedexShipment(String carrierServiceID, fedexPackageDetails packageDetails) {
        this.carrierServiceID = carrierServiceID;
        this.packageDetails = packageDetails;
    }

    public String getCarrierServiceID() {
        return carrierServiceID;
    }

    @JsonProperty("packageDetails")
    public fedexPackageDetails getFedexPackageDetails() {
        return packageDetails;
    }
    


    @Override
    public String toString() {
        return "{" +
            " carrierServiceID='" + getCarrierServiceID() + "'" +
            ", packageDetails='" + getFedexPackageDetails() + "'" +
            "}";
    }
   
    

}
