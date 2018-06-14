package com.ilkayaktas.mvpsampleproject.controller;

import android.content.Context;
import com.ilkayaktas.mvpsampleproject.controller.api.IApiHelper;
import com.ilkayaktas.mvpsampleproject.controller.db.IDbHelper;
import com.ilkayaktas.mvpsampleproject.controller.pref.IPreferenceHelper;
import com.ilkayaktas.mvpsampleproject.di.annotations.ApplicationContext;
import com.ilkayaktas.mvpsampleproject.model.app.SorularAppModel;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by ilkay on 11/03/2017.
 */

@Singleton
public class DataManager implements IDataManager {
	
	private final Context context;
	private final IDbHelper dbHelper;
	private final IPreferenceHelper preferenceHelper;
	private final IApiHelper apiHelper;
	
	@Inject
	public DataManager(@ApplicationContext Context context, IDbHelper dbHelper, IPreferenceHelper preferenceHelper, IApiHelper apiHelper) {
		this.context = context;
		this.dbHelper = dbHelper;
		this.preferenceHelper = preferenceHelper;
		this.apiHelper = apiHelper;
	}

	@Override
	public boolean getDatabaseCreatedStatus() {
		return preferenceHelper.getDatabaseCreatedStatus();
	}

	@Override
	public void setDatabaseCreatedStatus() {
		preferenceHelper.setDatabaseCreatedStatus();
	}

	@Override
	public Observable<SorularAppModel> getSorularFromRemoteServer() {
		return apiHelper.getSorularFromRemoteServer();
	}

	@Override
	public Observable<SorularAppModel> getSorularFromDatabase() {
		return dbHelper.getSorularFromDatabase();
	}

	@Override
	public Observable<SorularAppModel> getQuestions() {
//		return getSorularFromDatabase(); // Change the question source with one line
		return getSorularFromRemoteServer();
	}
}
