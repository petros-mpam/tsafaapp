package com.tsafaapp;

/**
 * Created by WHAAAZAAAP on 15/11/2017.
 */

public class PolitisData {



    String name;
    String address;
    String longtitude;
    String latitude;



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
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


    public PolitisData(String name, String address,String longtitude,String latitude){

        this.name=name;
        this.address=address;
        this.longtitude=longtitude;
        this.latitude=latitude;


    }
}
