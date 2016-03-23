package com.dorukkangal.android.mvc.contact;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.dorukkangal.android.library.dao.Contact;
import com.dorukkangal.android.library.dao.ContactDaoManager;
import com.dorukkangal.android.library.service.ActionService;
import com.dorukkangal.android.mvc.base.BaseMvcActivity;

import java.util.List;

/**
 * Created by polata on 22/03/2016.
 */
public class ContactsActivity extends BaseMvcActivity implements ContactListController {

    @Override
    protected Fragment getContainedFragment() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final List<Contact> contacts = ContactDaoManager.getAllContacts();
        addFragment(ContactListFragment.newInstance(contacts));
    }

    @Override
    public void onCall(String phone) {
        ActionService.makeCall(this, phone);
    }

    @Override
    public void onSendEmail(String email) {
        ActionService.sendEmail(this, email);
    }

    @Override
    public void onDelete(String name) {

        if (ContactDaoManager.deleteContact(name)) {
            final ContactListFragment fragment = getRegisteredFragment(ContactListFragment.class);
            if (fragment != null) {
                fragment.deleteListItem(name);
            }
        }
    }
}
