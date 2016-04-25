package com.dorukkangal.android.mvvm.objectgraph;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Application module which will live during the application lifecycle.
 *
 * @author Doruk Kangal
 */
@Module
class ApplicationModule {

    private final Application application;

    /**
     * Constructor.
     *
     * @param application Application Context
     */
    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    public Application provideApplication() {
        return this.application;
    }
}
