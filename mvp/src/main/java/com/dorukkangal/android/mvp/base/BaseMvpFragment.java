package com.dorukkangal.android.mvp.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dorukkangal.android.library.base.BaseFragment;

/**
 * A {@link BaseFragment} that uses an {@link BasePresenter}
 * to implement a Model-View-Presenter architecture.
 *
 * @param <P> indicates the presenter responsible to manage this fragment.
 * @author Doruk Kangal
 */
public abstract class BaseMvpFragment<P extends BasePresenter>
        extends BaseFragment implements BaseView {

    /**
     * The presenter class for this view.
     * Will be instantiated with {@link #createPresenter}
     */
    private P presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = createPresenter();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @CallSuper
    @Override
    public void onStart() {
        if (presenter != null) {
            presenter.attachView(this);
        }

        super.onStart();
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();

        if (presenter != null) {
            presenter.detachView();
        }
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        presenter = null;
    }

    /**
     * Creates a new presenter instance, if needed.
     * <p>
     * This method will be called from {@link #onViewCreated(View, Bundle)}
     * </p>
     *
     * @return Returns new {@link BasePresenter} instance.
     */
    protected abstract P createPresenter();

    /**
     * Get the presenter instance that are created for this fragment.
     *
     * @return the presenter instance.
     */
    @Nullable
    protected P getPresenter() {
        return presenter;
    }
}
