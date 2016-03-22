package com.dorukkangal.android.library.service;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.util.Log;

/**
 * @author Doruk Kangal
 */
public final class ActionService {
    private static final String DIAL_URI = "tel";
    private static final String EMAIL_SUBJECT = "World of List View";
    private static final String EMAIL_TEXT = "Hello";
    private static final String EMAIL_TYPE = "plain/text";

    public static void makeCall(Activity activity, String phone) {
        final Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(DIAL_URI, phone, null));
        activity.startActivity(callIntent);
    }

    public static void sendEmail(Activity activity, String email) {
        final Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType(EMAIL_TYPE);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, EMAIL_SUBJECT);
        emailIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(EMAIL_TEXT));
        try {
            activity.startActivity(emailIntent);
        } catch (android.content.ActivityNotFoundException e) {
            Log.e(ActionService.class.getSimpleName(), "Email client not found", e);
        }
    }
}
