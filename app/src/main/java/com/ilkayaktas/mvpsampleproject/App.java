package com.ilkayaktas.mvpsampleproject;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.ilkayaktas.mvpsampleproject.controller.IDataManager;
import com.ilkayaktas.mvpsampleproject.di.components.ApplicationComponent;
import com.ilkayaktas.mvpsampleproject.di.components.DaggerApplicationComponent;
import com.ilkayaktas.mvpsampleproject.di.modules.ApplicationModule;
import io.realm.Realm;

import javax.inject.Inject;

public class App extends Application {
	
	ApplicationComponent appComponent;

	@Inject
	IDataManager mIDataManager;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		Realm.init(this);

		initializeInjector();

		// Setup handler for uncaught exceptions.
		Thread.setDefaultUncaughtExceptionHandler (this::handleUncaughtException);
	}
	
	private void initializeInjector(){
		appComponent = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(this))
				.build();
		
		appComponent.inject(this);
		
	}
	
	public ApplicationComponent getAppComponent(){
		return appComponent;
	}

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}

	public void handleUncaughtException (Thread thread, Throwable e)
	{
		Thread.UncaughtExceptionHandler uch = Thread.getDefaultUncaughtExceptionHandler();
		e.printStackTrace(); // not all Android versions will print the stack trace automatically

		System.out.println("UncaughtException is handled!");

		System.exit(-1);
	}
}