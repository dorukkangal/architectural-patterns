package com.dorukkangal.android.library.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.dorukkangal.android.library.R;

/**
 * @author Doruk Kangal
 */
public abstract class BaseActivity extends AppCompatActivity {

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentResourceId());

        if (savedInstanceState == null) {

            final Fragment fragment = getContainedFragment();
            if (fragment != null) {
                addFragment(fragment);
            }
        }
    }

    protected int getContentResourceId() {
        return R.layout.activity_base;
    }

    protected abstract Fragment getContainedFragment();

    public int getBaseFrameLayoutId() {
        return R.id.activity_base_frame_layout;
    }

    protected void addFragment(Fragment fragment) {
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(getBaseFrameLayoutId(), fragment).commit();
    }
}

