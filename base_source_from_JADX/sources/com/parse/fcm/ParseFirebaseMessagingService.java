package com.parse.fcm;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.parse.PLog;
import com.parse.PushRouter;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseFirebaseMessagingService extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        JSONObject jSONObject;
        super.onMessageReceived(remoteMessage);
        PLog.m8814d("ParseFCM", "onMessageReceived");
        String str = remoteMessage.getData().get("push_id");
        String str2 = remoteMessage.getData().get("time");
        String str3 = remoteMessage.getData().get("data");
        String str4 = remoteMessage.getData().get("channel");
        if (str3 != null) {
            try {
                jSONObject = new JSONObject(str3);
            } catch (JSONException e) {
                PLog.m8817e("ParseFCM", "Ignoring push because of JSON exception while processing: " + str3, e);
                return;
            }
        } else {
            jSONObject = null;
        }
        PushRouter.getInstance().handlePush(str, str2, str4, jSONObject);
    }

    public void onNewToken(String str) {
        super.onNewToken(str);
        ParseFCM.register(str);
    }
}
