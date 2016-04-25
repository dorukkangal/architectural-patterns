package com.dorukkangal.android.mvvm.objectgraph;

import com.dorukkangal.android.mvvm.contact.ContactListViewModel;

import dagger.Subcomponent;

/**
 * Activity component which will live during the activity lifecycle.
 *
 * @author Doruk Kangal
 */
@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    /**
     * Injects dependencies.
     *
     * @param viewModel to inject dependencies into
     */
    void inject(ContactListViewModel viewModel);
}
