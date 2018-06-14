package com.ilkayaktas.mvpsampleproject.controller.db;


import com.ilkayaktas.mvpsampleproject.model.app.SorularAppModel;
import io.reactivex.Observable;

/**
 * Created by iaktas on 24/04/17.
 */

public interface IDbHelper {
    Observable<SorularAppModel> getSorularFromDatabase();
}
