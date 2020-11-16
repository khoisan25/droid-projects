package com.example.nexus75.databasetesting;

/**
 * Created by NEXUS75 on 3/8/2016.
 */
public class Product {
    int _id;
    String _name;
    String _barcode;
    String _price;

    public Product() {
    }

    public Product(int id, String name, String code, String price) {
        this._id = id;
        this._name = name;
        this._barcode = code;
        this._price=price;
    }

    public Product(String name,String pric_e, String barcode) {
        this._name = name;
        this._barcode = barcode;
        this._price=pric_e;
    }

    public int getID() {
        return this._id;
    }

    public void setID(int id) {
        this._id = id;
    }
    public String getPrice(){
        return this._price;
    }
    public  void setPrice(String price){
        this._price=price;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getBarcode() {
        return this._barcode;
    }

    public void setBarcode(String barcode) {
        this._barcode = barcode;
    }
}
