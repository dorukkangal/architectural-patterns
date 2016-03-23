package com.dorukkangal.android.mvp.contact;

import com.dorukkangal.android.mvp.base.BasePresenter;
import com.dorukkangal.android.library.dao.Contact;
import com.dorukkangal.android.library.dao.ContactDaoManager;
import com.dorukkangal.android.library.service.ActionService;

import java.util.List;

/**
 * @author Doruk Kangal
 */
public class ContactListPresenter extends BasePresenter<ContactListView> {

    @Override
    public void attachView(ContactListView view) {
        super.attachView(view);

        final List<Contact> results = ContactDaoManager.getAllContacts();
        onQueryComplete(results);
    }

    private void onQueryComplete(List<Contact> results) {
        getView().setDataLoaded(true);
        getView().setItems(results);
    }

    public void onCall(String phone) {
        ActionService.makeCall(getView().getActivity(), phone);
    }

    public void onSendEmail(String email) {
        ActionService.sendEmail(getView().getActivity(), email);
    }

    public void onDelete(String name) {
        getView().deleteListItem(name);
    }
}
