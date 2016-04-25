package com.dorukkangal.android.mvvm.objectgraph;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.dorukkangal.android.mvvm.service.ActionService;

import dagger.Module;
import dagger.Provides;

/**
 * Activity module which will live during the activity lifecycle.
 *
 * @author Doruk Kangal
 */
@Module
class ActivityModule {

    private final Activity activity;

    /**
     * Constructor.
     *
     * @param activity Activity Context
     */
    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return this.activity;
    }

    @Provides
    @ActivityScope
    public ActionService provideActionService(@NonNull Activity activity) {
        return new ActionService(activity);
    }
}
