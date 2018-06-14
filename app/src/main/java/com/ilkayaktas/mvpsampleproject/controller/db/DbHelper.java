package com.ilkayaktas.mvpsampleproject.controller.db;


import com.ilkayaktas.mvpsampleproject.controller.db.crud.DatabaseManager;
import com.ilkayaktas.mvpsampleproject.model.app.SorularAppModel;
import com.ilkayaktas.mvpsampleproject.model.db.SorularDBModel;
import io.reactivex.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by ilkay on 12/03/2017.
 */

@Singleton
public class DbHelper implements IDbHelper {
	
	private final DatabaseManager databaseManager;
	
	@Inject
	public DbHelper(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	@Override
	public Observable<SorularAppModel> getSorularFromDatabase() {
		// Here, database query operations will be located.
		// Database query is simulated here.
		// Object creation assumes that it's retrieved from database.

		SorularDBModel retrievedDataFromDB = new SorularDBModel();

		return Observable.create(e -> {
			// create a RxJava Observable. For more information about RxJava, refer to http://reactivex.io/
			SorularAppModel dataUsedInAllApplication = new SorularAppModel();

			dataUsedInAllApplication.id = retrievedDataFromDB.id;
			dataUsedInAllApplication.soru = retrievedDataFromDB.soru;

			e.onNext(dataUsedInAllApplication);
			e.onComplete();
		});
	}
}
