package com.dorukkangal.android.mvvm.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dorukkangal.android.library.base.BaseFragment;

/**
 * A {@link BaseFragment} that uses an {@link BaseViewModel}
 * to implement a Model-View-ViewModel architecture.
 *
 * @param <VM> indicates the viewModel responsible to manage this fragment.
 * @author Doruk Kangal
 */
public abstract class BaseMvvmFragment<VM extends BaseViewModel>
        extends BaseFragment implements BaseView {

    /**
     * The view model class for this view.
     * Will be instantiated with {@link #createViewModel}
     */
    private VM viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewModel = createViewModel();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @CallSuper
    @Override
    public void onStart() {
        if (viewModel != null) {
            viewModel.attachView(this);
        }

        super.onStart();
    }

    @CallSuper
    @Override
    public void onStop() {
        super.onStop();

        if (viewModel != null) {
            viewModel.detachView();
        }
    }

    @CallSuper
    @Override
    public void onDestroyView() {
        super.onDestroyView();

        viewModel = null;
    }

    /**
     * Creates a new view model instance, if needed.
     * <p>
     * This method will be called from {@link #onViewCreated(View, Bundle)}
     * </p>
     *
     * @return Returns new {@link BaseViewModel} instance.
     */
    protected abstract VM createViewModel();

    /**
     * Get the view model instance that are created for this fragment.
     *
     * @return the view model instance.
     */
    @Nullable
    protected VM getViewModel() {
        return viewModel;
    }
}
