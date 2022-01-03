package com.shipping.ups.data;

public class upsResponse {
    private String id;
    private String success;

    public upsResponse() {
    }

    public String getSuccess() {
        return this.success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", success='" + getSuccess() + "'" +
            "}";
    }
}
