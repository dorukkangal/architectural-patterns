package com.dorukkangal.android.mvvm.objectgraph;

import android.app.Activity;
import android.app.Application;

/**
 * @author Doruk Kangal
 */
public final class DependencyProvider {

    private static DependencyProvider instance;

    private ApplicationComponent applicationComponent;

    private ActivityComponent activityComponent;

    public static DependencyProvider getInstance() {
        if (instance == null) {
            instance = new DependencyProvider();
        }
        return instance;
    }

    /**
     * Don't initiate.
     */
    private DependencyProvider() {
    }

    public void createApplicationScope(Application application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .build();
    }

    public void createActivityScope(Activity activity) {
        activityComponent = applicationComponent
                .activityComponent(new ActivityModule(activity));
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
