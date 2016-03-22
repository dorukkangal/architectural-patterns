package com.dorukkangal.android.mvc.base;

import com.dorukkangal.android.library.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by polata on 22/03/2016.
 */
public abstract class BaseMvcActivity extends BaseActivity implements BaseMvcController {

    private Map<Class, BaseMvcFragment> attachedFragments = new HashMap<>();

    @Override
    public void attach(BaseMvcFragment fragment) {
        attachedFragments.put(fragment.getClass(), fragment);
    }

    @Override
    public void detach(BaseMvcFragment fragment) {
        attachedFragments.remove(fragment.getClass());
    }

    @Override
    protected void onDestroy() {
        attachedFragments.clear();
        super.onDestroy();
    }

    @SuppressWarnings("unchecked")
    protected <T extends BaseMvcFragment> T getRegisteredFragment(Class<T> fragment) {
        return (T) attachedFragments.get(fragment);
    }
}
