package com.cyberneid.disigon.p134b;

import android.content.SharedPreferences;
import com.cyberneid.disigon.MainApplication;

/* renamed from: com.cyberneid.disigon.b.b */
public class C2078b {

    /* renamed from: a */
    private static SharedPreferences f6501a = MainApplication.m8072a().getSharedPreferences(MainApplication.class.getName(), 0);

    /* renamed from: a */
    public static String m8279a(String str, String str2) {
        return f6501a.getString(str, str2);
    }

    /* renamed from: a */
    public static boolean m8280a(String str, boolean z) {
        return f6501a.getBoolean(str, z);
    }

    /* renamed from: b */
    public static void m8281b(String str, String str2) {
        SharedPreferences.Editor edit = f6501a.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    /* renamed from: b */
    public static void m8282b(String str, boolean z) {
        SharedPreferences.Editor edit = f6501a.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }
}
