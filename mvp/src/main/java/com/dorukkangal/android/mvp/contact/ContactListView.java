package com.dorukkangal.android.mvp.contact;

import com.dorukkangal.android.mvp.base.BaseView;
import com.dorukkangal.android.library.dao.Contact;

import java.util.List;

/**
 * @author Doruk Kangal
 */
public interface ContactListView extends BaseView {

    void setDataLoaded(boolean dataLoaded);

    void setItems(List<Contact> results);

    void deleteListItem(String name);
}
