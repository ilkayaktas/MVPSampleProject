package com.ilkayaktas.mvpsampleproject.controller.db.crud;


import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by ilkay on 04/09/2016.
 */
public class DatabaseMigration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema schema = realm.getSchema();

    }


}
