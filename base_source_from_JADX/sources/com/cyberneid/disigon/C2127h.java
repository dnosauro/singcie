package com.cyberneid.disigon;

import android.os.Build;
import android.util.Log;
import com.parse.ParseException;
import com.parse.ParseObject;
import java.util.Locale;

/* renamed from: com.cyberneid.disigon.h */
public class C2127h {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m8375a(ParseException parseException) {
        if (parseException == null) {
            Log.d("ParseHelper", "Verification Saved");
        } else {
            parseException.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m8376a(String str) {
        ParseObject create = ParseObject.create("Signature");
        create.put("type", str);
        create.put("os", "Android");
        create.put("osVersion", Build.VERSION.RELEASE);
        create.put("appVersion", "1.1.5");
        create.put("device", MainApplication.m8078d());
        create.put("deviceId", MainApplication.m8079e());
        create.put("language", Locale.getDefault().toLanguageTag());
        create.saveEventually($$Lambda$h$jv7uR_lQV21wI4y3oxIplFBcVpY.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m8377b(ParseException parseException) {
        if (parseException == null) {
            Log.d("ParseHelper", "Verification Saved");
        } else {
            parseException.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m8378b(String str) {
        ParseObject create = ParseObject.create("Verification");
        create.put("type", str);
        create.put("os", "Android");
        create.put("osVersion", Build.VERSION.RELEASE);
        create.put("appVersion", "1.1.5");
        create.put("device", MainApplication.m8078d());
        create.put("deviceId", MainApplication.m8079e());
        create.put("language", Locale.getDefault().toLanguageTag());
        create.saveEventually($$Lambda$h$nw5vmGLSbf7gHO2hzVcpxsIOVOc.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m8379c(ParseException parseException) {
        if (parseException == null) {
            Log.d("ParseHelper", "Signature Saved");
        } else {
            parseException.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m8380c(String str) {
        ParseObject create = ParseObject.create("Event");
        create.put("type", str);
        create.put("os", "Android");
        create.put("osVersion", Build.VERSION.RELEASE);
        create.put("appVersion", "1.1.5");
        create.put("device", MainApplication.m8078d());
        create.put("deviceId", MainApplication.m8079e());
        create.put("language", Locale.getDefault().toLanguageTag());
        create.saveEventually($$Lambda$h$rkJME_gv5NIyC7RTYvYF9a7hC8.INSTANCE);
    }
}
