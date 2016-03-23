package com.dorukkangal.android.mvvm.base;

import android.databinding.BaseObservable;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * A base implementation of a {@link BaseViewModel} that uses a <b>WeakReference</b> for referring
 * to the attached view.
 *
 * @param <V> view type.
 * @author Doruk Kangal
 */
public abstract class BaseViewModel<V extends BaseView> extends BaseObservable {

    private WeakReference<V> viewRef;

    @CallSuper
    public void attachView(V view) {
        this.viewRef = new WeakReference<>(view);
    }

    @CallSuper
    public void detachView() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Nullable
    protected V getView() {
        return viewRef == null ? null : viewRef.get();
    }
}
