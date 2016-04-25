package com.dorukkangal.android.mvvm.objectgraph;

import dagger.Component;

/**
 * Application component which will live during the application lifecycle.
 *
 * @author Doruk Kangal
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);
}
