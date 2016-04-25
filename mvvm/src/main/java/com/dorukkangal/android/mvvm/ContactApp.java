package com.dorukkangal.android.mvvm;

import android.app.Application;

import com.dorukkangal.android.mvvm.objectgraph.DependencyProvider;

/**
 * @author Doruk Kangal
 */
public class ContactApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        DependencyProvider.getInstance().createApplicationScope(this);
    }
}
