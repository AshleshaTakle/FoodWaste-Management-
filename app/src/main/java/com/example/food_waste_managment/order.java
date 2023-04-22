package com.example.food_waste_managment;

public class order {

    String username,number,adderess,farmername;

    public order() {
    }

    public order(String username, String number, String adderess, String farmername) {
        this.username = username;
        this.number = number;
        this.adderess = adderess;
        this.farmername = farmername;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAdderess() {
        return adderess;
    }

    public void setAdderess(String adderess) {
        this.adderess = adderess;
    }

    public String getFarmername() {
        return farmername;
    }

    public void setFarmername(String farmername) {
        this.farmername = farmername;
    }
}
