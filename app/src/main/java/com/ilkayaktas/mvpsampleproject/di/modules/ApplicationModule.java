package com.ilkayaktas.mvpsampleproject.di.modules;

import android.app.Application;
import android.content.Context;

import com.ilkayaktas.mvpsampleproject.controller.DataManager;
import com.ilkayaktas.mvpsampleproject.controller.IDataManager;
import com.ilkayaktas.mvpsampleproject.controller.api.ApiHelper;
import com.ilkayaktas.mvpsampleproject.controller.api.IApiHelper;
import com.ilkayaktas.mvpsampleproject.controller.db.DbHelper;
import com.ilkayaktas.mvpsampleproject.controller.db.IDbHelper;
import com.ilkayaktas.mvpsampleproject.controller.db.crud.DatabaseManager;
import com.ilkayaktas.mvpsampleproject.controller.db.crud.DatabaseMigration;
import com.ilkayaktas.mvpsampleproject.controller.db.crud.RealmManager;
import com.ilkayaktas.mvpsampleproject.controller.pref.IPreferenceHelper;
import com.ilkayaktas.mvpsampleproject.controller.pref.PreferenceHelper;
import com.ilkayaktas.mvpsampleproject.di.annotations.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ilkay on 09/03/2017.
 */

@Module
public class ApplicationModule {
	
	private final Application app;
	private RealmConfiguration realmConfiguration = null;
	private DatabaseManager databaseManager;
	
	public ApplicationModule(Application app) {
		this.app = app;
	}
	
	@Provides
	@ApplicationContext
	Context provideContext() {
		return app;
	}
	
	@Provides
	Application provideApplication(){
		return app;
	}
	
	@Provides
	@Singleton
	IDataManager provideDataManager(@ApplicationContext Context context, IDbHelper mIDbHelper, IPreferenceHelper mIPreferenceHelper, IApiHelper mIApiHelper) {
		return new DataManager( context, mIDbHelper, mIPreferenceHelper, mIApiHelper);
	}
	
	@Provides
	@Singleton
	IDbHelper provideDbHelper(DatabaseManager databaseManager) {
		return new DbHelper(databaseManager);
	}
	
	@Provides
	@Singleton
	DatabaseManager provideDatabaseManager(Realm realm){
		databaseManager =  new RealmManager(realm);
		return databaseManager;
	}
	
	@Provides
	@Singleton
	Realm provideRealm(){
		
		if(realmConfiguration == null) {
			// Create a RealmConfiguration that saves the Realm file in the app's "files" directory.
			realmConfiguration = new RealmConfiguration.Builder()
					.name("islamic.db")
					.migration(new DatabaseMigration())
					.encryptionKey(new String("YhvPohxPIDXI8wneZTgYwFElAuSeWOhea8WILKRvuHeiOQYaz1RLZ4m0ZEaAP7Gc").getBytes())
					.schemaVersion(1)
					.build();
		}
		
		// Get a Realm instance for this thread
		Realm realm = Realm.getInstance(realmConfiguration);
		
		return realm;
	}
	
	@Provides
	@Singleton
	IPreferenceHelper providePreferencesHelper(@ApplicationContext Context context) {
		return new PreferenceHelper(context);
	}
	
	@Provides
	@Singleton
	IApiHelper provideApiHelper() {
		return new ApiHelper();
	}
	
}
