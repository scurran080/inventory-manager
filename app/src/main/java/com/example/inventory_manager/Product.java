package com.example.inventory_manager;

public class Product {

    private static String name;
    private static String upc;
    private static String description;
    private static int packageSize;
    //price is temporarily a string for now
    //private String price;

    public Product(String name, String upc, String description, int packageSize) {
        this.name = name;
        this.upc = upc;
        this.description = description;
        this.packageSize = packageSize;
        //this.price = price;
    }

    public Product() {
        this.name = "na";
        this.upc = "na";
        this.description = "na";
        this.packageSize = 999999;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPackagesize() {
        return packageSize;
    }

    public void setPackageSize(int packageSize) {
        this.packageSize = packageSize;
    }

    //public String getPrice() {
    //  return price;
    //}

    //public void setPrice(String price) {
    //  this.price = price;
    //}
}



