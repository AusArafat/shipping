package com.shipping.send.data;

public class sendResponse {
    private String shipmentID;
    private int ErrorCode;
    private String ErrorDescription;

    public sendResponse() {
    }

    public int getErrorCode() {
        return this.ErrorCode;
    }

    public void setErrorCode(int ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getErrorDescription() {
        return this.ErrorDescription;
    }

    public void setErrorDescription(String ErrorDescription) {
        this.ErrorDescription = ErrorDescription;
    }

    public String getShipmentID() {
        return this.shipmentID;
    }

    public void setShipmentID(String shipmentID) {
        this.shipmentID = shipmentID;
    }

    @Override
    public String toString() {
        return "{" +
            " shipmentID='" + getShipmentID() + "'" +
            ", ErrorCode='" + getErrorCode() + "'" +
            ", ErrorDescription='" + getErrorDescription() + "'" +
            "}";
    }

}
