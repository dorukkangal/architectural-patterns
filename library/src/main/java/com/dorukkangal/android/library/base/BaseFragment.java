package com.dorukkangal.android.library.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Doruk Kangal
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(getResourceLayoutId(), container, false);

        initUserInterface(inflater, rootView);

        return rootView;
    }

    /**
     * Method to get fragment's UI content layout resource id.
     *
     * @return The fragment's root view's resource id
     */
    protected abstract int getResourceLayoutId();

    /**
     * Initialize UI content elements.
     *
     * @param inflater layout inflater of fragment
     * @param rootView The fragment's root view
     */
    protected abstract void initUserInterface(LayoutInflater inflater, final View rootView);
}
