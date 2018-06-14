/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.ilkayaktas.mvpsampleproject.di.components;


import com.ilkayaktas.mvpsampleproject.di.annotations.PerActivity;
import com.ilkayaktas.mvpsampleproject.di.modules.ActivityModule;
import com.ilkayaktas.mvpsampleproject.views.activities.mvpsample.MVPSampleActivity;
import com.ilkayaktas.mvpsampleproject.views.activities.base.BaseActivity;
import dagger.Component;

/**
 * Created by iaktas on 24/04/17.
 */

@PerActivity
@Component(dependencies = com.ilkayaktas.mvpsampleproject.di.components.ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseActivity baseActivity);

    void inject(MVPSampleActivity activity);


}