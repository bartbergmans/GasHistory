package com.bartbergmans.gashistory.Objects;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Bart on 4-5-2016.
 */
public class GasEntry extends RealmObject {
    private float mileage;
    private float price;
    private float gas;

    @Required
    private Date date = new Date();

    public GasEntry() {
    }

    public GasEntry(float mileage, float gas, float price) {
        this.mileage = mileage;
        this.gas = gas;
        this.price = price;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getGas() {
        return gas;
    }

    public void setGas(float gas) {
        this.gas = gas;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
