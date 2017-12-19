package com.tsafaapp.domain;

/**
 * Created by WHAAAZAAAP on 15/11/2017.
 */
public class PolitisData {

    private String id;
    private String name;
    private String address;
    private String longtitude;
    private String latitude;

    public PolitisData(){}

    public PolitisData(String name, String address,String longtitude,String latitude,String id){
        this.id = id;
        this.name = name;
        this.address = address;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
