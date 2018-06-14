package com.ilkayaktas.mvpsampleproject.controller.api;

import com.ilkayaktas.mvpsampleproject.model.api.SorularApiModel;
import com.ilkayaktas.mvpsampleproject.model.app.SorularAppModel;
import io.reactivex.Observable;

import javax.inject.Singleton;

/**
 * Created by ilkay on 01/07/2017.
 */

@Singleton
public class ApiHelper implements IApiHelper {
    @Override
    public Observable<SorularAppModel> getSorularFromRemoteServer() {
        // Here, remote server query operations will be located.
        // Remote server query is simulated here.
        // Object creation assumes that it's retrieved from remote api.

        SorularApiModel retrievedDataFromApi = new SorularApiModel();

        return Observable.create(e -> {
            // create a RxJava Observable. For more information about RxJava, refer to http://reactivex.io/
            SorularAppModel dataUsedInAllApplication = new SorularAppModel();

            dataUsedInAllApplication.id = retrievedDataFromApi.id;
            dataUsedInAllApplication.soru = retrievedDataFromApi.soru;

            e.onNext(dataUsedInAllApplication);
            e.onComplete();
        });
    }
}
