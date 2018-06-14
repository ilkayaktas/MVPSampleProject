package com.ilkayaktas.mvpsampleproject.di.components;


import android.app.Application;
import android.content.Context;
import com.ilkayaktas.mvpsampleproject.App;
import com.ilkayaktas.mvpsampleproject.controller.IDataManager;
import com.ilkayaktas.mvpsampleproject.di.annotations.ApplicationContext;
import com.ilkayaktas.mvpsampleproject.di.modules.ApplicationModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by ilkay on 26/02/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(App app);

    @ApplicationContext
    Context context();
    
    Application application();
    
    IDataManager getDataManager();
    
}
