package com.dorukkangal.android.mvvm.contact;

import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.view.View;

import com.dorukkangal.android.library.dao.Contact;
import com.dorukkangal.android.mvvm.base.BaseViewModel;

/**
 * @author Doruk Kangal
 */
public class ContactItemViewModel extends BaseViewModel {

    @Bindable
    private final ObservableField<Contact> contact = new ObservableField<>();

    private final Action<Contact> callAction;
    private final Action<Contact> sendEmailAction;
    private final Action<Contact> deleteAction;

    public ContactItemViewModel(Contact contact,
                                Action<Contact> callAction,
                                Action<Contact> sendEmailAction,
                                Action<Contact> deleteAction) {

        this.contact.set(contact);
        this.callAction = callAction;
        this.sendEmailAction = sendEmailAction;
        this.deleteAction = deleteAction;
    }

    public void onCallClick(View v) {
        callAction.perform(contact.get());
    }

    public void onSendEmailClick(View v) {
        sendEmailAction.perform(contact.get());
    }

    public void onDeleteClick(View v) {
        deleteAction.perform(contact.get());
    }

    public ObservableField<Contact> getContact() {
        return contact;
    }
}
