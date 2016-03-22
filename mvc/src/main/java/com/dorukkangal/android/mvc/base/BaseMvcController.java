package com.dorukkangal.android.mvc.base;

/**
 * Created by polata on 22/03/2016.
 */
public interface BaseMvcController {
    /**
     * Attach fragment to the activity.
     *
     * @param fragment fragment
     */
    void attach(BaseMvcFragment fragment);

    /**
     * Detach fragment from the activity.
     *
     * @param fragment fragment
     */
    void detach(BaseMvcFragment fragment);
}