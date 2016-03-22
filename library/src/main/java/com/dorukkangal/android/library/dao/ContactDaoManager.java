package com.dorukkangal.android.library.dao;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Doruk Kangal
 */
public final class ContactDaoManager {

    private static List<Contact> contacts;

    public static List<Contact> getAllContacts() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return contacts;
    }

    public static boolean deleteContact(String name) {
        return !TextUtils.isEmpty(name);
    }

    static {
        contacts = new ArrayList<>();
        contacts.add(new Contact("Anthony Walker", "anthony.walker@gmail.com", "+905311234567"));
        contacts.add(new Contact("Blake Payne", "blake.payne@gmail.com", "+905311234567"));
        contacts.add(new Contact("Eric Johnston", "eric.johnston@gmail.com", "+905311234567"));
        contacts.add(new Contact("Evan Mackenzie", "evan.mackenzie@gmail.com", "+905311234567"));
        contacts.add(new Contact("Edward Duncan", "edward.duncan@gmail.com", "+905311234567"));
        contacts.add(new Contact("Gavin Smith", "gavin.smith@gmail.com", "+905311234567"));
        contacts.add(new Contact("John Doe", "john.doe@gmail.com", "+905311234567"));
        contacts.add(new Contact("Peter Fisher", "peter.fisher@gmail.com", "+905311234567"));
        contacts.add(new Contact("Robert Mills", "robert.mills@gmail.com", "+905311234567"));
        contacts.add(new Contact("Simon Oliver", "simon.oliver@gmail.com", "+905311234567"));
        contacts.add(new Contact("Simon Oliver", "simon.oliver@gmail.com", "+905311234567"));
    }
}


