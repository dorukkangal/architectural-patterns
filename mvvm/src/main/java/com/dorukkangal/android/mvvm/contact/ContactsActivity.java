package com.dorukkangal.android.mvvm.contact;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.dorukkangal.android.library.base.BaseActivity;
import com.dorukkangal.android.mvvm.objectgraph.DependencyProvider;

public class ContactsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DependencyProvider.getInstance().createActivityScope(this);
    }

    @Override
    protected Fragment getContainedFragment() {
        return ContactListFragment.newInstance();
    }
}
