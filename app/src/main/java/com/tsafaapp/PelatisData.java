package com.tsafaapp;

/**
 * Created by WHAAAZAAAP on 14/11/2017.
 */

public class PelatisData {
    String id,name,surname,username,email,idpro;

    public String getIdpro() {
        return idpro;
    }

    public void setIdpro(String idpro) {
        this.idpro = idpro;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public PelatisData(String id,String name, String surname, String username, String email,String idpro){
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.username=username;
        this.email=email;
        this.idpro=idpro;

    }

}
