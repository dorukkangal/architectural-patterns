package com.dorukkangal.android.mvp.contact;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dorukkangal.android.library.dao.Contact;
import com.dorukkangal.android.mvp.R;
import com.dorukkangal.android.mvp.base.BaseMvpFragment;

import java.util.List;

/**
 * @author Doruk Kangal
 */
public class ContactListFragment extends BaseMvpFragment<ContactListPresenter>
        implements ContactListAdapter.ItemActionListener, ContactListView {

    private View layoutProgress;
    private RecyclerView recyclerView;

    public static ContactListFragment newInstance() {
        return new ContactListFragment();
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_contact_list;
    }

    @Override
    public ContactListPresenter createPresenter() {
        return new ContactListPresenter();
    }

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        layoutProgress = rootView.findViewById(R.id.fragment_contact_list_layout_progress);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_contact_list_recycler_view);

        recyclerView.setAdapter(new ContactListAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onCall(String phone) {
        getPresenter().onCall(phone);
    }

    @Override
    public void onSendEmail(String email) {
        getPresenter().onSendEmail(email);
    }

    @Override
    public void onDelete(String name) {
        getPresenter().onDelete(name);
    }

    @Override
    public void setDataLoaded(boolean dataLoaded) {
        layoutProgress.setVisibility(dataLoaded ? View.GONE : View.VISIBLE);
    }

    @Override
    public void setItems(List<Contact> contacts) {
        ((ContactListAdapter) recyclerView.getAdapter()).addItems(contacts);
    }

    @Override
    public void deleteListItem(String name) {
        ((ContactListAdapter) recyclerView.getAdapter()).deleteItem(name);
    }
}
