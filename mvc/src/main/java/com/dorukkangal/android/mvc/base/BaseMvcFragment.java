package com.dorukkangal.android.mvc.base;

import android.content.Context;

import com.dorukkangal.android.library.base.BaseFragment;

/**
 * Created by polata on 22/03/2016.
 */
public abstract class BaseMvcFragment<Controller extends BaseMvcController> extends BaseFragment {

    protected Controller controller;

    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            controller = (Controller) context;
        } catch (ClassCastException e) {
            throw new RuntimeException(getActivity().getLocalClassName() + " must implement a controller.", e);
        }

        controller.attach(this);
    }

    @Override
    public void onDetach() {
        controller.detach(this);
        controller = null;
        super.onDetach();
    }
}
