package com.shipping.fedex.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shipping.send.data.receivedPckageDetails;
import com.shipping.util.unitConverter;

public class fedexPackageDetails {
    @JsonProperty("width")
    private final Float width;
    @JsonProperty("height")
    private final Float height;
    @JsonProperty("length")
    private final Float length;
    @JsonProperty("weight")
    private final Float weight;

        
    public fedexPackageDetails(@JsonProperty("width") Float width, @JsonProperty("height") Float height, @JsonProperty("length") Float length, @JsonProperty("weight") Float weight) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public fedexPackageDetails(receivedPckageDetails rPckageDetails){
        this.width = rPckageDetails.getWidth();
        this.height = rPckageDetails.getHeight();
        this.length = rPckageDetails.getLength();
        this.weight = rPckageDetails.getWeight();
    }


    public fedexPackageDetails(receivedPckageDetails rPckageDetails, String units) throws Exception{
        units = units.toLowerCase();
        switch(units){
        case "metric":
        this.width = unitConverter.inch2cm(rPckageDetails.getWidth());
        this.height = unitConverter.inch2cm(rPckageDetails.getHeight());
        this.length = unitConverter.inch2cm(rPckageDetails.getLength());
        this.weight = unitConverter.pound2gram(rPckageDetails.getWeight());
        break;

        case "imperial":
        this.width = unitConverter.cm2inche(rPckageDetails.getWidth());
        this.height = unitConverter.cm2inche(rPckageDetails.getHeight());
        this.length = unitConverter.cm2inche(rPckageDetails.getLength());
        this.weight = unitConverter.gram2pound(rPckageDetails.getWeight());
        break;

        default:
        throw new Exception("Undefined units supplied");
        }

    }

    public Float getHeight() {
        return height;
    }
    public Float getLength() {
        return length;
    }
    public Float getWeight() {
        return weight;
    }
    public Float getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "{" +
            " width='" + getWidth() + "'" +
            ", height='" + getHeight() + "'" +
            ", length='" + getLength() + "'" +
            ", weight='" + getWeight() + "'" +
            "}";
    }

    public static fedexPackageDetails createMetriPackageDetails(receivedPckageDetails rPckageDetails){
        Float _width = unitConverter.inch2cm(rPckageDetails.getWidth());
        Float _height = unitConverter.inch2cm(rPckageDetails.getHeight());
        Float _length = unitConverter.inch2cm(rPckageDetails.getLength());
        Float _weight = unitConverter.pound2gram(rPckageDetails.getWeight());
        return new fedexPackageDetails(_width, _height, _length, _weight);
    }

    public static fedexPackageDetails createImperialPackageDetails(receivedPckageDetails rPckageDetails){
        Float _width = unitConverter.cm2inche(rPckageDetails.getWidth());
        Float _height = unitConverter.cm2inche(rPckageDetails.getHeight());
        Float _length = unitConverter.cm2inche(rPckageDetails.getLength());
        Float _weight = unitConverter.gram2pound(rPckageDetails.getWeight());
        return new fedexPackageDetails(_width, _height, _length, _weight);
    }
}
