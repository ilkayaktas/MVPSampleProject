package com.ilkayaktas.mvpsampleproject.di.modules;

import android.app.Activity;
import android.graphics.Typeface;
import com.ilkayaktas.mvpsampleproject.controller.IDataManager;
import com.ilkayaktas.mvpsampleproject.di.annotations.ActivityContext;
import com.ilkayaktas.mvpsampleproject.di.annotations.PerActivity;
import com.ilkayaktas.mvpsampleproject.views.activities.mvpsample.MVPSamplePresenter;
import com.ilkayaktas.mvpsampleproject.views.activities.mvpsample.MVPSampleView;
import com.ilkayaktas.mvpsampleproject.views.activities.mvpsample.MVPSamplePresenterImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ilkay on 10/03/2017.
 */

@Module
public class ActivityModule {
    Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    Typeface provideTypeface() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/Roboto-Thin.ttf");
    }

    @Provides
    @PerActivity
    @ActivityContext
    Typeface provideTypefaceForActivity() {
        return Typeface.createFromAsset(activity.getAssets(), "fonts/gothic.TTF");
    }

    @Provides
    @PerActivity
    MVPSamplePresenter<MVPSampleView> providesPresenter(IDataManager IDataManager) {
        return new MVPSamplePresenterImpl<>(IDataManager);
    }


}
