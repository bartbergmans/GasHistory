package com.bartbergmans.gashistory.Models;

import android.content.Context;

import com.bartbergmans.gashistory.Objects.GasEntry;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;

/**
 * Created by Bart on 5-5-2016.
 */
@EBean
public abstract class BaseModel<T extends RealmObject> {

    @RootContext
    Context context;

    private final Class<T> type;

    public BaseModel(Class<T> type) {
        this.type = type;
    }

    /**
     * Get realm instance
     * @return  Realm instance
     * @see     Realm
     */
    private Realm getRealmInstance() {
        RealmConfiguration realmConfig = new RealmConfiguration
                .Builder(context)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm realm = Realm.getInstance(realmConfig);
        return realm;
    }

    /**
     * Save object to the local database
     *
     * @param object    Object to save to the local database
     * @return          The saved object
     */
    protected T saveObject(T object) {
        Realm realm = getRealmInstance();

        realm.beginTransaction();
        T newObject = realm.copyToRealm(object);
        realm.commitTransaction();

        return newObject;
    }

    protected List<T> getObjectList() {
        Realm realm = getRealmInstance();

        return realm.where(this.type).findAll();
    }
}
