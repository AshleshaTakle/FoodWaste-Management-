package com.example.food_waste_managment;

public class Ourproduct {

    String farmername,productname,description,price,imageurl;

    public Ourproduct() {
    }

    public Ourproduct(String farmername, String productname, String description, String price, String imageurl) {
        this.farmername = farmername;
        this.productname = productname;
        this.description = description;
        this.price = price;
        this.imageurl = imageurl;
    }

    public String getFarmername() {
        return farmername;
    }

    public void setFarmername(String farmername) {
        this.farmername = farmername;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
