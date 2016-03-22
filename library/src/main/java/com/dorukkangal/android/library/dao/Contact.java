package com.dorukkangal.android.library.dao;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Doruk Kangal
 */
public class Contact implements Parcelable {

    private final String name;
    private final String email;
    private final String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.email);
        dest.writeString(this.phone);
    }

    protected Contact(Parcel in) {
        this.name = in.readString();
        this.email = in.readString();
        this.phone = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
