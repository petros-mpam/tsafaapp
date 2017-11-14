package com.tsafaapp;

/**
 * Created by WHAAAZAAAP on 15/11/2017.
 */

public class PolitisData {

    String id,name,address,username,email,longtitude,latitude;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public PolitisData(String id,String name, String address, String username, String email,String longtitude,String latitude){
        this.id=id;
        this.name=name;
        this.address=address;
        this.username=username;
        this.email=email;
        this.longtitude=longtitude;
        this.latitude=latitude;

    }
}
