package com.dorukkangal.android.mvvm.base;

import android.databinding.BaseObservable;

/**
 * A base implementation of a {@link BaseViewModel} that uses a <b>WeakReference</b> for referring
 * to the attached view.
 *
 * @author Doruk Kangal
 */
public abstract class BaseViewModel extends BaseObservable {

    public void attachView() {
    }

    public void detachView() {
    }
}
