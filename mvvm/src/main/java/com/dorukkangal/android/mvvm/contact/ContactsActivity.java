package com.dorukkangal.android.mvvm.contact;

import android.support.v4.app.Fragment;

import com.dorukkangal.android.library.base.BaseActivity;

public class ContactsActivity extends BaseActivity {

    @Override
    protected Fragment getContainedFragment() {
        return ContactListFragment.newInstance();
    }
}
