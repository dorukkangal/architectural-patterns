package com.dorukkangal.android.mvvm.contact;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.dorukkangal.android.mvvm.BR;
import com.dorukkangal.android.mvvm.R;
import com.dorukkangal.android.mvvm.base.BaseMvvmFragment;
import com.dorukkangal.android.mvvm.binding.RecyclerViewListBindingAdapter;
import com.dorukkangal.android.mvvm.databinding.FragmentContactListBinding;
import com.dorukkangal.android.mvvm.objectgraph.DependencyProvider;

/**
 * @author Doruk Kangal
 */
public class ContactListFragment extends BaseMvvmFragment<ContactListViewModel> {

    public static ContactListFragment newInstance() {
        return new ContactListFragment();
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_contact_list;
    }

    @Override
    public ContactListViewModel createViewModel() {

        ContactListViewModel viewModel = new ContactListViewModel();
        DependencyProvider.getInstance().getActivityComponent().inject(viewModel);

        return viewModel;
    }

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {

        final FragmentContactListBinding binding = FragmentContactListBinding.bind(rootView);
        binding.setViewModel(getViewModel());

        binding.fragmentContactListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.fragmentContactListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.fragmentContactListRecyclerView.setAdapter(
                new RecyclerViewListBindingAdapter(R.layout.list_item_contact, BR.viewModel));
    }
}
