package com.shipping.send.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class receivedPckageDetails {
    @NotNull
    @Positive(message = "Must be greater than 0")
    private final Float width;
    @NotNull
    @Positive(message = "Must be greater than 0")
    private final Float height;
    @NotNull
    @Positive(message = "Must be greater than 0")
    private final Float length;
    @NotNull
    @Positive(message = "Must be greater than 0")
    private final Float weight;

    public receivedPckageDetails(Float width, Float height, Float length, Float weight) {
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
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

}
