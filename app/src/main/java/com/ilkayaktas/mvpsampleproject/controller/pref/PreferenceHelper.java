package com.ilkayaktas.mvpsampleproject.controller.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ilkayaktas.mvpsampleproject.di.annotations.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by iaktas on 10.03.2017.
 */

@Singleton
public class PreferenceHelper implements IPreferenceHelper {
    public static final String SHARED_PREF_DBDREATED = "DatabaseCreated";
    
    private final SharedPreferences mPrefs;
    
    @Inject
    public PreferenceHelper(@ApplicationContext Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }
    
    @Override
    public boolean getDatabaseCreatedStatus() {
        return mPrefs.getBoolean(SHARED_PREF_DBDREATED, false);
    }

    @Override
    public void setDatabaseCreatedStatus() {
        mPrefs.edit().putBoolean(SHARED_PREF_DBDREATED, true).apply();
    }
}
