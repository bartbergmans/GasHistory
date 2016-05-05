package com.bartbergmans.gashistory.Models;

import android.content.Context;

import com.bartbergmans.gashistory.Objects.GasEntry;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.lang.reflect.Constructor;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Bart on 5-5-2016.
 */
@EBean
public class GasModel extends BaseModel<GasEntry> {

    public GasModel(Context context) {
        super(GasEntry.class);
    }

    /**
     * Save Gas Entry in the local database.
     *
     * @param mileage   Mileage for the new entry
     * @param gas       Amount of gas for the new entry
     * @param price     Price for the new entry
     * @return          The added GasEntry
     */
    public GasEntry saveGasEntry(float mileage, float gas, float price) {
        GasEntry gasEntry = new GasEntry(mileage, gas, price);
        return saveObject(gasEntry);
    }

    public List<GasEntry> getGasEntryList() {
        return getObjectList();
    }
}
