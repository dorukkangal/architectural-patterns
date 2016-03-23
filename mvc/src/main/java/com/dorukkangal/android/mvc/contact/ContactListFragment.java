package com.dorukkangal.android.mvc.contact;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.dorukkangal.android.library.dao.Contact;
import com.dorukkangal.android.mvc.R;
import com.dorukkangal.android.mvc.base.BaseMvcFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by polata on 22/03/2016.
 */
public class ContactListFragment extends BaseMvcFragment<ContactListController>
        implements ContactListAdapter.ItemActionListener {

    private static final String KEY_CONTACTS = "keyContacts";

    private RecyclerView recyclerView;

    private List<Contact> contacts;

    public static ContactListFragment newInstance(List<Contact> contacts) {
        final ContactListFragment fragment = new ContactListFragment();

        final Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(KEY_CONTACTS, (ArrayList<Contact>) contacts);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contacts = getArguments().getParcelableArrayList(KEY_CONTACTS);
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.fragment_contact_list;
    }

    @Override
    protected void initUserInterface(LayoutInflater inflater, View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_contact_list_recycler_view);

        recyclerView.setAdapter(new ContactListAdapter(contacts, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onCall(String phone) {
        controller.onCall(phone);
    }

    @Override
    public void onSendEmail(String email) {
        controller.onSendEmail(email);
    }

    @Override
    public void onDelete(String name) {
        controller.onDelete(name);
    }

    public void deleteListItem(String name) {
        ((ContactListAdapter) recyclerView.getAdapter()).deleteItem(name);
    }

    public void setItems(List<Contact> contacts) {
        this.contacts = contacts;

    }
}
