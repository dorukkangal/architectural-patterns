package com.dorukkangal.android.mvc.contact;

import com.dorukkangal.android.mvc.base.BaseMvcController;

/**
 * Created by polata on 22/03/2016.
 */
public interface ContactListController extends BaseMvcController {
    void onCall(String phone);

    void onSendEmail(String email);

    void onDelete(String name);
}
