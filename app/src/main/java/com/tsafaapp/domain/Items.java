package com.tsafaapp.domain;

/**
 * Created by Teo on 12/11/2017. Updated from WHAAAZAAAP 16/12/2017.
 */
public class Items {

    private String name;
    private int flag_id;

    public Items(){}

    public Items(String name, int flag_id) {
        this.setName(name);
        this.setFlag_id(flag_id);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag_id() {
        return flag_id;
    }

    public void setFlag_id(int flag_id) {
        this.flag_id = flag_id;
    }
}
