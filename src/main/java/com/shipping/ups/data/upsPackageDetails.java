package com.shipping.ups.data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shipping.send.data.receivedPckageDetails;
import com.shipping.util.unitConverter;


public class upsPackageDetails {
    private final float width;
    private final float height;
    private final float length;
    private final float weight;

    public upsPackageDetails(receivedPckageDetails rPckageDetails){
        this.width = rPckageDetails.getWidth();
        this.height = rPckageDetails.getHeight();
        this.length = rPckageDetails.getLength();
        this.weight = rPckageDetails.getWeight();
    }
    
    public upsPackageDetails(receivedPckageDetails rPckageDetails, String units) throws Exception{
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

    public upsPackageDetails(@JsonProperty("width") float width, @JsonProperty("height") float height, @JsonProperty("length") float length, @JsonProperty("weight") float weight) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }
    public float getLength() {
        return length;
    }
    public float getWeight() {
        return weight;
    }
    public float getWidth() {
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


    public static upsPackageDetails createMetriPackageDetails(receivedPckageDetails rPckageDetails){
        float _width = unitConverter.inch2cm(rPckageDetails.getWidth());
        float _height = unitConverter.inch2cm(rPckageDetails.getHeight());
        float _length = unitConverter.inch2cm(rPckageDetails.getLength());
        float _weight = unitConverter.pound2gram(rPckageDetails.getWeight());
        return new upsPackageDetails(_width, _height, _length, _weight);
    }

    public static upsPackageDetails createImperialPackageDetails(receivedPckageDetails rPckageDetails){
        float _width = unitConverter.cm2inche(rPckageDetails.getWidth());
        float _height = unitConverter.cm2inche(rPckageDetails.getHeight());
        float _length = unitConverter.cm2inche(rPckageDetails.getLength());
        float _weight = unitConverter.gram2pound(rPckageDetails.getWeight());
        return new upsPackageDetails(_width, _height, _length, _weight);
    }
}