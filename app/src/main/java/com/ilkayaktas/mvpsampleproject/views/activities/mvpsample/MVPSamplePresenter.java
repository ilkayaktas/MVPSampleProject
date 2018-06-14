package com.ilkayaktas.mvpsampleproject.views.activities.mvpsample;

import com.ilkayaktas.mvpsampleproject.views.activities.base.MvpPresenter;

/**
 * Created by ilkay on 02/08/2017.
 */

public interface MVPSamplePresenter<V extends MVPSampleView> extends MvpPresenter<V> {
    void getQuestion();
}
