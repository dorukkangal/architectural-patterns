package com.dorukkangal.android.mvvm.contact;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import com.dorukkangal.android.library.dao.Contact;
import com.dorukkangal.android.library.dao.ContactDaoManager;
import com.dorukkangal.android.mvvm.base.BaseViewModel;
import com.dorukkangal.android.mvvm.service.ActionService;

import java.util.List;

import javax.inject.Inject;

/**
 * @author Doruk Kangal
 */
public class ContactListViewModel extends BaseViewModel {

    private ObservableArrayList<ContactItemViewModel> contacts = new ObservableArrayList<>();

    private ObservableBoolean dataLoaded = new ObservableBoolean();

    @Inject
    ActionService actionService;

    private final Action<Contact> callAction = new Action<Contact>() {
        @Override
        public void perform(Contact contact) {
            actionService.makeCall(contact.getPhone());
        }
    };

    private final Action<Contact> sendEmailAction = new Action<Contact>() {
        @Override
        public void perform(Contact contact) {
            actionService.sendEmail(contact.getEmail());
        }
    };

    private final Action<Contact> deleteAction = new Action<Contact>() {
        @Override
        public void perform(Contact contact) {
            for (int i = 0; i < contacts.size(); i++) {
                if (contact.equals(contacts.get(i).getContact().get())) {
                    contacts.remove(i);
                    break;
                }
            }
        }
    };

    @Override
    public void attachView() {
        super.attachView();

        final List<Contact> results = ContactDaoManager.getAllContacts();
        onQueryComplete(results);
    }

    private void onQueryComplete(List<Contact> results) {
        dataLoaded.set(true);

        contacts.clear();
        for (Contact contact : results) {
            contacts.add(new ContactItemViewModel(contact, callAction, sendEmailAction, deleteAction));
        }
    }

    public ObservableArrayList<ContactItemViewModel> getContacts() {
        return contacts;
    }

    public ObservableBoolean isDataLoaded() {
        return dataLoaded;
    }
}
