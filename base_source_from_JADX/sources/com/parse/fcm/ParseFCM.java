package com.parse.fcm;

import com.parse.PLog;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.SaveCallback;

public class ParseFCM {
    private static final String PUSH_TYPE = "gcm";
    static final String TAG = "ParseFCM";

    public static void register(String str) {
        PLog.m8814d(TAG, "Updating FCM token");
        ParseInstallation currentInstallation = ParseInstallation.getCurrentInstallation();
        if (currentInstallation != null && str != null) {
            currentInstallation.setDeviceToken(str);
            currentInstallation.setPushType(PUSH_TYPE);
            currentInstallation.saveInBackground(new SaveCallback() {
                public void done(ParseException parseException) {
                    if (parseException == null) {
                        PLog.m8814d(ParseFCM.TAG, "FCM token saved to installation");
                    } else {
                        PLog.m8817e(ParseFCM.TAG, "FCM token upload failed", parseException);
                    }
                }
            });
        }
    }
}
